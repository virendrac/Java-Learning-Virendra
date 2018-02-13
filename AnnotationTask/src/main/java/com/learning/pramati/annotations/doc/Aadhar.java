/**
 * 
 */
package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocType;

import java.util.Date;

/**
 * @author virendra
 *
 */

@DocType(type="aadhaar")
public class Aadhar {

	@DocType(type="fullname")
	private String fullname;

	@DocType(type="gender")
	private String gender;

	@DocType(type="address")
	private String address;

	@DocType(type="dob")
	private Date dob;

	@DocType(type = "AadhaarNumber")
	private long aadhaarNumber;

	public Aadhar() {

	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
}

