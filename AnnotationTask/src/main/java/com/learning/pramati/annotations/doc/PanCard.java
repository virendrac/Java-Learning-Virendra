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

@DocType(type= Documents.PAN)
public class PanCard implements Document{

	@NotNull
	@DocType(type= DocumentFields.FULLNAME)
	private String fullname;
	
	private String fatherName;
	@NotNull
	@DocType(type= DocumentFields.PANNUMBER )
	private String panNumber;
	@NotNull
	@DocType(type= DocumentFields.ISSUEDBY)
	private String issuedBy;
	@NotNull
	@DocType(type= DocumentFields.DOB)
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