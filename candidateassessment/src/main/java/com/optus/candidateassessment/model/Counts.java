package com.optus.candidateassessment.model;

import java.util.HashMap;
import java.util.Map;

public class Counts {
	
	Map<String, Integer> theCounts = new HashMap<String, Integer>();
	
	public Counts() {
		
	}

	public Counts(Map<String, Integer> theCounts) {
		this.theCounts = theCounts;
	}

	public Map<String, Integer> getCounts() {
		return theCounts;
	}

	public void setCounts(Map<String, Integer> theCounts) {
		this.theCounts = theCounts;
	}

}
