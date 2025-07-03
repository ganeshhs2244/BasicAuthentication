package com.m31.springSecurity.helper;

import com.m31.springSecurity.entity.CustomUser;
import com.m31.springSecurity.repository.UserDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreation implements CommandLineRunner {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        if(userDetailsRepo.findByUserName("admin").isEmpty())
        {
            log.info("Creating Base User");
            CustomUser user =new CustomUser();
            user.setUserName("admin");
            user.setPassword(passwordEncoder.encode("admin123"));
            user.setRole("ADMIN");
            userDetailsRepo.save(user);
            log.info( user.getUsername()+ "User CREATED");
        }else
            log.warn("user Already Present");
    }
}
