package com.senla.bolkunets.virtualtestlab.controllers.methodics.description;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.*;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import com.senla.bolkunets.virtualtestlab.security.holder.CurrentUserHolder;
import com.senla.bolkunets.virtualtestlab.security.model.User;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/methodics/description")
public class MethodicsDescriptionsController {

    private MethodicsService methodicsService;

    private DozerBeanMapper dozerBeanMapper;

    private CurrentUserHolder currentUserHolder;

    public MethodicsDescriptionsController(MethodicsService methodicsService, DozerBeanMapper dozerBeanMapper, CurrentUserHolder currentUserHolder) {
        this.methodicsService = methodicsService;
        this.dozerBeanMapper = dozerBeanMapper;
        this.currentUserHolder = currentUserHolder;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<MethodicsDescriptionDto> getDescriptions(){
        final List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<MethodicsDescriptionDto>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getAllMethodics();
        for(Methodics methodics : allMethodicsDescriptions){
            MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
            methodicsDescriptionDtoList.add(methodicsDescriptionDto);
        }
        return methodicsDescriptionDtoList;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MethodicsDescriptionDto getDescription(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.findById(id);
        return dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
    }

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public List<MethodicsDescriptionDto> getOpenMethodicsForUser(){
        User user = currentUserHolder.getCurrentUser();
        final List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<MethodicsDescriptionDto>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getNoPassedMethodicsByUserProfile(user.getUserId());
        if(allMethodicsDescriptions!=null) {
            for (Methodics methodics : allMethodicsDescriptions) {
                MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
                methodicsDescriptionDtoList.add(methodicsDescriptionDto);
            }
        }
        return methodicsDescriptionDtoList;
    }

    @RequestMapping(value = "/passed", method = RequestMethod.GET)
    public List<MethodicsDescriptionDto> getPassedMethodicsForUser(){
        User user = currentUserHolder.getCurrentUser();
        final List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<MethodicsDescriptionDto>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getPassedMethodicsByUserProfile(user.getUserId());
        if(allMethodicsDescriptions!=null) {
            for (Methodics methodics : allMethodicsDescriptions) {
                MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
                methodicsDescriptionDtoList.add(methodicsDescriptionDto);
            }
        }
        return methodicsDescriptionDtoList;
    }

    @RequestMapping(value = "/open/{userID}")
    public List<MethodicsDescriptionDto> getOpenMethodicsByUserId(@PathVariable(value = "userID") Integer userId){

        List<MethodicsDescriptionDto> methodicsDescriptionDtoList = new ArrayList<>();
        List<Methodics> allMethodicsDescriptions = methodicsService.getAssignedMethodicsByUserProfile(userId);
        if(allMethodicsDescriptions!=null) {
            for (Methodics methodics : allMethodicsDescriptions) {
                MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(methodics, MethodicsDescriptionDto.class);
                methodicsDescriptionDtoList.add(methodicsDescriptionDto);
            }
        }
        return methodicsDescriptionDtoList;
    }

}
