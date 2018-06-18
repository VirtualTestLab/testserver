package com.senla.bolkunets.virtualtestlab.controllers.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.MethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PassingFactDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PersonResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PersonalMethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.services.PassingFactService;
import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/result/admin")
public class MethodicsResultController {

    private PassingFactService passingFactService;

    private DozerBeanMapper dozerBeanMapper;

    public MethodicsResultController(PassingFactService passingFactService, DozerBeanMapper dozerBeanMapper) {
        this.passingFactService = passingFactService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/getuserresult", method = RequestMethod.GET)
    public MethodicsResultDto getResult(@RequestParam(value="userId") Integer userId, @RequestParam(value="methodicsId") Integer methodicsId){
        PassingFact passingFactForUser = passingFactService.getPassingFactForUser(methodicsId, userId);
        return dozerBeanMapper.map(passingFactForUser, MethodicsResultDto.class);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<PersonResultDto> getResults(){
        List<PersonResultDto> people = new ArrayList<>();
        List<Person> allPersonWithPassedMethodics = passingFactService.getAllPersonWithPassedMethodics();
        allPersonWithPassedMethodics.forEach(person -> people.add(dozerBeanMapper.map(person, PersonResultDto.class)));
        return people;
    }

    //TODO
    @RequestMapping(value = "/get/{methodicsId}", method = RequestMethod.GET)
    public List<PersonalMethodicsResultDto> getResultMethodics(@PathVariable Integer methodicsId){
        List<PersonalMethodicsResultDto> people = new ArrayList<>();
        List<PassingFact> allPersonWithPassedMethodics = passingFactService.getPassingFactsByMethodics(methodicsId);
        allPersonWithPassedMethodics.forEach(person -> people.add(dozerBeanMapper.map(person, PersonalMethodicsResultDto.class)));
        return people;
    }




}
