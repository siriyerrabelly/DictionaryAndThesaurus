package DT.Main;
import java.util.*;
import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;

public class SKY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
               DictionaryEngine dict = new DictionaryEngine();
		        ThesaurusEngine thes = new ThesaurusEngine();

		        DTUtility.log("Dictionary & Thesaurus started!");

		        try {
		            /* ================= READ THREE DIFFERENT FILES ================= */

		            // 1️⃣ First corpus file
		            List<String> corpus1 = DTUtility.readLines("dictionary");
		            dict.addLines(corpus1);
		            DTUtility.log("Indexed corpus1.txt");

		            // 2️⃣ Second corpus file
		            List<String> corpus2 = DTUtility.readLines("thesaurus");
		            dict.addLines(corpus2);
		            DTUtility.log("Indexed corpus2.txt");

		            // 3️⃣ Synonyms file
		            List<String> rows = DTUtility.readLines("sample");
		            for (String r : rows)
		                thes.addSynonymRow(r);
		            DTUtility.log("Synonyms loaded");

		            /* ================= OUTPUT SECTION ================= */

		            // Dictionary TEXT
		            List<String> dictText = new ArrayList<>();
		            for (var e : dict.getAll().entrySet())
		                dictText.add(e.getKey() + " : " + e.getValue());
		            DTUtility.writeCSV("dictionary", dictText);

		            // Thesaurus TEXT
		            List<String> thesText = new ArrayList<>();
		            for (var e : thes.getAll().entrySet())
		                thesText.add(e.getKey() + " : " + String.join(", ", e.getValue()));
		            DTUtility.writeCSV("thesaurus", thesText);

		            // Dictionary CSV
		            List<String> dictCSV = new ArrayList<>();
		            dictCSV.add("word,freq");
		            for (var e : dict.getAll().entrySet())
		                dictCSV.add(e.getKey() + "," + e.getValue());
		            DTUtility.writeCSV("dictionary", dictCSV);

		            /* ================================================= */

		            DTUtility.log("Export completed!");

		        } catch (Exception e) {
		            System.out.println("Error: " + e.getMessage());
		        }

		        DTUtility.log("Done!");
		    }
		


	}


