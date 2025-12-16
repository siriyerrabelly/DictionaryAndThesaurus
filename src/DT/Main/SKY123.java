package DT.Main;
import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;
import java.util.*;
import java.io.*;
public class SKY123 {

    public static void main(String[] args) {

        DictionaryEngine dict = new DictionaryEngine();
        ThesaurusEngine thes = new ThesaurusEngine();

        DTUtility.log("Dictionary & Thesaurus started!");

        try {
            // ===== READ FILES =====
            List<String> corpus1 = DTUtility.readLines("dictionary");
            dict.addLines(corpus1);
            DTUtility.log("Indexed dictionary");

            List<String> corpus2 = DTUtility.readLines("thesaurus");
            dict.addLines(corpus2);
            DTUtility.log("Indexed thesaurus");

            List<String> rows = DTUtility.readLines("sample");
            for (String r : rows) {
                try {
                    thes.addSynonymRow(r);
                } catch (CorruptSynonymRowException ex) {
                    DTUtility.log("Skipped bad synonym row: " + ex.getMessage());
                }
            }
            DTUtility.log("Synonyms loaded");

            // ===== EXPORT FILES =====

            // Dictionary text
            List<String> dictText = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : dict.getAll().entrySet()) {
                dictText.add(entry.getKey() + " : " + entry.getValue());
            }
            DTUtility.writeText("dictionary_output.txt", dictText);

            // Thesaurus text
            List<String> thesText = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : thes.getAll().entrySet()) {
                thesText.add(entry.getKey() + " : " + String.join(", ", entry.getValue()));
            }
            DTUtility.writeText("thesaurus_output.txt", thesText);

            // Dictionary CSV
            List<String> dictCSV = new ArrayList<>();
            dictCSV.add("word,freq");
            for (Map.Entry<String, Integer> entry : dict.getAll().entrySet()) {
                dictCSV.add(entry.getKey() + "," + entry.getValue());
            }
            DTUtility.writeCSV("dictionary_output.csv", dictCSV);

            DTUtility.log("Export completed successfully!");

        } catch (IOException e) {
            DTUtility.log("File error: " + e.getMessage());
        } catch (Exception e) {
            DTUtility.log("Unexpected error: " + e.getMessage());
        }

        DTUtility.log("Done!");
    }
}


    




		


	


