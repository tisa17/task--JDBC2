package corejava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InserDataSQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","Computerscience4");  
	           if(conn== null) {
	        	   System.out.println("Connection Failed");
	           }
	           else {
	        	   System.out.println("Success..Connection with MySQL is established");
	           }
	           
	           Statement statement= conn.createStatement();
	           Scanner scanner= new Scanner(System.in);
	           System.out.println("How many records? ");
	           int iteration=scanner.nextInt();
	           int i=1;
	           while(i<=iteration) {
	       
	        System.out.println("Enter Product id Number: ");
	        int pid= scanner.nextInt();
	        System.out.println("Enter Product Name: ");
	        String pname= scanner.next();
	        System.out.println("Enter the Quantity: ");
	        int qua= scanner.nextInt();
	        System.out.println("Enter the Price: ");
	        int price= scanner.nextInt();
	        String sqlQuery="insert into product values("+pid+", '"+ pname+"', '" +qua+"',' "+price+"')";
	        
	        int result=statement.executeUpdate(sqlQuery);
	        if(result==0) {
	        	System.out.println("Failed tto insert the Record");
	        }else {
	        	System.out.println("Record inserted Successfully");
	        }
	        System.out.println("iteration" +i );
	        i++;
	        
	           }
	        statement.close();
	        conn.close();
	        scanner.close();
	        }catch(ClassNotFoundException | SQLException | InputMismatchException ex){
	            System.out.println(ex);
	        }  
	    }

	}


