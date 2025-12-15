package DT.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryAndThesaurus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Reading data from CSV:");
        try {
			BufferedReader br = new BufferedReader(new FileReader("sample"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Enter the choice");
        int choice=sc.nextInt();
        switch (choice) {
        case 1 -> System.out.println("Option 1: Index Corpus selected");
        case 2 -> System.out.println("Option 2: Lookup Word selected");
        case 3 -> System.out.println("Option 3: Show Synonyms selected");
        case 4 -> System.out.println("Option 4: Export Dictionary & Thesaurus selected");
        
        case 5 -> System.out.println("Exiting... Goodbye!");
        default -> System.out.println("Invalid choice! Please select 1-6.");
        }
        
	}
}


