package com.javaparams.api;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaparams.domain.User;
import com.javaparams.repo.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

	private static final Logger log = LoggerFactory.getLogger(UserAPI.class.getName());

    private final OAuth2AuthorizedClientService authorizedClientService;

    private final UserRepository repository;

    public UserAPI(OAuth2AuthorizedClientService authorizedClientService, UserRepository repository) {
        this.authorizedClientService = authorizedClientService;
        this.repository = repository;
    }

    @GetMapping("/info")
    public User userInfo(OAuth2AuthenticationToken authentication) {

        var client = authorizedClientService
                .loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        var loggedUser = new User("-1", "Anonymous", LocalDateTime.now());
        if (client != null) {
            loggedUser = new User(client.getPrincipalName(), authentication.getPrincipal().getAttribute("login"),
                    LocalDateTime.now());
        }

        return loggedUser;
    }

    @GetMapping("/add")
    public String add(OAuth2AuthenticationToken authentication) {

        String response = null;
        User loggedUser = null;

        var client = authorizedClientService
                .loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        try {

            loggedUser = new User("-1", "Anonymous", LocalDateTime.now());

            if (client != null) {

                loggedUser = new User(client.getPrincipalName(), authentication.getPrincipal().getAttribute("login"),
                        LocalDateTime.now());

                repository.save(loggedUser);

                response = HttpStatus.OK.getReasonPhrase();
            }

        } catch (DataAccessException dae) {

            response = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

            log.info("User: " + loggedUser + " error: " + dae.getMessage());
        }

        return response;
    }

}
