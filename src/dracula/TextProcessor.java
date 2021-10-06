/**
 * @author Bobby Gabriel, Maitham
 * @version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 */
package dracula;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;


public class TextProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//public static boolean useRegex(final String input) {
		
		final Pattern pattern = Pattern.compile("\\W[Aa]\\W", Pattern.CASE_INSENSITIVE);
        // Match regex against input "a"
        //final Matcher matcher = pattern.matcher(input);
        // Use results...
        //return matcher.matches();
		}
	
	/**
	 * File csvFile = new File("Bobbys-MBP:~ bobby$/Desktop/Programming/auth.log.1.csv");
	      		BufferedReader br = new BufferedReader(new FileReader(csvFile));
	      		String line = "";
	      		try {
	      			while ((line = br.readLine()) != null) {
	      				String [] count = line.split(",");
	      				
	      			}
	      		} catch (FileNotFoundException e) {
	      			e.printStackTrace();
	      		}
	}
}
	 */
	}


