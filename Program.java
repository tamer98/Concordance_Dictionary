

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		//Get all the words from file with time complexity O(n).
		//For each word we add to the Linked list with time complexity O(1).
		//Reading from file and store the words to link lits O(n) + O(1) = O(n).
		Linked_List ls = new Linked_List();			
		File f = new File("/.../.../text2.txt");
		
		
		Scanner s = new Scanner(f);
		int counter =0;											
		while(s.hasNext()) {									
			counter++;												
			String str = s.nextLine();						
			str = str.replaceAll("[^a-zA-z ]", "");		
			str = str.replaceAll("\\\\"," ");
			String delims = " ";										
			str = str.trim();										 
			str = str.toLowerCase();							
			String[] tokens = str.split(delims);			
			for (String t : tokens) {							
				if(t.equals(""))									
					continue;
				ls.addNode(t, counter);
			}
		}
		s.close();
		sortAndSave(ls);
	}
	// sort the linked list with merge sort ( merge sort time complexity is O(n logn) ) .
	// print the linked list with time complextiy O(n). 
	public static void sortAndSave(Linked_List ls) throws FileNotFoundException {
		if(ls == null)
			return;
		ls.setHead(ls.mergeSort(ls.getHead())); 				
		ls.removDupsAndSave();										
	}
	// read from file and store words in linked list O(n)
	// sort the words in the linked list O(n logn)
	// print the linked list O(n)
	// all the program O(n) + O(n logn) + O(n) = O(2n + n logn) = O(n(logn+2)) = O(n logn). 


}
