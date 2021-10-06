/**
 * LogFileProcessor takes a .txt file and scans it given different regex expressions. It searches for IP addresses along with usernames and counts them in seperate hashmaps.
 * 
 * @author Bobby Gabriel, Maitham
 * @version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 */

package part3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Scanner;


public class LogFileProcessor {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {	
			
		int totalLines = 0; 
		int input = 0;
		Scanner scan = new Scanner(System.in);
		
		String file = "IPV4.txt";
		String thisLine = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
	
		
		//2 hashmaps for ip addresses and usernames
		HashMap<String, Integer> ipv4 = new HashMap<String, Integer>();
		HashMap<String, Integer> username = new HashMap<String, Integer>();	
	
	
		//1st half of while loop reads lines on the file and matches them to the IP address regex pattern. 2nd half matches lines on the file to the Username regex pattern.
		while((thisLine = br.readLine())!= null) {
		
			totalLines++;
		
			Pattern pattern1 = Pattern.compile("(?:\\d{1,3}\\.){3}\\d{1,3}");
			Matcher matcher1 = pattern1.matcher(thisLine);
		
			if(matcher1.find()) {
			
				String match = matcher1.group();
			
				if(ipv4.containsKey(match)){
					int y = ipv4.get(match) + 1;
					ipv4.replace(match, ipv4.get(match), y);
				
			}//end if
			else {
				
				ipv4.put(match, 1);
				
			}
		}//end if
		
			
			
			
		Pattern pattern2 = Pattern.compile("(user) \\w+");
		Matcher matcher2 = pattern2.matcher(thisLine);
		
		if(matcher2.find()) {
			
			String match = matcher2.group();
			
			if(username.containsKey(match)){
				int y = username.get(match) + 1;
				username.replace(match, username.get(match), y);
				
			}//end if 
			else {
				
				username.put(match, 1);
				
			}
		}//end if
		
	}//end while
	
		
		//Input for user on what they want to see from the regex matching. 
		System.out.println("Enter 0 for the total number of lines in the log file that were parsed, the unique IP addresses, and the number of unique users in the log: \n");
		System.out.println("Enter 1 for the hashmap of IP addresses along with the total number of lines in the log file that were parsed, the unique IP addresses, and the number of unique users in the log: \n");
		System.out.println("Enter 2 for the hashmap of usernames along with the total number of lines in the log file that were parsed, the unique IP addresses, and the number of unique users in the log: ");
		input = scan.nextInt();
	
		switch(input) {
	
			case 0:
			
				System.out.println(totalLines + " " + "lines in the log file were parsed.");
				System.out.println("There are " + ipv4.size() + " unique IP addresses in the log");
				System.out.println("There are " + username.size() + " unique users in the log");
			
				break;
			case 1://case for list of ips.
			
				for (String hashmap : ipv4.keySet()) {
					System.out.println(hashmap + ": " + ipv4.get(hashmap));// prints all keys and values
				}// end modified for loop
			
				System.out.println(totalLines + " " + "lines in the log file were parsed.");
				System.out.println("There are " + ipv4.size() + " unique IP addresses in the log");
				System.out.println("There are " + username.size() + " unique users in the log");
			
				break;
			case 2://case for list of usernames
			
				for (String hashmap : username.keySet()) {
					System.out.println(hashmap + ": " + username.get(hashmap));// prints all keys and values
				}// end modified for loop
			
				System.out.println(totalLines + " " + "lines in the log file were parsed.");
				System.out.println("There are "+ ipv4.size() + " unique IP addresses in the log");
				System.out.println("There are "+ username.size() + " unique users in the log");
			
				break;
			default://default case will return same as case 0.
			
				System.out.println(totalLines + " " + "lines in the log file were parsed.");
				System.out.println("There are"+ ipv4.size() + " unique IP addresses in the log.");
				System.out.println("There are "+ username.size() + " unique users in the log.");
			
		}// end switch 

	}//end main

}//end LogFileProcessor