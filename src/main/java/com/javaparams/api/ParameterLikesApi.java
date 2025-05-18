package com.javaparams.api;

import com.javaparams.domain.Vote;
import com.javaparams.repo.ParameterRepository;
import com.javaparams.repo.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/parameter")
public class ParameterLikesApi {

    private final ParameterRepository parameterRepository;
    private final VoteRepository voteRepository;

    public ParameterLikesApi(ParameterRepository parameterRepository, VoteRepository voteRepository) {
        this.parameterRepository = parameterRepository;
        this.voteRepository = voteRepository;
    }

    @Transactional
    @PostMapping("/{parameterId}/like")
    public ResponseEntity<Long> likeParameter(@PathVariable Long parameterId, OAuth2AuthenticationToken authentication) {

        String username;
        if (authentication != null) {
            var oauthUser = authentication.getPrincipal();
            username = oauthUser.getAttribute("login");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var alreadyVoted = voteRepository.existsByParameterIdAndUsername(parameterId, username);

        return parameterRepository.findById(parameterId)
            .map(param -> {
                // if we have null likes in db
                if (Objects.isNull(param.getTotalLikes())) {
                    param.setTotalLikes(0L);
                }
                if (alreadyVoted) {
                    // remove vote
                    param.setTotalLikes(param.getTotalLikes() - 1);
                    // update vote control
                    voteRepository.deleteByParameterIdAndUsername(parameterId,username);
                } else {
                    // add vote
                    param.setTotalLikes(param.getTotalLikes() + 1);
                    // update vote control
                    voteRepository.save(new Vote(parameterId,username));
                }
                // update likes
                parameterRepository.save(param);

                return ResponseEntity.ok(param.getTotalLikes());
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
