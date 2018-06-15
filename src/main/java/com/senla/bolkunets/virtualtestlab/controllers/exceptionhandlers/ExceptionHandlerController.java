package com.senla.bolkunets.virtualtestlab.controllers.exceptionhandlers;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    static Logger logger = Logger.getLogger(ExceptionHandlerController.class);

    private DozerBeanMapper dozerBeanMapper;

    public ExceptionHandlerController(DozerBeanMapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dozerBeanMapper.map("operation not performed", ResponseMessageDto.class));
    }

}
