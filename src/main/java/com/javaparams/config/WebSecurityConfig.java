package com.javaparams.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/css/**", "/js/**", "/webjars/**", "/actuator/**").permitAll()
                        .requestMatchers("/api/parameter/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(withDefaults())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/parameter/**") // ou use token CSRF
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("fernando")
                .password("{bcrypt}$2a$10$N/JkyAmIDX70am/U3PPP7uiWuRHH9VklzpjKP9ugAe2t6tAnNWLjq")
                .roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Gerador de senha
     *
     * @param args
     */
    public static void main(String[] args) {
        String senhaAdmin = "boaglio123";
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println("senha = " + encoder.encode(senhaAdmin));
    }

}