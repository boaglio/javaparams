package com.javaparams.controller;

import com.javaparams.repo.ParameterRepository;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class LoginController {

    private final ParameterRepository parameterRepository;

    public LoginController(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/oauth2/authorization/github";
    }

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken authentication, Model model) {
        if (authentication != null) {
            var oauthUser = authentication.getPrincipal();
            var name = oauthUser.getAttribute("name"); // ou "login" se "name" for null
            if (name == null) {
                name = oauthUser.getAttribute("login");
            }
            model.addAttribute("name", name);
        }

        var params = parameterRepository.findTop12ByOrderByTotalLikesDesc();
        params.forEach(p -> {
                    if (Objects.isNull(p.getTotalLikes()))  p.setTotalLikes(0L);
        });
        model.addAttribute("params", params);

        return "index";
    }
}
