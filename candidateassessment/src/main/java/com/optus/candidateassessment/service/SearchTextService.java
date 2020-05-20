package com.optus.candidateassessment.service;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.RequestBody;

import com.optus.candidateassessment.model.Counts;
import com.optus.candidateassessment.model.SearchTexts;

public interface SearchTextService {
	
	public Counts search(@RequestBody SearchTexts searchText) throws FileNotFoundException;

}
