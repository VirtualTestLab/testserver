package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.AnswerQuestionDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PassingFactDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.MethodicsKey;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Question;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.ScaleValue;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerConverter;

import java.util.*;

public class PassingFactConverter extends DozerConverter<PassingFactDto, PassingFact> {

    private MethodicsService methodicsService;

    public PassingFactConverter(MethodicsService methodicsService) {
        super(PassingFactDto.class, PassingFact.class);
        this.methodicsService = methodicsService;
    }


    @Override
    public PassingFact convertTo(PassingFactDto passingFactDto, PassingFact passingFact) {

        HashMap<MethodicsKey, Counter> keyValueMap = new HashMap<>();

        Integer methodicsId = passingFactDto.getMethodicsId();

        passingFact = new PassingFact();
        passingFact.setMethodicsId(methodicsId);
        passingFact.setPassingDate(new Date());
        passingFact.setPersonId(passingFactDto.getPersonId());

        List<AnswerQuestionDto> answers = passingFactDto.getAnswers();

        Methodics methodics = methodicsService.getFullMethodics(methodicsId);

        if(answers==null || methodics==null){
            throw new IllegalArgumentException("dto incorrect");
        }

        Set<Question> questions = methodics.getQuestions();

        if(answers.size() != questions.size()){
            throw new IllegalArgumentException("dto incorrect");
        }

        for(Question question : questions){
            MethodicsKey methodicsKey = question.getMethodicsKey();
            Counter counter = keyValueMap.get(methodicsKey);
            if(counter==null){
                counter = new Counter(0);
                keyValueMap.put(methodicsKey, counter);
            }

            for(AnswerQuestionDto answer: answers){
                if(question.getNumber().equals(answer.getQuestionNumber())){
                    counter.value+=answer.getValue();
                    break;
                }
            }
        }

        List<ScaleValue> scaleValues = new ArrayList<>();

        for(MethodicsKey methodicsKey : keyValueMap.keySet()){
            ScaleValue scaleValue = new ScaleValue();
            scaleValue.setMethodicsKey(methodicsKey);
            scaleValue.setValue(keyValueMap.get(methodicsKey).value);
            scaleValues.add(scaleValue);
        }

        passingFact.setScaleValues(scaleValues);

        return passingFact;
    }

    @Override
    public PassingFactDto convertFrom(PassingFact passingFact, PassingFactDto passingFactDto) {
        return new PassingFactDto();
    }


    private class Counter {
        private int value;

        public Counter(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
