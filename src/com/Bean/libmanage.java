package com.Bean;

public class libmanage {
	private int reg_no;
	private int book_id;
	private int stud_id;
	private String date_of_issues;
	private String due_date;
	private String date_of_return;
	
	

	@Override
	public String toString() {
		return "libmanage [reg_no=" + reg_no + ", book_id=" + book_id + ", stud_id=" + stud_id + ", date_of_issues="
				+ date_of_issues + ", due_date=" + due_date + ", date_of_return=" + date_of_return + "]";
	}

	public int getReg_no() {
		return reg_no;
	}

	public void setReg_no(int reg_no) {
		this.reg_no = reg_no;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getDate_of_issues() {
		return date_of_issues;
	}

	public void setDate_of_issues(String date_of_issues) {
		this.date_of_issues = date_of_issues;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getDate_of_return() {
		return date_of_return;
	}

	public void setDate_of_return(String date_of_return) {
		this.date_of_return = date_of_return;
	}
}