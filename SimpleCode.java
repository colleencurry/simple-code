import javax.swing.JOptionPane;

public class SimpleCode {

	static String[] numbers = {								 // valid numbers that the user can enter
						  "0","00","1","2","3","4","5",
					    "6","7","8","9","10","11","12",
					   "13","14","15","16","17","18","19",
					   "20","21","22","23","24","25","26",
					   };
	
	static String[] letters = {								// valid letters are placed at the same index as a corresponding element in numbers
						" ",".","z","y","x","w","v",
					   "u","t","s","r","q","p","o",
					   "n", "m","l","k","j","i","h",
					   "g","f","e","d","c","b","a",
					   };
	
	static String numberLine; // holds user's exact input
	static StringBuilder secretMessage = new StringBuilder(); // holds the user's message as each character is decoded

	public static void main(String[] args) {
		
	boolean done = false;
	
	while (done == false)
	{
		
		// get the user input	
		String numberLine = JOptionPane.showInputDialog("\nRefer to the key and enter a secret message. Separate each number with a comma (,)" +
									"\n" +
									"\nKey:" +
									"\nThe digit 0 represents a Space" + 
									"\nThe digits 00 represent a Period (.)" +
									"\n" +
									"\nLetters are assigned to digits as follows: " +
									"\n" +
									"\n( 26 : A ) ( 25 : b ) ( 24 : c ) ( 23 : d ) ( 22 : e ) ( 21 : f ) ( 20 : g ) ( 19 : h )" +
									"\n( 18 : i ) ( 17 : j ) ( 16 : k ) ( 15 : l ) ( 14 : m ) ( 13 : n ) ( 12 : o ) ( 11 : p )" +
									"\n( 10 : q ) ( 9 : r ) ( 8 : s ) ( 7 : t ) ( 6 : u ) ( 5 : v ) ( 4 : w ) ( 3 : x )" +
									"\n( 2 : y ) ( 1 : z )" );
		
		numberLine = numberLine.trim();					// trim whitespace
		String[] nums = numberLine.split("[,]");		// create an array from the string using a comma delimiter
		boolean isFirstLetter = true;					// tracks whether a letter is the first in a sentence
		int count = 0;									// increments by one as each element in nums is checked against numbers
														// and resets once a valid match is found
		
			for (int i =0; i < nums.length; i++) {
				count = 0; // count resets to 0 for each string in nums
				for (int j = 0; j < numbers.length; j++) {
					if ((nums[i]).equals(numbers[j])) {
						
						if (i == (nums.length - 1)) {
							done = true; // ends the while loop
						}
						
						if (numbers[j] == "00") // if the character is a period
						{
							secretMessage.append(letters[j]); // insert the period character
							isFirstLetter = true; // make the next letter a capital letter
						} else if (numbers[j] == "0") // space character does not affect capitalization of next letter
						{
							secretMessage.append(letters[j]);
						} else if (isFirstLetter == true) // if a letter is the first in the sentence
						{
							secretMessage.append(letters[j].toUpperCase()); // letter is capitalized
							isFirstLetter = false; // remaining characters in the sentence will be lowercase
						
						} else
						{
							secretMessage.append(letters[j]); 
						}
						
					} else {
						count++;
						if (count == 28) // count reaches 28 when the string doesn't match 
						{
							JOptionPane.showMessageDialog(null, "Sorry, the character " + nums[i] + " is invalid. Press OK to re-enter your message."); // identifies the invalid character and prompts user before continuing
							continue;// resets the loop
							
						} // end if
						
					} // end else
				
				} //end inner for loop
					
			} // end outer for loop

	} // end while loop
	
	String s = "Your message says: " + secretMessage.toString(); // creates string for output
	
	JOptionPane.showMessageDialog(null, s); // outputs the decoded secret message
	
	} //end main

}
