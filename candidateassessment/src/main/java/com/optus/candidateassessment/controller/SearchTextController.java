package com.optus.candidateassessment.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.optus.candidateassessment.exception.WrongNumberException;
import com.optus.candidateassessment.model.Counts;
import com.optus.candidateassessment.model.SearchTexts;
import com.optus.candidateassessment.service.SearchTextService;
import com.optus.candidateassessment.service.WordCountService;

@RestController
@RequestMapping("/counter-api")
public class SearchTextController {
	
	// Task 1
	@Autowired
	private SearchTextService searchTextService;
	
	//Task 2
	@Autowired
	private WordCountService wordCountService;
	
	@PostMapping("/search")
	public Counts search(@RequestBody SearchTexts searchText) throws FileNotFoundException {
		return searchTextService.search(searchText);
	}
	
	@GetMapping("/top/{num}")
	@ResponseBody
	public String top(@PathVariable int num) {
		
		if (num != 5 && num != 10 && num != 20 && num != 30) {
			throw new WrongNumberException("Number is not 5, 10, 20 or 30 - " + num);
		}
		
		return wordCountService.top(num);
	}

}
