package com.senla.bolkunets.virtualtestlab.controllers.methodics.description;

import com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description.MethodicsWithQuestionsDto;
import com.senla.bolkunets.virtualtestlab.domain.model.methodics.description.Methodics;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/methodics")
public class MethodicsController {

    private MethodicsService methodicsService;

    private DozerBeanMapper dozerBeanMapper;

    public MethodicsController(MethodicsService methodicsService, DozerBeanMapper dozerBeanMapper) {
        this.methodicsService = methodicsService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public MethodicsWithQuestionsDto getMethodicsById(@PathVariable(name = "id") Integer id){
        Methodics methodics = methodicsService.getMethodicsWithQuestions(id);
        return dozerBeanMapper.map(methodics, MethodicsWithQuestionsDto.class);
    }

}
