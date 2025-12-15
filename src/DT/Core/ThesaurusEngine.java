package DT.Core;
import java.util.*;
import DT.Exceptions.CorruptSynonymRowException;
public class ThesaurusEngine {

	

private Map<String, List<String>> syn = new HashMap<>();

		    public void addSynonymRow(String row) throws CorruptSynonymRowException {
		        String parts[] = row.split(",");

		        if (parts.length != 2)
		            throw new CorruptSynonymRowException("Invalid row: " + row);

		        String w1 = parts[0].trim();
		        String w2 = parts[1].trim();

		        syn.putIfAbsent(w1, new ArrayList<>());
		        syn.putIfAbsent(w2, new ArrayList<>());

		        syn.get(w1).add(w2);
		        syn.get(w2).add(w1);
		    }

		    public List<String> getSynonyms(String w) {
		        return syn.getOrDefault(w, List.of("None"));
		    }

		    public Map<String, List<String>> getAll() {
		        return syn;
		    }
		

	}


