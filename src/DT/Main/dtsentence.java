package DT.Main;
import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;
import java.util.*;
import java.io.*;
public class dtsentence {
public static void main(String[] args) {

	        ThesaurusEngine thes = new ThesaurusEngine();

	        DTUtility.log("Generating example sentences from synonyms...");

	        try {
	            // ===== READ SYNONYMS FILE =====
	            List<String> synonymRows = DTUtility.readLines("sample");
	            for (String row : synonymRows) {
	                try {
	                    thes.addSynonymRow(row);
	                } catch (CorruptSynonymRowException e) {
	                    DTUtility.log("Skipped bad synonym row: " + e.getMessage());
	                }
	            }
	            DTUtility.log("Synonyms loaded.");

	            // ===== GENERATE EXAMPLE SENTENCES =====
	            List<String> examples = new ArrayList<>();
	            for (String word : thes.getAll().keySet()) {
	                examples.add(generateSentence(word, thes));
	            }

	            // ===== WRITE TO FILE =====
	            DTUtility.writeText("example_sentences.txt", examples);

	            DTUtility.log("Example sentences generated successfully!");

	        } catch (IOException e) {
	            DTUtility.log("File error: " + e.getMessage());
	        } catch (Exception e) {
	            DTUtility.log("Unexpected error: " + e.getMessage());
	        }

	        DTUtility.log("Done!");
	    }

	    // Generate sentence using the first synonym if available
	    private static String generateSentence(String word, ThesaurusEngine thes) {
	        List<String> synonyms = thes.getAll().getOrDefault(word, new ArrayList<>());
	        String synonymText = synonyms.isEmpty() ? "" : " (also called " + synonyms.get(0) + ")";
	        return "The word \"" + word + "\"" + synonymText + " can be used in a sentence.";
	    }
	}

	


