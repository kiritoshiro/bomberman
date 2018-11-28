import greenfoot.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Write a description of class ivedimas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ivedimas  extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    public String hide;
   // public int value;
  
   public int kiekis;
    public void isvedimas(int value)throws IOException{
            PrintWriter file = new PrintWriter(new FileWriter("duom.txt"));
            file.println(value);
            file.close();
    }
    public void skaitymas() throws IOException{
            FileReader file = new FileReader("duom.txt");
            Scanner src = new Scanner(file);
            kiekis = src.nextInt();
    }
    
    
    public void writinti() throws IOException {
        FileReader fin = new FileReader("duom.txt"); 
        Scanner src = new Scanner(fin);
        hide = src.next();
        
        fin.close();
        

    }

    public String getHideKey(){
        return hide;

    }

}
