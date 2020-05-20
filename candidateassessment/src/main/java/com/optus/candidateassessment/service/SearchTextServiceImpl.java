package com.optus.candidateassessment.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.optus.candidateassessment.model.Counts;
import com.optus.candidateassessment.model.SearchTexts;

@Service
public class SearchTextServiceImpl implements SearchTextService {
	
	File file;
	
	// post construct - load sample file
	@PostConstruct
	public void loadFile() {
		
		file = new File("sample.txt");
		
	}

	@Override
	public Counts search(@RequestBody SearchTexts searchText) throws FileNotFoundException {
		
		Counts counts = new Counts();
		
		Map<String, Integer> tempCounts = new HashMap<String, Integer>();
		List<String> searchTexts = searchText.getSearchText();
		
		System.out.println(searchText);
		
		for (String text : searchTexts) {
			
			text = text.toUpperCase();
			
			Scanner scanner = new Scanner(file);
			
			int count = 0;
			
			while (scanner.hasNext()) {
	            
				// remove commas and dots before comparing
				String nextText = scanner.next().replace(",", "").replace(".", "").toUpperCase();

				if (nextText.equals(text)) {
					count++;
				}
				
			}
			
			// first letter uppercase
			text = text.substring(0, 1) + text.substring(1).toLowerCase();
			
			tempCounts.put(text, count);
			
			scanner.close();
			
		}
		
		counts.setCounts(tempCounts);
		
		return counts;
		
	}

}
