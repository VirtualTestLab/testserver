package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.PersonInformationDto;

public class PersonalMethodicsResultDto extends MethodicsResultDto {

    private PersonInformationDto personInformationDto;

    public PersonInformationDto getPersonInformationDto() {
        return personInformationDto;
    }

    public void setPersonInformationDto(PersonInformationDto personInformationDto) {
        this.personInformationDto = personInformationDto;
    }
}
