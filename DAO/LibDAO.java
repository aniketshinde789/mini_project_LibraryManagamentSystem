package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Bean.books;
import com.Bean.libStudentInfo;
import com.Bean.libmanage;
import com.Configuration.DB_Connect;
import com.mysql.cj.protocol.Resultset;

public class LibDAO {
	Scanner sc = new Scanner(System.in);
	libmanage lm = new libmanage();
	books b = new books();
	libStudentInfo ls = new libStudentInfo();
	int rs = 0;
	int rs1 = 0;

	public void addBook(Connection con) {
		String sql = "insert into books(book_id, book_name, no_of_copies, price, status, author_name) values(?,?,?,?,?,?)";

		System.out.println("Enter book_id");
		int book_id = sc.nextInt();

		System.out.println("Enter book_name");
		String book_name = sc.next();

		System.out.println("Enter  no_of_copies");
		int no_of_copies = sc.nextInt();

		System.out.println("Enter price");
		int price = sc.nextInt();

		System.out.println("Enter status");
		String status = sc.next();

		System.out.println("Enter author_name");
		String author_name = sc.next();

		b.setBook_id(book_id);
		b.setBook_name(book_name);
		b.setNo_of_copies(no_of_copies);
		b.setPrice(price);
		b.setStatus(status);
		b.setAuthor_name(author_name);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b.getBook_id());
			ps.setString(2, b.getBook_name());
			ps.setInt(3, b.getNo_of_copies());
			ps.setInt(4, b.getPrice());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getAuthor_name());
			ps.executeUpdate();
			//System.out.println(b);
			System.out.println("Add succesufully");
		} catch (Exception e) {
			System.out.println("Data unsuffient " + e.toString());
		}

	}

	public void deleteBook(Connection con) {
		String sql = "delete from books  where book_id=?";
		System.out.println("Enter book_id");
		int book_id = sc.nextInt();

		b.setBook_id(book_id);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b.getBook_id());
			ps.execute();
			System.out.println("Deleted data successfully");
		} catch (Exception e) {
			System.out.println("Data not delete");
		}
	}

	public void updateData(Connection con) {
		String sql = "update books set author_name=?,price=? where book_id=?";
		System.out.println("Enter book_id");
		int book_id = sc.nextInt();

		System.out.println("Enter author name");
		String author_name = sc.next();

		System.out.println("Enter price");
		int price = sc.nextInt();

		b.setBook_id(book_id);
		b.setAuthor_name(author_name);
		b.setPrice(price);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, b.getBook_id());
			ps.setString(1, b.getAuthor_name());
			ps.setInt(2, b.getPrice());
			rs = ps.executeUpdate();
			System.out.println("Get data successfully");

		} catch (Exception e) {
			System.out.println("Unsufficient data");
			e.printStackTrace();
		}
	}

	public void searchData(Connection con) {
		String sql = "select * from books where  book_name =?";

		System.out.println("Enter Book name");
		String book_name = sc.next();

		b.setBook_name(book_name);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getBook_name());

			
			ResultSet rs2 = ps.executeQuery();

			if (rs2.next()) {

				System.out.println("book_name::" + rs2.getString(2));
				System.out.println("book_id::" + rs2.getInt(1));
				System.out.println("no_of_copies::" + rs2.getInt(3));
				System.out.println("price::" + rs2.getInt(4));
				System.out.println("status::" + rs2.getString(5));
				System.out.println("author_name::" + rs2.getString(6));
			

			} else {
				System.out.println("Give proper name");
			}

		} catch (SQLException e) {
			System.out.println("Give proper book_name");
			e.printStackTrace();
		}
	}

	public void addMember(Connection con) {
		String sql = "insert into libstudentinfo (stud_id,name,gender,address) values(?,?,?,?)";
		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter gender");
		String gender = sc.next();

		System.out.println("Enter address");
		String address = sc.next();

		ls.setStud_id(stud_id);
		ls.setName(name);
		ls.setGender(gender);
		ls.setAddress(address);


		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, ls.getStud_id());
			ps.setString(2, ls.getName());
			ps.setString(3, ls.getGender());
			ps.setNString(4, ls.getAddress());

			ps.execute();
			System.out.println("Memeber added succesfully");
		} catch (SQLException e) {
			System.out.println("Invalid data");
			e.printStackTrace();
		}
	}

	public void removeMember(Connection con) {
		String sql = "delete from libstudentinfo where stud_id= ?";
		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		ls.setStud_id(stud_id);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ls.getStud_id());
			ps.executeUpdate();
			System.out.println("Memeber remove successfully");
		} catch (SQLException e) {
			System.out.println("Enter proper stud_id");
			e.printStackTrace();
		}
	}

	public void updateMemberInfo(Connection con) {
		String sql = "update libstudentinfo set name=?,gender=?,address=? where stud_id=?;";
		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter gender");
		String gender = sc.next();

		System.out.println("Enter address");
		String address = sc.next();

		ls.setStud_id(stud_id);
		ls.setName(name);
		ls.setGender(gender);
		ls.setAddress(address);
		

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, ls.getStud_id());
			ps.setString(1, ls.getName());
			ps.setString(2, ls.getGender());
			ps.setString(3, ls.getAddress());
			// ps.setInt(5, ls.getReg_no());
			ps.executeUpdate();
			System.out.println("Upadte information succesfully");
		} catch (SQLException e) {
			System.out.println("acc_no is Invalid");
			e.printStackTrace();
		}
	}

	public void issueBook(Connection con) {

		System.out.println("Enter book_id");
		int book_id = sc.nextInt();

		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		System.out.println("Enter date_of_issues");
		String date_of_issues = sc.next();

		System.out.println("Enter date_of_due");
		String due_date = sc.next();

		lm.setBook_id(book_id);
		lm.setStud_id(stud_id);
		lm.setDate_of_issues(date_of_issues);
		lm.setDue_date(due_date);

		try {

			PreparedStatement ps = con.prepareStatement(
					"insert into libmanage(book_id, stud_id, date_of_issues, due_date) values(?,?,?,?);");
			ps.setInt(1, lm.getBook_id());
			ps.setInt(2, lm.getStud_id());
			ps.setString(3, lm.getDate_of_issues());
			ps.setString(4, lm.getDue_date());

			int temp = ps.executeUpdate();

			if (temp == 1)
				System.out.println("Book issues successfully");
			else
				System.out.println("sorry");
		} catch (SQLException e) {
			System.out.println("Book issues successfully");
		}
	}

	public void recordReturn(Connection con) {
		String sql = "select l.book_id, b.book_name from books b inner join libmanage l on b.book_id = l.book_id where l.stud_id = ?";

		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		ls.setStud_id(stud_id);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ls.getStud_id());
			ResultSet rs3 = ps.executeQuery();

			if (rs3.next()) {

				System.out.println("book_id::" + rs3.getInt(1));
				System.out.println("book_name::" + rs3.getString(2));

				System.out.println("Recored return succesfully");
			} else {
				System.out.println("Invalid stud_id");
			}
		} catch (SQLException e) {
			System.out.println("Invalid stud_id");
			e.printStackTrace();
		}
	}

	public void fine(Connection con) {

		String sql = "select stud_id,date_of_return,due_date ,datediff(date_of_return,due_date) as diff from libmanage where stud_id=?";
		System.out.println("Enter stud_id");
		int stud_id = sc.nextInt();

		lm.setStud_id(stud_id);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, lm.getStud_id());

			ResultSet rs4 = ps.executeQuery();
			int pay = 0;
			while (rs4.next()) {
				pay = 10 * rs4.getInt(4);

			}
			System.out.println("fine is " + pay);

		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}
	
	

}
