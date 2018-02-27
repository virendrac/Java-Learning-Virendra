/**
 * 
 */
package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.DocumentFields;
import com.learning.pramati.annotations.common.Documents;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author virendra
 *
 */
@DocType(type= Documents.BANKSTMT)
public class BankStatement implements Document {
	@NotNull
	private String accountNumber;
	@NotNull
	@DocType(type= DocumentFields.FULLNAME)
	private String customerName;
	
	private List<Transaction> transactions;
	@NotNull
	@DocType(type=DocumentFields.ADDRESS)
	private String address;
	@NotNull
	@DocType(type= DocumentFields.MOBILENUMBER)
	private String mobileNumber;
	@NotNull
	@DocType(type= DocumentFields.EMAIL)
	private String email;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}