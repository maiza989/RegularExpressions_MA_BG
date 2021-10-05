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
 
    public static void main(String[] args) {
        try {
            PDDocument doc = PDDocument.load(new File("C:\\Users\\maith\\Downloads\\2021FA_Class_Schedule_Daily.pdf"));
            String text = new PDFTextStripper().getText(doc);;
            System.out.println("Text in PDF\n---------------------------------");
            System.out.println(text);
            
            PrintWriter out = new PrintWriter("C:\\Users\\maith\\Desktop\\School\\CS-322\\RegularExpressions_MABG\\src\\part2\\Fall21.txt");
            out.println(text);
          
            
            }// end of try
        catch (IOException e) {
            e.printStackTrace();
        }// end of catch
        
    }// end of main
} // end of class