
package application;
import java.io.*;
import java.util.Scanner;

import javafx.scene.control.TextField;

public class passwordChecker {
     private static final String fileName ="User.txt";
    // payment p = new payment();
     
     public static  boolean login(TextField user, TextField pass){
         System.out.println("User name:\n");
         String userName = user.getText();
         System.out.println("Password: \n");
         String password = pass.getText();
         boolean flg=false;
         try{
             FileReader fin = new FileReader(fileName);
             BufferedReader bin = new BufferedReader(fin);
             String line;
             while((line=bin.readLine())!=null){
                 String cr[] = line.split(",");
                 if(cr.length==2 && cr[0].equals(userName) && cr[1].equals(password)){
                     System.out.println("Login successful");
                     flg=true; break;
                    // p.paymentprocess(2);
                 }
                 
             }
             if(!flg) {
            	 System.out.println("Incorrect password or username");
                // flg=false;
                 
             }
             bin.close();
             fin.close();
            
         }
         catch(IOException e){
             System.out.println(e.getMessage());
         }
         return flg;
     }
        public static void register(TextField user, TextField pass) {
        System.out.print("Enter a new username: ");
        String username = user.getText();
        System.out.print("Enter a new password: ");
        String password = pass.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
     }
        
}
