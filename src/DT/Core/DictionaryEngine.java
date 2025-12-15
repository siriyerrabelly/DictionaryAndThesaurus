package DT.Core;
import java.util.*;
import DT.Utility.DTUtility;
public class DictionaryEngine {

	

		    private Map<String, Integer> freq = new HashMap<>();

		    // Add tokens from a line
		    public void addLine(String line) {
		        for (String w : DTUtility.tokenize(line)) {
		            freq.put(w, freq.getOrDefault(w, 0) + 1);
		        }
		    }

		    // Add tokens from text file lines
		    public void addLines(List<String> lines) {
		        for (String l : lines)
		            addLine(l);
		    }

		    public int getFrequency(String w) {
		        return freq.getOrDefault(w, 0);
		    }

		    public Map<String, Integer> getAll() {
		        return freq;
		    }
		

	}


