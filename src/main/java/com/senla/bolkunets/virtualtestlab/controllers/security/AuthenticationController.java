package com.senla.bolkunets.virtualtestlab.controllers.security;

import com.senla.bolkunets.virtualtestlab.controllers.security.dto.TokenDto;
import com.senla.bolkunets.virtualtestlab.controllers.security.dto.UserCredentialsDto;
import com.senla.bolkunets.virtualtestlab.security.services.TokenService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class AuthenticationController {


    private TokenService tokenService;

    private DozerBeanMapper dozerBeanMapper;

    @Autowired
    public AuthenticationController(TokenService tokenService, DozerBeanMapper dozerBeanMapper) {
        this.tokenService = tokenService;
        this.dozerBeanMapper = dozerBeanMapper;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public TokenDto getToken(@RequestBody UserCredentialsDto userCredentialsDto) throws Exception {
        String token = tokenService.createToken(userCredentialsDto.getLogin(), userCredentialsDto.getPassword());
        if(token == null) {
            throw new Exception("invalid creds");
        }
        String role = tokenService.getUserRole(userCredentialsDto.getLogin());
        TokenDto tokenDto = new TokenDto();
        tokenDto.setSuccess(true);
        tokenDto.setToken(token);
        tokenDto.setUserRole(role);
        return tokenDto;
    }


    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public TokenDto getToken(@RequestBody TokenDto tokenDto){
        //TODO
        return tokenDto;
    }

}
