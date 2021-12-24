package shivani;

import java.sql.SQLException;
import java.util.Scanner;


public class Student 
{
	
	public static void main(String[] args) throws SQLException
	{
		Scanner sc= new Scanner(System.in);
		int choice = 0;
		new Student();
		
		do
		{
		System.out.println("Select One Operation....");
		System.out.println("1:Insert Student Data into Student Table.");
		System.out.println("2:Update Student Data into Student Table.");
		System.out.println("3:Delete Student Data from Student Table.");
		System.out.println("4:Get a list of all Students from Student Table.");
		System.out.println("5:Get one student information depending on the student id filter from Student Table");
		
	
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1: InsertStudent insert = new InsertStudent();
				insert.insertStudent();
				break;
				
		case 2: UpdateStudent update = new UpdateStudent();
				update.updateStudent();
				break;
			
		case 3: DeleteStudent delete = new DeleteStudent();
				delete.deleteStudent();
				break;
			
			
		case 4: GetAllStudents getall = new GetAllStudents();
				getall.getAllStudents();
				break;
			
		case 5: GetOneStudent getone = new GetOneStudent();
				getone.getOneStudent();
				break;
				
		case 0: break;
				
		default:System.out.println("Please Select Correct Choice.....");
			
		}
	}while(choice!=0);
		
		System.out.println("FINISH.....");
	}
	
}

