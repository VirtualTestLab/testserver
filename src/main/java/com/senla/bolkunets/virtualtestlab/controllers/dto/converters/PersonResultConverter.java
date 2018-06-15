package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.MethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PersonResultDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

import java.util.ArrayList;
import java.util.List;

public class PersonResultConverter extends DozerConverter<Person, PersonResultDto> implements MapperAware {

    private Mapper mapper;

    public PersonResultConverter() {
        super(Person.class, PersonResultDto.class);
    }

    @Override
    public PersonResultDto convertTo(Person person, PersonResultDto personResultDto) {
        personResultDto = new PersonResultDto();
        List<MethodicsResultDto> methodicsResults = new ArrayList<>();
        List<PassingFact> passingFacts = person.getPassingFacts();
        passingFacts.forEach(passingFact -> methodicsResults.add(mapper.map(passingFact, MethodicsResultDto.class)));

        personResultDto.setAge(person.getAge());
        personResultDto.setCountChildren(person.getCountChildren());
        personResultDto.setGender(person.getGender());
        personResultDto.setId(person.getId());
        personResultDto.setMaritalStatus(person.getMaritalStatus());
        personResultDto.setMethodicsResults(methodicsResults);
        personResultDto.setPlaceResidence(person.getPlaceResidence());

        return personResultDto;
    }

    @Override
    public Person convertFrom(PersonResultDto personResultDto, Person person) {
        return null;
    }

    @Override
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}
