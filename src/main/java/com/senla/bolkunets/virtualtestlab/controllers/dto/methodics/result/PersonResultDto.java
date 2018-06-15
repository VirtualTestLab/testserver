package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.userprofile.PersonInformationDto;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Gender;
import com.senla.bolkunets.virtualtestlab.domain.model.user.MaritalStatus;
import com.senla.bolkunets.virtualtestlab.domain.model.user.PlaceResidence;

import java.util.List;

public class PersonResultDto extends PersonInformationDto {

    private List<MethodicsResultDto> methodicsResults;
    
    public List<MethodicsResultDto> getMethodicsResults() {
        return methodicsResults;
    }

    public void setMethodicsResults(List<MethodicsResultDto> methodicsResults) {
        this.methodicsResults = methodicsResults;
    }
}
