package com.optus.candidateassessment.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class SearchTexts {
	
	private List<String> searchText;
	
	public SearchTexts() {
		// default constructor
	}
	
	@Autowired
	public SearchTexts(List<String> searchText) {
		this.searchText = searchText;
	}

	public List<String> getSearchText() {
		return searchText;
	}
		
	public void setSearchTexts(List<String> searchText) {
		this.searchText = searchText;
	}

}
