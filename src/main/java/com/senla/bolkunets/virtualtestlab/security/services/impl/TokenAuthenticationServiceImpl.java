package com.senla.bolkunets.virtualtestlab.security.services.impl;

import com.senla.bolkunets.virtualtestlab.security.model.User;
import com.senla.bolkunets.virtualtestlab.security.model.UserAuthentication;
import com.senla.bolkunets.virtualtestlab.security.services.TokenAuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@PropertySource(name = "security.properties", value = "classpath:security.properties" )
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

    private static Logger logger = Logger.getLogger(TokenAuthenticationServiceImpl.class);

    @Value("${token.secret}")
    private String key;

    @Value("authorization")
    private String headerName;

    private UserDetailsService userDetailsService;

    public TokenAuthenticationServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(HttpServletRequest request) {
        String token = request.getHeader(headerName);
        Jws<Claims> claims = this.parseToken(token);

        if(claims==null){
            return null;
        }

        User userProfile = getUserFromToken(claims);
        if(userProfile==null){
            return null;
        }

        return new UserAuthentication(userProfile);
    }

    private Jws<Claims> parseToken(String token) {
        if(token == null){
            return null;
        }
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token.substring(7));
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }

    }

    private User getUserFromToken(Jws<Claims> claimsJws){
        return (User) userDetailsService.loadUserByUsername(claimsJws.getBody().get("username").toString());
    }
}
