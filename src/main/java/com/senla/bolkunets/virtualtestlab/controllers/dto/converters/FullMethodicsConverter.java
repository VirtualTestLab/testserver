package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.FullMethodicsDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.MethodicsKeyDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.QuestionsDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.MethodicsKey;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Question;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import org.springframework.stereotype.Component;

import java.util.*;

public class FullMethodicsConverter extends DozerConverter<FullMethodicsDto, Methodics> implements MapperAware{

    private Mapper mapper;

    public FullMethodicsConverter() {
        super(FullMethodicsDto.class, Methodics.class);
    }


    private QuestionsDto convert(Question question) {
        return mapper.map(question, QuestionsDto.class);
    }

    private MethodicsKeyDto convert(MethodicsKey methodicsKey) {
        MethodicsKeyDto methodicsKeyDto = mapper.map(methodicsKey, MethodicsKeyDto.class);
        methodicsKeyDto.setNumbersQuestions(new ArrayList<>());
        return methodicsKeyDto;
    }
    private MethodicsKey convert(MethodicsKeyDto methodicsKeyDto) {
        return mapper.map(methodicsKeyDto, MethodicsKey.class);
    }


    private Question convert(QuestionsDto questionsDto) {
        return mapper.map(questionsDto, Question.class);
    }

    @Override
    public FullMethodicsDto convertFrom(Methodics methodics, FullMethodicsDto methodicsDto) {
        methodicsDto = new FullMethodicsDto();
        List<QuestionsDto> questionsDtos = new ArrayList<>();
        HashMap<Integer, MethodicsKeyDto> methodicsKeyDtoHashMap = new HashMap<>();

        methodicsDto.setId(methodics.getId());
        methodicsDto.setDescription(methodics.getDescription());
        methodicsDto.setName(methodics.getName());
        methodicsDto.setLeftValueBorder(methodics.getLeftValueBorder());
        methodicsDto.setRightValueBorder(methodics.getRightValueBorder());

        methodics.getKeys().forEach(
                methodicsKey -> {
                    MethodicsKeyDto methodicsKeyDto = convert(methodicsKey);
                    methodicsKeyDtoHashMap.put(methodicsKeyDto.getId(), methodicsKeyDto);
                });

        methodics.getQuestions().forEach(
                question -> {
                    MethodicsKeyDto methodicsKeyDto = methodicsKeyDtoHashMap.get(question.getMethodicsKey().getId());
                    methodicsKeyDto.getNumbersQuestions().add(question.getNumber());
                    QuestionsDto questionsDto = convert(question);
                    questionsDtos.add(questionsDto);

                }
        );

        methodicsDto.setQuestionsDtos(questionsDtos);
        methodicsDto.setMethodicsKeyDtoList(new ArrayList<>(methodicsKeyDtoHashMap.values()));


        return methodicsDto;

    }

    @Override
    public Methodics convertTo(FullMethodicsDto methodicsDto, Methodics methodics) {
        methodics = new Methodics();
        HashMap<Integer, Question> questionMap = new HashMap<>();

        List<QuestionsDto> questionsDtos = methodicsDto.getQuestionsDtos();
        questionsDtos.forEach(x -> questionMap.put(x.getNumber(), convert(x)));

        List<MethodicsKey> methodicsKeys = new ArrayList<>();

        List<MethodicsKeyDto> methodicsKeyDtos = methodicsDto.getMethodicsKeyDtoList();

        for (MethodicsKeyDto methodicsKeyDto : methodicsKeyDtos) {

            MethodicsKey methodicsKey = convert(methodicsKeyDto);

            List<Integer> numbersQuestions = methodicsKeyDto.getNumbersQuestions();

            for (Integer numberQuestion : numbersQuestions) {

                Question question = questionMap.get(numberQuestion);
                if (question != null) {
                    question.setMethodicsKey(methodicsKey);
                }

            }

            methodicsKeys.add(methodicsKey);


        }

        methodics.setId(methodicsDto.getId());
        methodics.setDescription(methodicsDto.getDescription());
        methodics.setLeftValueBorder(methodicsDto.getLeftValueBorder());
        methodics.setRightValueBorder(methodicsDto.getRightValueBorder());
        methodics.setName(methodicsDto.getName());
        Set<Question> questions = new HashSet<>(questionMap.values());
        methodics.setQuestions(questions);
        methodics.setKeys(methodicsKeys);
        return methodics;
    }

    @Override
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}
