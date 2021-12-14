import java.io.File; 
import java.util.Scanner;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class TACSIM2
{

   public static int j, r, i, k, m, num, new_num, p, q, A, X, PP, SR = 0;
   public static String var = "0";
   public static int acc = 0;
   public static String mem2[] = new String[256];
   public static int array2[] = new int[256];
   
   
   public static void main(String[] args) throws Exception  
   {
    TACSIM tacsim2 = new TACSIM();
    
    
    
    int j, r, i, k, m, num, new_num, p, q, A, X, PP, SR = 0;
      var = "0";
      acc = 0;
      //String p1_mem[] = new String[256];
      //int p1_array[] = new int[256];
      
      String p1_str = "";
      File filep1 = new File("p1.asm");
      Scanner scannerp1 = new Scanner(filep1);
      p1_str = scannerp1.nextLine();
      PrintStream p1_fileOut = new PrintStream("p1.obj");
      System.setOut(p1_fileOut);


      while(scannerp1.hasNextLine())
      {

         String[] p1_arr = p1_str.split(" ");
   
         for(String ss : p1_arr) 
         {
            System.out.println(ss);
            tacsim2.convert(ss);
            //System.out.println("Prints here.");
               
         }
         
         p1_str = scannerp1.nextLine();
         
      }
      TACSIM.read(mem2);
      TACSIM.printArray(array2);//////////////////////////////End second test
    }
}