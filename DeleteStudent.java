package shivani;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent
{
	Scanner sc = new Scanner(System.in);
	public void deleteStudent () throws SQLException
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
			String str = "Delete from Student where student_no=?";
		
			pst =connection.prepareStatement(str);
			
			System.out.println();
			System.out.println("Enter The Roll Number of student which u want to Delete");
			int rno=sc.nextInt();
			
			
			
			System.out.println();
			
			pst.setInt(1, rno);
			
			int k=pst.executeUpdate();
			if(k>0)
				System.out.println("RECORD DELETED SUSSESSFULLY!!!!!");
			else
				System.out.println("SORRY RECORD IS NOT DELETED..");
		}
}}
