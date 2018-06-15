package com.senla.bolkunets.virtualtestlab.security.services.impl;

import com.senla.bolkunets.virtualtestlab.security.model.User;
import com.senla.bolkunets.virtualtestlab.security.services.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource(name = "security.properties", value = "classpath:security.properties" )
public class TokenServiceImpl implements TokenService {

    public static final String USER_ID = "userId";
    public static final String USERNAME = "username";
    public static final String TIME_CREATION_TOKEN = "timeCreationToken";
    public static final String EXPIRATION_TIME = "expirationTime";
    public static final String ROLE = "role";

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${token.secret}")
    private String secretKey;

    @Value("${token.exptime}")
    private Long expirationTime;

    public TokenServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username, String password) throws UsernameNotFoundException {
        if(username == null || password ==  null){
            return null;
        }

        User userDetails = (User) userDetailsService.loadUserByUsername(username);

        if(!password.equals(userDetails.getPassword())){
            return null;
        }

        Date currentTime = new Date();

        Map<String, Object> claimsToken = new HashMap<>();
        claimsToken.put(USER_ID, userDetails.getUserId());
        claimsToken.put(USERNAME, userDetails.getUsername());
        claimsToken.put(TIME_CREATION_TOKEN, currentTime.getTime());
        claimsToken.put(ROLE, userDetails.getRole().getAuthority());
        claimsToken.put(EXPIRATION_TIME, expirationTime);

        JwtBuilder jwtBuilder = Jwts.builder()
                                    .setExpiration(currentTime)
                                    .setClaims(claimsToken)
                                    .signWith(SignatureAlgorithm.HS512,secretKey);

        return jwtBuilder.compact();
    }

    @Override
    public String getUserRole(String username) {
        User userDetails = (User)userDetailsService.loadUserByUsername(username);
        return userDetails.getRole().getAuthority();
    }
}
