/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marouane;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;

/**
 *
 * @author Marouane
 */
public class Test {
     
        
        
    
    // This method help us to Convert the triangle exist in file to a Matrix2d
    
    public int[][] convertToMatrix2d(File MyFile){
        
     
       int[][] Matrix = new int[100][100];
       BufferedReader reader ; 
       BufferedReader reader2 ; 
       int NumberOfLines = 0;
       String[] lineArray ;
       
       
       try{
          
           
           reader = new BufferedReader(new FileReader(MyFile));
           reader2 = new BufferedReader(new FileReader(MyFile));
           String line = reader.readLine();
           String line2 = reader2.readLine();
           
           // We count the number of lines in triangle
           while(line != null){
               
               NumberOfLines++ ;   
               line = reader.readLine();
               
           }
         
           // We initialise the matrix
           Matrix = new int[NumberOfLines][NumberOfLines];
           
           int j =0 ;
           int maxline = 1;
           
           // we add every Integer in line from file to MaTrix2d Line 
           while(line2!=null ){
           
           lineArray = line2.split(" ");
                 
           for(int i =0 ; i< lineArray.length ; i++){
               
                   Matrix[j][i] = Integer.parseInt(lineArray[i]); 
            }
            
           
           j++;
           // line2 = ;
           line2 = reader2.readLine();
           }
   
           
           // close reading our file
           reader.close() ; 
           reader2.close();
       
       }catch(IOException e){
           e.printStackTrace();
       }catch(NumberFormatException e){
           
       }
       
       

       return Matrix ; 
      
    }
    
    
    // Verify number is Prime
       public boolean isPrime(int number)
        {
            if ((number & 1) == 0)
            {
                if (number == 2)
                {
                    return true;
                }
                return false;
            }
            for (int i = 3; (i * i) <= number; i += 2)
            {
                if (number % i == 0)
                {
                    return false;
                }
            }
            return number != 1;
        }
       
       
       
       /* Downward diagonally :
 
*/
       public int CalculeNode (int i,int j,int[][] Mat, int Somme){
           Test t = new Test();
           
           // We poursuit to the last possible
           if (i < Mat.length-1 && j < Mat.length-1){
           
           // right child element of noeud     
           int  MatrixRightValue = Mat[i+1][j+1];
           // left child element of noeud
           int  MatrixLeftValue = Mat [i+1][j];
          
           // we Stop if the two child is Prime
           if(t.isPrime(MatrixRightValue) && t.isPrime(MatrixLeftValue) ){
               return Somme ; 
               
               
           }else
               // We check if the left element child is Non Prime if Not we passe to the right child
               if(! t.isPrime( MatrixLeftValue)){
                Somme = Somme + MatrixLeftValue ;
             return  CalculeNode(i+1,j,Mat,Somme);
           } else
               
               if (! t.isPrime(MatrixRightValue)){
               Somme = Somme + MatrixRightValue ;
               return CalculeNode(i+1,j+1,Mat,Somme);
           }
           
           
           
           } 
           
           return Somme ; 
       }
       
       
       // We calculate the Som by using this method
       
       public int CalculateMaxSom(int[][] Matrix){
           
           int i = 0 ; 
           int j = 0 ; 
           Test T = new Test();
           // Verify if the noeud is Prime 
           if( T.isPrime(Matrix[0][0])){
               return 0 ;
           } else {
               // If noeud not prime we passe to recursive method
              return T.CalculeNode(0, 0, Matrix, Matrix[0][0]);
           }
           
           
           
       }
       
       
       
       
       
       // calculate MaxSom
       
       
       
       
       
    
    
    
    
     public static void main(String []args){
     
       
         
         
         Test t = new Test() ;
         // We past the pat of our file
         File file = new File("/Users/DS/Documents/NetBeansProjects/marouane/src/marouane/triangle");
 
            // Convert Triangle to Matrix2d
            
           int[][] mat = t.convertToMatrix2d(file);
  
  
           // print Result
           
           System.out.println(t.CalculateMaxSom(mat));
        
     

        
        
     } 
}
