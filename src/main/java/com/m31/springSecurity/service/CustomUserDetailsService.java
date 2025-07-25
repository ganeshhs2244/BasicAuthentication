package com.m31.springSecurity.service;

import com.m31.springSecurity.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDetailsRepo userDetailsRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userDetailsRepo.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("User Not Found Exception"));
    }
}
