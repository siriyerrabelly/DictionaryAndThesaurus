package DT.Main;


import java.io.File;
import java.util.*;
import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;
public class MAIN2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		        DictionaryEngine dict = new DictionaryEngine();
		        ThesaurusEngine thes = new ThesaurusEngine();

		        DTUtility.log("Dictionary & Thesaurus started!");

		        try {
		            // -------------------------------
		            // 1️⃣ Read all text files in corpus/
		            // -------------------------------
		            File folder = new File("dictionary");
		            File[] files = folder.listFiles((dir, name) -> name.endsWith("dictionary"));

		            for (File f : files) {
		                List<String> lines = DTUtility.readLines(f.getPath());
		                dict.addLines(lines);  // Count words
		                DTUtility.log("Indexed: " + f.getName());
		            }

		            // -------------------------------
		            // 2️⃣ Read thesaurus text file
		            // -------------------------------
		            File thesFile = new File("thesaurus");
		            if (thesFile.exists()) {
		                List<String> thesLines = DTUtility.readLines(thesFile.getPath());
		                for (String r : thesLines) {
		                    thes.addSynonymRow(r);  // Add word-synonym pairs
		                }
		                DTUtility.log("Thesaurus loaded from text file");
		            }

		            // -------------------------------
		            // 3️⃣ Print dictionary frequency on console
		            // -------------------------------
		            System.out.println("\n--- Dictionary Frequencies ---");
		            for (var e : dict.getAll().entrySet()) {
		                System.out.println(e.getKey() + " : " + e.getValue());
		            }

		            // -------------------------------
		            // 4️⃣ Print thesaurus on console
		            // -------------------------------
		            System.out.println("\n--- Thesaurus ---");
		            for (var e : thes.getAll().entrySet()) {
		                System.out.println(e.getKey() + " -> " + e.getValue());
		            }

		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }

		        DTUtility.log("Done!");
		    }
		

	}


