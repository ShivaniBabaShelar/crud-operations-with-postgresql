package shivani;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent
{
	
	Scanner sc = new Scanner(System.in);
	public void updateStudent () throws SQLException
	{
		final String url="jdbc:postgresql://localhost/postgres";
		final String user="postgres";
		final String password="shivani";
		Scanner sc= new Scanner(System.in);
		
		PreparedStatement pst=null;
		ResultSet rs;
		
		try(Connection connection = DriverManager.getConnection(url,user,password);)
		{
			if(connection!=null)
			{
				System.out.print("CONNECTION WITH DATABASE SUCCESSFULL!!!");
			}
			else
			{
				System.out.println("SORRY!!!CONNECTION WITH DATABASE NOT SUCCESSFULL.");
				
			}
			String str = "Update Student Set student_name=?,student_dob=?,student_doj=? Where student_no=?";
		
			pst =connection.prepareStatement(str);
			
			System.out.println();
			System.out.println("Enter The Roll Number of Student wWhose information you have to change");
			int rno=sc.nextInt();
			
			System.out.println("Enter The Name Of Student");
			String name=sc.next();
			System.out.println();
			
			System.out.println("Enter The DOB of Student in (yyyy-mm-dd) format");
			String date1=sc.next();
		    Date DOB=Date.valueOf(date1);
			System.out.println();
			
			System.out.println("Enter The DOJ Of Student in (yyyy-mm-dd) format");
			String date2=sc.next();
			 Date DOJ=Date.valueOf(date1);
			
			System.out.println();
			pst.setString(1, name);
			pst.setDate(2,  DOB);
			pst.setDate(3,  DOJ);
			pst.setInt(4, rno);
			
			int k=pst.executeUpdate();
			if(k>0)
				System.out.println("RECORD UPDATED SUSSESSFULLY!!!!!");
			else
				System.out.println("SORRY RECORD IS NOT UPDATED..");
		
			
	}
}}
