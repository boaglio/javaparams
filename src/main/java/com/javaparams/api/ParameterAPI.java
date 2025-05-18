package com.javaparams.api;

import com.javaparams.domain.Parameter;
import com.javaparams.repo.ParameterRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParameterAPI {

	private final ParameterRepository parameterRepository;

	public ParameterAPI(ParameterRepository parameterRepository) {
		this.parameterRepository = parameterRepository;
	}

	@GetMapping("/api/parameter/find")
	public List<Parameter> findAll() {
		return parameterRepository.findAll(PageRequest.of(0, 100)).getContent();
	}
	
	@GetMapping("/api/parameter/top")
	public List<Parameter> findTop12() {
		return parameterRepository.findTop12ByOrderByTotalLikesDesc();
	}
	
	@GetMapping("/api/parameter/likes")
	public List<Parameter> findWithLikes() {
		return parameterRepository.findByTotalLikesGreaterThan(0);
	}

}