import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {



	public static void main(String[] args) throws Exception  {
		Scanner scanner = new Scanner(System.in);
		boolean exit=false;

		printMenu();



		while(!exit) {

			String input = scanner.nextLine();
			//scanner.nextLine();

			switch(input) {
			case "read" :
				readFile();
				System.out.println("File 'clouds.txt' was read successfully");
				break;
			case "wc" :
				countWords();
				break;
			case "find" :
				findWord();
				break;
			case "menu" :
				printMenu();
				break;
			case "exit" :
				System.out.println("Thank you for using our app. \n App terminated.");
				exit=true;
				break;
			default :
				System.out.println("Invalid command");
			}
		}


	}


	public static String[] readFile() throws Exception{
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\John\\Desktop\\Java\\TestFile.txt")); 

		String st; 
		while ((st = br.readLine()) != null)
			lines.add(st); //filled the arrayList by reading an external txt file (We used an ArrayList because we don't know the exact size)		  		  

		String[] data = lines.toArray(new String[]{}); //Transformed it to String Array in order to manipulate it.

		String str = String.join(" ", data); // Transformed the String Array to a single String for easy manipulation 

		String[] divide = str.split(" "); // Divided the String with " "


		return divide;
	}
	
	public static void countWords() throws Exception {
		System.out.println(readFile().length); // We count the words
		
		try (PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\John\\Desktop\\Java\\OutFile.txt"))) {
		    out.print("Total words are: " + readFile().length);
		}
	
	}


	public static void findWord() throws Exception {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("Enter the word you are looking for: ");
		String whatToFind = scanner.nextLine();
		for (String s : readFile()) {
			if (s.equals(whatToFind)) {
				++count;
			}
		}
		
		try (PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\John\\Desktop\\Java\\OutFile.txt"))) {
		    out.print("The word "+whatToFind+ " was found :" +count+" times.");
		}
		
		System.out.println("The word you are looking for was found: " +count +" times.");
		
		

	}

	public static void printMenu() {
		System.out.println("Welcome to the external txt files reading app. How you want to procced? "
				+ "\n1. Type 'read' to read the file. "
				+ "\n2. Type 'wc' to count the words of the text file. "
				+ "\n3. Type 'find' to see how many times a specific word is repeated. "
				+ "\n4. Type 'exit' to exit application "
				+ "\n5. Type 'menu' to see the Menu again");
	}

}