/**
 * 
 */
package com.learning.pramati.annotations.doc;

import java.util.Date;

/**
 * @author virendra
 *
 */

public class PanCard implements Document{


	private String fullname;
	
	private String fatherName;
	
	private String panNumber;
	
	private String issuedBy;
	
	private Date dob;

	public PanCard() {
	}


	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}