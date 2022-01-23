package com.errors.center.security;


import com.errors.center.dto.UserCustomDTO;
import com.errors.center.model.User;
import com.errors.center.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            userRepository.save(user);
        }

        builder.userDetailsService(login -> new UserCustomDTO(userRepository.findByLogin(login)));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
