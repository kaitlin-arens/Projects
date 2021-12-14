import java.io.File; 
import java.util.Scanner;
import java.io.PrintStream;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class TACSIM
{
   public static int j, r, i, k, m, num, new_num, p, q, A, X, PP, SR = 0;
   public static String var = "0";
   public static int acc = 0;
   public static String mem[] = new String[256];
   public static int array[] = new int[256];
   //public static int array_p1[] = new int[256];
   
   
   public static String[] convert(String string)
   {
      if(string.compareTo("NOP") == 0)
      {
         var = "0";
         mem[j] = var;
      }
      
      else if(string.compareTo("ADD") == 0)
      {
         var = "1";
         mem[j] = var;
      }
      
      else if(string.compareTo("CMP") == 0)
      {
         var = "3";
         mem[j] = var;
      }
      
      else if(string.compareTo("JGT") == 0)
      {
         var = "4";
         mem[j] = var; 
      }
      
      else if(string.compareTo("JMP") == 0)
      {
         var = "5";
         mem[j] = var;
      }
      
      else if(string.compareTo("LD") == 0)
      {
        var = "6";
        mem[j] = var;
      }
      
      else if(string.compareTo("MVX") == 0)
      {
         var = "9";
         mem[j] = var; 
      }
      
      else if(string.compareTo("ST") == 0)
      {
         var = "10";
         mem[j] = var;
      }
      
      else if(string.compareTo("AND") == 0)
      {
         var = "11";
         mem[j] = var;
      }
      
      else if(string.compareTo("OR") == 0)
      {
         var = "12";
         mem[j] = var;
      }
      
      else if(string.compareTo("XOR") == 0)
      {
         var = "13";
         mem[j] = var; 
      }
      
      else if(string.compareTo("JLE") == 0)
      {
         var = "14";
         mem[j] = var;
      }
      
      else if(string.compareTo("HLT") == 0)
      {
         var = "15";
         mem[j] = var;
      }
      
       else if(string == null)
       {
         mem[j]= "0";
       }
       
       else
       {
         mem[j] = string;
       }
       
       j++;
      return mem;
   }
   
   public static void printArray(int[] arr)
   {
      //System.out.println("Has entered the printArray function");
      k=0;
      r=0;
      while(k < 16)
      {
         i=0;
         
         while(i < 16)
         {
            System.out.format("%5d", arr[r]);
            r++;
            i++;
         }
         System.out.println();
         k++;
      } 
      System.out.println("A: " + A); //accumulator
      System.out.println("X: " + (X -1));//index register
      System.out.println("PP: " + PP); //program pointer
      System.out.println("SR: "+ SR);//status register   
   }
   
   public static int[] read(String[] a)
   {
      //System.out.println("Has entered the read function");
      i=0;
      for(i = 0; i < 256; i = i+2)
      {
         if(a[i] == "0")
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            A = A + new_num;
            X = X +2;
         }
         
         else if(a[i] == "1")//ADD
         {

            if(a[i+1].startsWith("("))
            {
               String replaced = a[i+1].replaceAll("[()]", "");//get rid of ()
               new_num = Integer.parseInt(replaced);
               array[i+1] = new_num;
               A = A + array[new_num];
               array[i] = 2;
               X = X +2;
            }
            else
            {
               new_num = Integer.parseInt(a[i+1]);
               array[i+1] = new_num;
               A = A + new_num;
               array[i] = 1;
               X = X +2;
            }   
         }
         
         else if(a[i] == "3")//CMP
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            new_num = Integer.parseInt(a[i+1]);
            array[i+1]= new_num;
            X = X +2;
            if(A > new_num)
            {
               SR = 1;
            }
            
            else
            {
               SR = 0;
            }
         }
         
         else if(a[i] == "4")//JGT
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            String replaced = a[i+1].replaceAll("[()]", "");//get rid of ()
            new_num = Integer.parseInt(replaced);
            array[i+1] = new_num;
            X = X +2;
            if(SR == 1)
            {
               PP = new_num;
            }
               
         }
         
         else if(a[i] == "5")//JMP
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            
            String replaced = a[i+1].replaceAll("[()]", "");//get rid of ()
            new_num = Integer.parseInt(replaced);
            array[i+1] = new_num;
            PP = new_num;
            X = X +2;   
         }
         
         else if(a[i] == "6")//LD
         {
           
            
            if(a[i+1].startsWith("("))
            {
               String replaced = a[i+1].replaceAll("[()]", "");//get rid of ()
               new_num = Integer.parseInt(replaced);
               A = array[new_num];
               array[i+1] = array[new_num];
               
               array[i] = 7;
               
            }  
            
            else if (a[i+1].startsWith("X"))
            {
               
               String replaced = a[i+1].replaceAll("X", "");//get rid of ()
               String replaced2 = replaced.replaceAll("[()]", "");
               new_num = Integer.parseInt(replaced2);
               A = new_num + X;
               array[i+1] = new_num;
               array[i] = 8;
               
            }
            
            else
            {
               
               new_num = Integer.parseInt(a[i]);
               array[i] = new_num;
               new_num = Integer.parseInt(a[i+1]);
               array[i+1] = new_num;
               A = new_num;
 
            }
           X = X +2;
         }
         
         else if(a[i] == "9")//MVX
         {
            
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            X = A;
            array[i+1] = X;
            //X = X +2;
         }
         
          else if(a[i] == "10")//ST
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            String replaced = a[i+1].replaceAll("[()]", "");//get rid of ()
            new_num = Integer.parseInt(replaced);
            array[i+1] = new_num;
            array[new_num] = A;  
            X = X +2;  
         }
         
         else if(a[i] == "11")//AND
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            new_num = Integer.parseInt(a[i+1]);
            array[i+1] = new_num;
            A = A & new_num;
            X = X +2;
         }
         
         else if(a[i] == "12")//OR
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            new_num = Integer.parseInt(a[i+1]);
            array[i+1] = new_num;
            A = A | new_num;
            X = X +2;
         }
         
         else if(a[i] == "13")//XOR
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            int new_num1 = Integer.parseInt(a[i+1]);
            array[i+1] = new_num1;
            A = A ^ new_num1;
            X = X +2;
         }
         
         else if(a[i] == "14")//JLE
         {
            new_num = Integer.parseInt(a[i]);
            array[i] = new_num;
            new_num = Integer.parseInt(a[i+1]);
            array[i+1] = new_num;
            X = X +2;
            if(SR == 0)
            {
               PP = new_num;
            }
         }
         
         else//HLT
         {
            new_num = 15;
            array[i] = new_num;
            X = X +2; 
            return array;
            
         }

      }
      return array;
   }

   public static void main(String[] args) throws Exception 
   { 
      String str = "";/////////////////////////////////////////////////////////////////////////////////////////////Start first test
   
      File file = new File("text.obj");
      Scanner scanner = new Scanner(file);
      str = scanner.nextLine();
      PrintStream fileOut = new PrintStream("out.obj");
      System.setOut(fileOut);

      while(scanner.hasNextLine())
      {

         String[] arr = str.split(" ");
   
         for(String ss : arr) 
         {
            System.out.println(ss);
            convert(ss);
               
         }
         
         str = scanner.nextLine();
         
      }
      scanner.close();
      read(mem);
      printArray(array);///////////////////////////////////////////////////////////////////////////////////////////End first test
      
      
      
      /*//int j, r, i, k, m, num, new_num, p, q, A, X, PP, SR = 0;////////////////////////////////////////////////////Start second test
      var = "0";
      acc = 0;
      
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
            convert(ss);
            //System.out.println("Prints here.");
               
         }
         
         p1_str = scannerp1.nextLine();
         
      }
      scannerp1.close();
      read(mem);
      printArray(array);*////////////////////////////////////////////////////////////////////////////////////////////End second test
      
      
      //int j, r, i, k, m, num, new_num, p, q, A, X, PP, SR = 0;////////////////////////////////////////////////////Start third test
      /*var = "0";
      acc = 0;
      
      String p2_str = "";
   
      File p2_file = new File("p2.asm");
      Scanner p2_scanner = new Scanner(p2_file);
      p2_str = p2_scanner.nextLine();
      PrintStream p2_fileOut = new PrintStream("p2.obj");
      System.setOut(p2_fileOut);

      while(p2_scanner.hasNextLine())
      {

         String[] arr = p2_str.split(" ");
   
         for(String ss : arr) 
         {
            System.out.println(ss);
            convert(ss);
               
         }
         
         p2_str = p2_scanner.nextLine();
         
      }
      p2_scanner.close();
      read(mem);
      printArray(array);*////////////////////////////////////////////////////////////////////////////////////////////End third test
    }
   
   
   
} 