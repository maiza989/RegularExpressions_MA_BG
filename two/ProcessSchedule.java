package two;

/**
 *  A Class that search a newly created text file and get infromation about courses
 *  Such as course title, if its open or close, how many seats are avaible, and lastly find how many classes offered for each program in Fall21
 *  
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * to get the menu text to choose which search to do. You can use switch case to do so.
 * I couldn't do it correctly so a sorting to store the answers into different text file with the help or a classmate.
 * 
 */

public class ProcessSchedule {
	/**
	 * Constructor for the class
	 */
		String fileName;

public ProcessSchedule(String file) {
		
		 fileName = file;
		
	}// end constructor
	/*
	 * Extract the course information and title for each course in the file and save just that information to a file called ClassTitles.
	 * 
	 * Data in ClassTitles.txt
	*/
	public void CourseTitles() throws IOException {
		
		String cl=null;
		BufferedReader bReader = new BufferedReader(new FileReader(fileName));
		Scanner fileScan = new Scanner(new File(fileName));
		PrintWriter out = new PrintWriter("ClassTitles.txt");
		 
		while((cl = bReader.readLine())!= null) {
	    	
			Pattern p = Pattern.compile("\\w{2,4}\\-\\d{3}(\\w)?\\-(((\\w{2})?\\d+)|(\\w{2})|)\\D+");
			Matcher m = p.matcher(cl);
			
			if(m.find()) {
				out.println(m.group());
			}// end of if statement 

	    }// end of while loop 
	
		out.close();
	    
	}// end of CourseTitles
    
	/**
	 * Using the scanner lib to put the 
	 * A method to check if  a class is open or closed
	 * Check how many Seats available in said class. 
	 * @throws FileNotFoundException
	 * 
	 * Data in Seats.txt
	 */
	public void Seats() throws FileNotFoundException {
		

		Scanner fs = new Scanner(new File(fileName));
		PrintWriter out = new PrintWriter("Seats.txt");
		 
		while(fs.hasNext()) {
	    	
			Pattern p = Pattern.compile("((Open)|(CLOSED))\\ \\d+\\ \\d+");
			Matcher m = p.matcher(fs.nextLine());
			
			if(m.find()) {
				
				out.println(m.group());
				
			}// end of if statement 
			
		
			
	    }// end of while loop
		
		out.close();
		
	}// end Seats
	
	/*
	 * A method to Count how many classes are offered in each program code 
	 *  (e.g. CSCI, RTH, ACCT, BIOL, etc.) in Fall 21.
	 *  Also storing the count of the classes into a hashmap
	 *  
	 *  Data in ClassCount.txt
	 * 
	 */
	public void ClassCount() throws FileNotFoundException {
		
		 
		String ClassCode = null;
		
		Scanner fileScan = new Scanner(new File(fileName));
		PrintWriter out = new PrintWriter("ClassCount.txt");
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		while(fileScan.hasNext()) {
	    	
			Pattern p = Pattern.compile("\\w{2,4}\\-\\d{3}([L,H])?\\-(01)");
			Matcher m = p.matcher(fileScan.nextLine());
			/**
			 * if statement Handle classes code name 
			 */
			if(m.find()) {
				
				if(m.group().charAt(0)=='B'&& m.group().charAt(1)=='U' && m.group().charAt(2)=='-'||
						m.group().charAt(0)=='C'&& m.group().charAt(1)=='S' && m.group().charAt(2)=='-'||
						m.group().charAt(0)=='P'&& m.group().charAt(1)=='S' && m.group().charAt(2)=='-'||
						m.group().charAt(0)=='P'&& m.group().charAt(1)=='T' && m.group().charAt(2)=='-') {
					ClassCode = m.group().substring(0,2);
				}// end of if statement
				else {
					
					ClassCode = m.group().substring(0, 4);
					
					
				}// end of else
				
				/**
				 * if statement to increase the key value
				 */
				if(map.containsKey(ClassCode)){
					
					int x = map.get(ClassCode)+1;
					map.replace(ClassCode, x);
					
				}// end of if statement
				else {
					
					map.put(ClassCode, 1);
					
				}// end of else 
				
				
			}// end of if 
		}// end of while loop
		/**
		 * for loop to go through the map and get the number of classes
		 */
		//System.out.println("How many unique class\n");
		for (String i : map.keySet()) {
			
			  //System.out.println(i +":"+ " Offers " + map.get(i) + " Different classes ");
			  out.println(i +":"+ " Offers " + map.get(i) + " Different classes ");
			}// end of modified for loop
	
		out.close();
			
	}// end ClassCount
	
	/**
	 * to get the menu text to choose which search to do. You can use switch case to do so.
	 * I couldn't do it correctly so a sorting to store the answers into different text file
	 * 
	 */


   }// end of class