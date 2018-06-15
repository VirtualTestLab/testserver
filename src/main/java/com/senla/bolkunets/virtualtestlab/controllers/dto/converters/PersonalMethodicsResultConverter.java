package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.MethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PersonalMethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.PersonInformationDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import com.senla.bolkunets.virtualtestlab.domain.services.PersonService;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

public class PersonalMethodicsResultConverter extends DozerConverter<PassingFact, PersonalMethodicsResultDto> implements MapperAware {


    private Mapper mapper;
    private PersonService personService;

    public PersonalMethodicsResultConverter(PersonService personService) {
        super(PassingFact.class, PersonalMethodicsResultDto.class);
        this.personService = personService;
    }

    @Override
    public PersonalMethodicsResultDto convertTo(PassingFact passingFact, PersonalMethodicsResultDto personalMethodicsResultDto) {
        personalMethodicsResultDto = new PersonalMethodicsResultDto();
        MethodicsResultDto methodicsResultDto = mapper.map(passingFact, MethodicsResultDto.class);
        if(methodicsResultDto!=null) {
            personalMethodicsResultDto.setMethodicsName(methodicsResultDto.getMethodicsName());
            personalMethodicsResultDto.setScales(methodicsResultDto.getScales());
        }
        Person personInformation = personService.getPersonInformation(passingFact.getPersonId());
        PersonInformationDto personInformationDto = mapper.map(personInformation, PersonInformationDto.class);
        personalMethodicsResultDto.setPersonInformationDto(personInformationDto);
        return personalMethodicsResultDto;
    }

    @Override
    public PassingFact convertFrom(PersonalMethodicsResultDto personalMethodicsResultDto, PassingFact passingFact) {
        return null;
    }

    @Override
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
}
