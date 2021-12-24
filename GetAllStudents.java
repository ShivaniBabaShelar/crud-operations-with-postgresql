package shivani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetAllStudents {
	Scanner sc = new Scanner(System.in);
	
	public void getAllStudents() throws SQLException
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
		//	String str = "Select * from student";
		
			pst =connection.prepareStatement("Select * from student");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
			  System.out.println();
			  System.out.print(rs.getInt(1));
			  System.out.print("\t");
			  System.out.print(rs.getString(2));
			  System.out.print("\t\t");
			  System.out.print(rs.getDate(3));
			  System.out.print("\t");
			  System.out.print(rs.getDate(4));
			}
			
			
		}
	}
}
