package DT.Utility;
import java.io.*;
import java.util.*;

public class DTUtility {
	
	    // -----------------------------
	    // LOG METHOD
	    // -----------------------------
	    public static void log(String msg) {
	        System.out.println("[DT] " + msg);
	    }

	    // -----------------------------
	    // READ LINES FROM FILE
	    // -----------------------------
	    public static List<String> readLines(String dictionary) throws IOException {
	        List<String> lines = new ArrayList<>();
	        BufferedReader br = new BufferedReader(new FileReader(dictionary));
	        String line;
	        while ((line = br.readLine()) != null)
	            lines.add(line);
	        br.close();
	        return lines;
	    }

	    // -----------------------------
	    // WRITE CSV METHOD
	    // -----------------------------
	    public static void writeCSV(String sample, List<String> rows) throws IOException {
	        PrintWriter pw = new PrintWriter(new FileWriter(sample));
	        for (String r : rows)
	            pw.println(r);
	        pw.close();
	    }

	    // -----------------------------
	    // SIMPLE TOKENIZER
	    // -----------------------------
	    public static List<String> tokenize(String text) {
	        List<String> tokens = new ArrayList<>();
	        for (String w : text.toLowerCase().split("[^a-z]+")) {
	            if (!w.isEmpty())
	                tokens.add(w);
	        }
	        return tokens;
	    }
	}
	    
		
		
	
	
	
	   
	

	    
	    
	


