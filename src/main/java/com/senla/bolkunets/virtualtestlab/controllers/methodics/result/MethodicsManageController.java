package com.senla.bolkunets.virtualtestlab.controllers.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import com.senla.bolkunets.virtualtestlab.domain.services.PassingFactService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/methodics/admin/manage")
public class MethodicsManageController {

    private PassingFactService passingFactService;

    private MethodicsService methodicsService;

    private DozerBeanMapper dozerBeanMapper;

    public MethodicsManageController(PassingFactService passingFactService, MethodicsService methodicsService,
            DozerBeanMapper dozerBeanMapper) {
        this.methodicsService = methodicsService;
        this.dozerBeanMapper = dozerBeanMapper;
        this.passingFactService = passingFactService;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseMessageDto create(@RequestParam(name= "userId") Integer userId, @RequestParam(name= "methodicsId") Integer methodicsId){
        passingFactService.deletePassingFactById(userId, methodicsId);
        return dozerBeanMapper.map("passing fact was deleted", ResponseMessageDto.class);
    }

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public ResponseMessageDto openForUser( @RequestParam(value="userId") Integer userId, @RequestParam(value="methodicsId") Integer methodicsId)
            throws Exception {
        boolean isSuccess = methodicsService.openMethodicsForUser(methodicsId, userId);
        if(!isSuccess) {
            throw new Exception();
        }
        return dozerBeanMapper.map(String.format("Metodics %s was opened for user %s", methodicsId, userId), ResponseMessageDto.class);
    }




}
