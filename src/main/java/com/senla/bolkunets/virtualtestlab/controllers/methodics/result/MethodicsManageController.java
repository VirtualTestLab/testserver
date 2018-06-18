package com.senla.bolkunets.virtualtestlab.controllers.methodics.result;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import com.senla.bolkunets.virtualtestlab.domain.services.MethodicsService;
import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/methodics/admin/manage")
public class MethodicsManageController {

    private MethodicsService methodicsService;

    private DozerBeanMapper dozerBeanMapper;

    public MethodicsManageController(MethodicsService methodicsService, DozerBeanMapper dozerBeanMapper) {
        this.methodicsService = methodicsService;
        this.dozerBeanMapper = dozerBeanMapper;
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
