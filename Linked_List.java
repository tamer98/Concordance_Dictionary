

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
		char Letter = this.head.word.charAt(0);															
		Node slow = this.head, fast = this.head.next, fastPrevious = this.head;			
		int checker = 1;																								
		if(head !=null) {																								
			while(slow != null) {																					
				if(slow.word.charAt(0)!=Letter) {															
					Letter =slow.word.charAt(0) ;checker=1;											
				}
				if(checker == 1) {																					
					pw.write("\n"+(char)(Letter-32)+"\n");												
					checker=0;																						
				}
				if(fast.next!=null) {																				
					while(slow.word.equals(fast.word)) {													
						slow.lines +=fast.lines;																	
						if(fast.next==null) {																		
							break;
						}
						fast = fast.next;
						fastPrevious = fastPrevious.next;
					}
				}
				pw.write(slow.word + " " + slow.lines+"\n");											
				if(fast.next != null) {																				
					fast = fast.next;
					fastPrevious = fastPrevious.next;
					slow = fastPrevious;
				}
				else {
					if(slow.next!=null) {																			
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
