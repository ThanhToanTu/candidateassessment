package com.optus.candidateassessment.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface WordCountService {
	
	public String top(@PathVariable int num);
	
}
