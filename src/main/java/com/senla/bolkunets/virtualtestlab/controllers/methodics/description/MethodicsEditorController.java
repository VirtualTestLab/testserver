package com.senla.bolkunets.virtualtestlab.controllers.methodics.description;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.FullMethodicsDto;
import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.MethodicsDescriptionDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/methodics/editor")
public class MethodicsEditorController {

    private MethodicsService methodicsService;

    private DozerBeanMapper dozerBeanMapper;

    public MethodicsEditorController(MethodicsService methodicsService, DozerBeanMapper dozerBeanMapper) {
        this.methodicsService = methodicsService;
        this.dozerBeanMapper = dozerBeanMapper;
    }


    @RequestMapping(value = "/create", method = RequestMethod.PUT)
    public MethodicsDescriptionDto createMethodics(@RequestBody FullMethodicsDto methodicsDto){
        Methodics methodics = dozerBeanMapper.map(methodicsDto, Methodics.class);
        Methodics persistMethodics = methodicsService.createMethodics(methodics);
        MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(persistMethodics, MethodicsDescriptionDto.class);
        return methodicsDescriptionDto;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public MethodicsDescriptionDto updateMethodics(@RequestBody FullMethodicsDto methodicsDto){
        Methodics methodics = dozerBeanMapper.map(methodicsDto, Methodics.class);
        Methodics persistMethodics = methodicsService.updateMethodics(methodics);
        MethodicsDescriptionDto methodicsDescriptionDto = dozerBeanMapper.map(persistMethodics, MethodicsDescriptionDto.class);
        return methodicsDescriptionDto;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseMessageDto createMethodics(@PathVariable(name = "id") Integer id){
        methodicsService.deleteMethodicsById(id);
        return dozerBeanMapper.map("deleted", ResponseMessageDto.class);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public FullMethodicsDto getFullMethodics(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.getFullMethodics(id);
        return dozerBeanMapper.map(methodics, FullMethodicsDto.class);
    }


}
