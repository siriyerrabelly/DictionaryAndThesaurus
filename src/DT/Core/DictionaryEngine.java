package DT.Core;

import java.util.*;
import DT.Utility.DTUtility;

public class DictionaryEngine {
	
	    // TreeMap keeps words in alphabetical order
	    private Map<String, Integer> freq = new TreeMap<>();

	    // Add tokens from a line
	    public void addLine(String line) {
	        for (String w : DTUtility.tokenize(line)) {
	            w = w.toLowerCase(); // optional but recommended
	            freq.put(w, freq.getOrDefault(w, 0) + 1);
	        }
	    }

	    // Add tokens from multiple lines
	    public void addLines(List<String> lines) {
	        for (String l : lines) {
	            addLine(l);
	        }
	    }

	    public int getFrequency(String w) {
	        return freq.getOrDefault(w.toLowerCase(), 0);
	    }

	    // Return alphabetically ordered dictionary
	    public Map<String, Integer> getAll() {
	        return freq;
	    }
	}

    
	    
	


	

		   

	


