package com.senla.bolkunets.virtualtestlab.controllers.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.MethodicsResultDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PassingFactDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result.PersonResultDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.result.PassingFact;
import com.senla.bolkunets.virtualtestlab.domain.model.user.Person;
import com.senla.bolkunets.virtualtestlab.domain.services.PassingFactService;
import com.senla.bolkunets.virtualtestlab.security.holder.CurrentUserHolder;
import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/result/user")
public class MethodicsUserController {

    private PassingFactService passingFactService;

    private DozerBeanMapper dozerBeanMapper;

    private CurrentUserHolder currentUserHolder;

    public MethodicsUserController(CurrentUserHolder currentUserHolder, PassingFactService passingFactService, DozerBeanMapper dozerBeanMapper) {
        this.passingFactService = passingFactService;
        this.dozerBeanMapper = dozerBeanMapper;
        this.currentUserHolder = currentUserHolder;
    }

    @RequestMapping(value = "/save", method = RequestMethod.PUT)
    public ResponseMessageDto create(@RequestBody PassingFactDto passingFactDto){
        User user = currentUserHolder.getCurrentUser();
        PassingFact passingFact = dozerBeanMapper.map(passingFactDto, PassingFact.class);
        passingFact.setPersonId(user.getUserId());
        passingFactService.createPassingFact(passingFact);
        return dozerBeanMapper.map("passing fact was saved", ResponseMessageDto.class);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public ResponseMessageDto create(@RequestParam(name= "userId") Integer userId, @RequestParam(name= "methodicsId") Integer methodicsId){
        passingFactService.deletePassingFactById(userId, methodicsId);
        return dozerBeanMapper.map("passing fact was deleted", ResponseMessageDto.class);
    }

    @RequestMapping(value = "/get/{methodicsId}", method = RequestMethod.GET)
    public MethodicsResultDto getResult(@PathVariable Integer methodicsId){
        User user = currentUserHolder.getCurrentUser();
        PassingFact passingFactForUser = passingFactService.getPassingFactForUser(methodicsId, user.getUserId());
        return dozerBeanMapper.map(passingFactForUser, MethodicsResultDto.class);
    }

}
