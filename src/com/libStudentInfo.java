package com.Bean;

public class libStudentInfo {
	private int stud_id;
	private String name;
	private String gender;
	private String address;
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "libStudentInfo [stud_id=" + stud_id + ", name=" + name + ", gender=" + gender + ", address=" + address
				+ "]";
	}
	
	

		
}
