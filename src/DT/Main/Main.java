package DT.Main;
import java.util.*;
import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		        DictionaryEngine dict = new DictionaryEngine();
		        ThesaurusEngine thes = new ThesaurusEngine();

		        DTUtility.log("Dictionary & Thesaurus started!");

		        try {
		            // Corpus files
		            List<String> corpusFiles = Arrays.asList(
		                "dictionary",
		                "thesaurus"
		            );

		            for (String TEXT: corpusFiles) {
		                List<String> lines = DTUtility.readLines(TEXT);
		                dict.addLines(lines);
		                DTUtility.log("Indexed: " + TEXT);
		            }

		            // Synonyms
		            String synonymFile = "sample";
		            List<String> rows = DTUtility.readLines("sample");
		            for (String r : rows)
		                thes.addSynonymRow(r);
		            DTUtility.log("Synonyms loaded");

		            // Export dictionary
		            List<String> outDict = new ArrayList<>();
		            outDict.add("word,freq");
		            for (var e : dict.getAll().entrySet())
		                outDict.add(e.getKey() + "," + e.getValue());
		            DTUtility.writeCSV("output1", outDict);

		            // Export thesaurus
		            List<String> outSyn = new ArrayList<>();
		            outSyn.add("word,synonyms");
		            for (var e : thes.getAll().entrySet())
		                outSyn.add(e.getKey() + "," + String.join("|", e.getValue()));
		            DTUtility.writeCSV("output1", outSyn);

		            DTUtility.log("Export completed!");

		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }

		        DTUtility.log("Done!");
		    }
			
     
      
     

         
              
	}
            
          
      	       
		    
		
		    

		
		

	


