package patterns.sierra_bates_patterns.decorator.input_output_api;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by a on 15.02.17.
 */
public class InputTest {
    public static void main(String[] args) {
 int c;
 try {
     InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("text.txt")));

     while ( (c=in.read()) >= 0){
         System.out.print((char)c);
     }
 } catch(IOException e ){
     e.printStackTrace();
 }
    }
}