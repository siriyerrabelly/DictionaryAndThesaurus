package DT.Utility;
import java.io.*;
import java.nio.file.*;
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
    public static List<String> readLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        br.close();
        return lines;
    }

    // -----------------------------
    // WRITE CSV METHOD
    // -----------------------------
    public static void writeCSV(String fileName, List<String> rows) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        for (String r : rows)
            pw.println(r);
        pw.close();
    }

    // -----------------------------
    // WRITE TEXT METHOD
    // -----------------------------
    public static void writeText(String fileName, List<String> lines) throws IOException {
        // Overwrites the file if it exists
        Files.write(Paths.get(fileName), lines);
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
	

	    
	    
	


