

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Linked_List {

	static File myFile;
	
	
	class Node {
		private Node next; 									
		private String word;											
		private String lines ="";								
		public Node(String word,int lines) {			
			this.word = word;									
			this.lines = lines+" ";								
			this.next = null;               						
		}
	}

	private Node head;										
	private Node tail;											
	private int length=0;

	public Linked_List() {									
		head = null;												
		tail = null;
	}

	public Node getHead() {								
		return head;
	}
	public void setHead(Node head) {					
		this.head = head;
	}

	public void addNode(String word, int line) {									

		Node newNode = new Node(word,line);										
		if(head == null) {																		
			head = newNode;																	
			tail = newNode;																		
		}
		else {																						
			tail.next = newNode;																
			tail = newNode;																		
		}
		length++;
	}

	public void removDupsAndSave() throws FileNotFoundException {	
		//Erase dublicates and save to file function
		myFile = new File("/Users/TamerAltaji/Desktop/Java-Workplace/DataStructureProject/src/output") ;
		Scanner s = new Scanner(myFile);
		PrintWriter pw = new PrintWriter(myFile);
		pw.write("CONCORDANCE\n");
		char Letter = this.head.word.charAt(0);															//We get the first the first char of the first word in the.
		Node slow = this.head, fast = this.head.next, fastPrevious = this.head;			//We make 3 pointers one to print and to to help remove dublicates;
		int checker = 1;																								//Checker to check if we must change the Letter to the next Letter, 0 if no and 1 if yes.
		if(head !=null) {																								//if the Linked_List not null, because if null we avoid exptions.
			while(slow != null) {																					//We get every Node on the Linked_List, while the pointer to the head is not null. 
				if(slow.word.charAt(0)!=Letter) {															//If the current word's first char is not equal to the saved letter we arrive to the next group of words.
					Letter =slow.word.charAt(0) ;checker=1;											//We Change the letter to the new group of words letter, and change the chekcer to 1 to print this letter.
				}
				if(checker == 1) {																					//If the checker is 1 thats mean we must change the letter to the next letter .
					pw.write("\n"+(char)(Letter-32)+"\n");												//Print the Letter in capital letter.
					checker=0;																						//We change the checker to 0 that's mean we wont change the letter to the new letter until we finish the letter group.
				}
				if(fast.next!=null) {																				//If the fast didn't arrive to the tail Node.
					while(slow.word.equals(fast.word)) {													//Remove duplicates, the fast and it's previous run until the word change.
						slow.lines +=fast.lines;																	//For each word that we remove we save it's line in the first word.
						if(fast.next==null) {																		//If we arrived to the end we dont want to continue.
							break;
						}
						fast = fast.next;
						fastPrevious = fastPrevious.next;
					}
				}
				pw.write(slow.word + " " + slow.lines+"\n");											//Print the word with its lines.
				if(fast.next != null) {																				//If the next of the fast is null we wont increase it to the next Node.
					fast = fast.next;
					fastPrevious = fastPrevious.next;
					slow = fastPrevious;
				}
				else {
					if(slow.next!=null) {																			//We increase just the slow and previous pointer to the next Node, but if we arrive to the tail we break the loop.
						fastPrevious = fastPrevious.next;
						slow = fastPrevious;
					}
					else break;
				}
			}
		}
		pw.write("\nThere are " + length + " words in the file");								
		pw.close();s.close();
		System.out.println("Saved in output file!!");
	}

	Node sortedMerge(Node a, Node b) 
	{ 
		Node result = null; 
		/* Base cases */
		if (a == null) 
			return b; 
		if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.word.compareTo(b.word)<0) { 
			result = a; 
			result.next = sortedMerge(a.next, b); 
		} 
		else { 
			result = b; 
			result.next = sortedMerge(a, b.next); 
		} 
		return result; 
	} 

	Node mergeSort(Node h) 
	{ 
		//Base case : if head is null 
		if (h == null || h.next == null) { 
			return h; 
		} 

		Node middle = getMiddle(h); 							 
		Node nextofmiddle = middle.next; 

		middle.next = null; 											 

		Node left = mergeSort(h); 								

		Node right = mergeSort(nextofmiddle); 			

		Node sortedlist = sortedMerge(left, right); 		
		return sortedlist; 
	} 

	//Utility function to get the middle of the linked list 
	public static Node getMiddle(Node head) 
	{ 
		if (head == null) 
			return head; 

		Node slow = head, fast = head; 

		while (fast.next != null && fast.next.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
		} 
		return slow; 
	} 

}
