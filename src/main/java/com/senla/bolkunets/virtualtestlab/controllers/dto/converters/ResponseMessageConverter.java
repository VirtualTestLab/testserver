package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.dto.messages.ResponseMessageDto;
import org.dozer.DozerConverter;

public class ResponseMessageConverter extends DozerConverter<ResponseMessageDto, String> {
    public ResponseMessageConverter() {
        super(ResponseMessageDto.class, String.class);
    }

    @Override
    public String convertTo(ResponseMessageDto responseMessageDto, String message) {
        return responseMessageDto.getMessage();
    }

    @Override
    public ResponseMessageDto convertFrom(String message, ResponseMessageDto responseMessageDto) {
        responseMessageDto = new ResponseMessageDto();
        responseMessageDto.setMessage(message);
        return responseMessageDto;
    }
}
