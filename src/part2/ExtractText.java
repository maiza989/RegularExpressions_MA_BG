/**
 * This class uses PDFbox 2.0 library from Apache Foundation (pdfbox-app-2.0.24.jar)
 *  to extract the data from the PDF and save it in a plain text file.
 *  
 * @author Maitham Alghamgham, Bobby Gabriel
 * @version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 */
package part2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
 
public class ExtractText {
 
	/**
	 * try-catch statement to catch an IOEception.
	 * Using PDFBox to creating A document to load the pdf file.
	 * Creating a string to whole the pdf data and convert it to text
	 * use PrtintWriter to save the newly created text file. 
	 * closing out and doc
	 * Call ProcessSchedule
	 * @param args
	 */
    public static void main(String[] args) {
    	String search = "Fall21.txt";
    	
    	
        try {
        	
            PDDocument doc = PDDocument.load(new File("2021FA_Class_Schedule_Daily.pdf"));
            String text = new PDFTextStripper().getText(doc);;


            PrintWriter out = new PrintWriter(search);
            out.println(text);
            
            out.close();
		    doc.close();
          
		    ProcessSchedule ps = new ProcessSchedule(search);
            
		    ps.CourseTitles();
		    ps.Seats();
		    ps.ClassCount();
		    
            }// end of try
        catch (IOException e) {
            e.printStackTrace();
        }// end of catch
        
    }// end of main
} // end of class