package one;

/**
 * A class that will search a text file and find patterns. Thus class accept two input in the command-line.
 *  1. Name of the file. 2. A regex pattern to search in the file. 
 *  This program also count the number of occurrences and print it out.
 *  
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {
	
	/**
	 * Creating a read-only using java.nio.Charbuffer on the file. Throws IOException 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
  public static CharSequence fromFile(String filename) throws IOException {
    FileInputStream fis = new FileInputStream(filename);
    FileChannel fc = fis.getChannel();

    ByteBuffer bbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, (int) fc.size());
    CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);
    return cbuf;
  }// end of CharSequence

  	/**
  	 * Main method
  	 * @param args
  	 * try-catch method to catch IO exception
  	 * Creating matcher on file
  	 * Find all matches and print them along with how many occurrences
  	 * 
  	 * 
  	 * Pattern to use:
  	 * (\ [Aa][n]?\ )|(\ [Tt](he ))
  	 * \w+( Transylvania) or \bTransylvania
  	 * (\bMina Harker|\bMrs. Harker) or ( Mina Harker )|( Mrs. Harker )
  	 * \ [Tt][o]\ \w+ (not working) or \bto\s\w+ (works)
  	 * \ (?!Helsing)(?!Godalming)\w+(ing)
  	 */
  public static void main(String[] args){
    // Create matcher on file
	  try {
		  	Pattern pattern = Pattern.compile(args[1]);
		  	Matcher matcher = pattern.matcher(fromFile(args[0]));

    // Find all matches
    int count = 0;
    while (matcher.find()) {
    // Get the matching string
    	
    	System.out.println(matcher.group());
       
        count++;
  	
      
    }// end of while loop
    
    System.out.println("Number of Occurences is: " + count);
    System.out.println("\nDone");
    
	  }// end of try
	  
	  /**
	   * This method prints a stack trace for this Throwable object on the standard error output stream
	   */
	  catch(IOException e){
		  
		  System.out.println("Error:");
		  e.printStackTrace();
		
	  }// end of catch
	  
  }// end of main	  
}// end of class