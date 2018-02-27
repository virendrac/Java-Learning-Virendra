/**
 * 
 */
package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.DocumentFields;
import com.learning.pramati.annotations.common.Documents;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author virendra
 *
 */

@DocType(type= Documents.AADHAAR)
public class Aadhar implements Document{

	@NotNull
	@DocType(type= DocumentFields.FULLNAME)
	private String fullname;

	@NotNull
	@DocType(type=DocumentFields.GENDER)
	private String gender;

	@NotNull
	@DocType(type=DocumentFields.ADDRESS)
	private String address;

	@NotNull
	@DocType(type=DocumentFields.DOB)
	private Date dob;

	@NotNull
	@DocType(type = DocumentFields.AADHAARNUMBER)
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

