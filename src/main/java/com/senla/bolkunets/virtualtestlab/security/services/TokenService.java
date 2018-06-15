package com.senla.bolkunets.virtualtestlab.security.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface TokenService {

    String createToken(String username, String password) throws UsernameNotFoundException;

    String getUserRole(String username);
}
