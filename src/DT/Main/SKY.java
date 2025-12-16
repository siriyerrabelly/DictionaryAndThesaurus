package DT.Main;

import DT.Core.*;
import DT.Utility.*;
import DT.Exceptions.*;
import java.util.*;
import java.io.*;



public class SKY {

    public static void main(String[] args) {
        DictionaryEngine dict = new DictionaryEngine();
        ThesaurusEngine thes = new ThesaurusEngine();
        Scanner sc = new Scanner(System.in);

        DTUtility.log("Dictionary & Thesaurus Showcase Started!");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Load Dictionary Corpus");
            System.out.println("2. Load Thesaurus Corpus");
            System.out.println("3. Load Synonyms");
            System.out.println("4. Export Files");
            System.out.println("5. Show Dictionary");
            System.out.println("6. Show Thesaurus");
            System.out.println("7. Exit");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    try {
                        List<String> corpus1 = DTUtility.readLines("dictionary");
                        dict.addLines(corpus1);
                        DTUtility.log("Dictionary corpus loaded.");
                    } catch (IOException e) {
                        DTUtility.log("Error loading dictionary: " + e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        List<String> corpus2 = DTUtility.readLines("thesaurus");
                        dict.addLines(corpus2);
                        DTUtility.log("Thesaurus corpus loaded.");
                    } catch (IOException e) {
                        DTUtility.log("Error loading thesaurus: " + e.getMessage());
                    }
                    break;

                case "3":
                    try {
                        List<String> rows = DTUtility.readLines("sample");
                        for (String r : rows) {
                            try {
                                thes.addSynonymRow(r);
                            } catch (CorruptSynonymRowException e) {
                                DTUtility.log("Skipping bad synonym row: " + e.getMessage());
                            }
                        }
                        DTUtility.log("Synonyms loaded.");
                    } catch (IOException e) {
                        DTUtility.log("Error loading synonyms: " + e.getMessage());
                    }
                    break;

                case "4":
                    try {
                        // Dictionary TEXT
                        List<String> dictText = new ArrayList<>();
                        for (Map.Entry<String, Integer> entry : dict.getAll().entrySet()) {
                            dictText.add(entry.getKey() + " : " + entry.getValue());
                        }
                        DTUtility.writeText("dictionary_output1.txt", dictText);

                        // Thesaurus TEXT
                        List<String> thesText = new ArrayList<>();
                        for (Map.Entry<String, List<String>> entry : thes.getAll().entrySet()) {
                            thesText.add(entry.getKey() + " : " + String.join(", ", entry.getValue()));
                        }
                        DTUtility.writeText("thesaurus_output1.txt", thesText);

                        // Dictionary CSV
                        List<String> dictCSV = new ArrayList<>();
                        dictCSV.add("word,freq");
                        for (Map.Entry<String, Integer> entry : dict.getAll().entrySet()) {
                            dictCSV.add(entry.getKey() + "," + entry.getValue());
                        }
                        DTUtility.writeCSV("dictionary_output1.csv", dictCSV);

                        DTUtility.log("Export completed successfully!");
                    } catch (IOException e) {
                        DTUtility.log("Error exporting files: " + e.getMessage());
                    }
                    break;

                case "5":
                    System.out.println("Dictionary:");
                    for (Map.Entry<String, Integer> entry : dict.getAll().entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;

                case "6":
                    System.out.println("Thesaurus:");
                    for (Map.Entry<String, List<String>> entry : thes.getAll().entrySet()) {
                        System.out.println(entry.getKey() + " : " + String.join(", ", entry.getValue()));
                    }
                    break;

                case "7":
                    running = false;
                    DTUtility.log("Exiting program.");
                    break;

                default:
                    DTUtility.log("Invalid option, try again.");
            }
        }

        sc.close();
        DTUtility.log("Done!");
    }


    }

    

		
	


	


