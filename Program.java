

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		//Get all the words from file with time complexity O(n).
		//For each word we add to the Linked list with time complexity O(1).
		//Reading from file and store the words to link lits O(n) + O(1) = O(n).
		Linked_List ls = new Linked_List();			//Here we build our Linked_List.
		File f = new File("/Users/TamerAltaji/Desktop/Java-Workplace/DataStructureProject/src/text2.txt");
		
		
		Scanner s = new Scanner(f);
		int counter =0;											//Counter to know in wich line are we.
		while(s.hasNext()) {									//While the file is not at the end.
			counter++;												//New line.
			String str = s.nextLine();						//We put the new line in str.
			str = str.replaceAll("[^a-zA-z ]", "");		//Remove every thing exept a-z , A-Z and the spaces.
			str = str.replaceAll("\\\\"," ");
			String delims = " ";						//Set spaces as delims.				
			str = str.trim();										//Delete the leading spaces. 
			str = str.toLowerCase();							//Convert the str to lower case letters.
			String[] tokens = str.split(delims);			//Split the str to tokens by the delims.
			for (String t : tokens) {							//For each word in the tokens we save as new Node in the Linked_List.
				if(t.equals(""))									//If was there null token we pass.
					continue;
				ls.addNode(t, counter);
			}
		}
		s.close();
		sortAndSave(ls);
	}
	// we sort the linked list with merge sort ( merge sort time complexity is O(n logn) ) .
	// we print the linked list with time complextiy O(n). 
	public static void sortAndSave(Linked_List ls) throws FileNotFoundException {
		if(ls == null)
			return;
		ls.setHead(ls.mergeSort(ls.getHead())); 				//Sort the Linked_List with merge sort.
		ls.removDupsAndSave();										//Remove the duplicates and save the Linked_List to output file.
	}
	// read from file and store words in linked list O(n)
	// sort the words in the linked list O(n logn)
	// print the linked list O(n)
	// all the program O(n) + O(n logn) + O(n) = O(2n + n logn) = O(n(logn+2)) = O(n logn). 


}
