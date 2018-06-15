package com.senla.bolkunets.virtualtestlab.controllers.dto.converters;

import com.senla.bolkunets.virtualtestlab.controllers.security.dto.TokenDto;
import org.dozer.DozerConverter;

public class TokenDtoConverter extends DozerConverter<TokenDto, String> {
    public TokenDtoConverter() {
        super(TokenDto.class, String.class);
    }

    @Override
    public String convertTo(TokenDto tokenDto, String s) {
        return tokenDto.getToken();
    }

    @Override
    public TokenDto convertFrom(String token, TokenDto tokenDto) {
        tokenDto = new TokenDto();
        if(token == null){
            tokenDto.setSuccess(false);
            return tokenDto;
        }
        tokenDto.setSuccess(true);
        tokenDto.setToken(token);
        return tokenDto;
    }
}
