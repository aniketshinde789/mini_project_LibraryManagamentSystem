package com.Controller;

import java.sql.Connection;
import java.util.Scanner;

import com.Bean.books;
import com.Configuration.DB_Connect;
import com.DAO.LibDAO;

public class ApplicationStart {

	public static void main(String[] args) {
		
		Connection con =DB_Connect.myConn();
		
		LibDAO ld = new LibDAO();

	
		

		Scanner sc = new Scanner(System.in);
	while(true) {	
		if(con!=null)
		{
		System.out.println("Enter 1 for add book");
		System.out.println("Enter 2 for delete data");
		System.out.println("Enter 3 for update data");
		System.out.println("Enter 4 for Search data");
		System.out.println("Enter 5 for Add new member");
		System.out.println("Enter 6 for Remove member");
		System.out.println("Enter 7 for Update memeber information");
		System.out.println("Enter 8 for issues book");
		System.out.println("Enter 9 for record book");
		System.out.println("enter you choice ");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			System.out.println("Add new book to library");
			ld.addBook(con);
			break;
		case 2:
			System.out.println("Delete data from library");
			ld.deleteBook(con);
			break;
		case 3:
			System.out.println("Update data from library");
			ld.updateData(con);
			break;
		case 4:
			System.out.println("Search data from library");
			ld.searchData(con);
			break;
		case 5:
			System.out.println("Add new memebr");
			ld.addMember(con);
			break;
		case 6:
			System.out.println("Remove member");
			ld.removeMember(con);
			break;
		case 7:
			System.out.println("Update memeber information");
		ld.updateMemberInfo(con);
			break;
		case 8:
			System.out.println("Book issues ");
			ld.issueBook(con);
			break;
		case 9:
			System.out.println("Record return");
			ld.recordReturn(con);
			break;
		}
	}
		else
		{
			System.out.println("Invalid username and password");
			System.exit(0);
		}
	}
	}

}
