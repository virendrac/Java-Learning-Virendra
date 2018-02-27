/**
 * 
 */
package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocType;
import com.learning.pramati.annotations.common.Documents;

import java.util.List;

/**
 * @author virendra
 *
 */
@DocType(type= Documents.BANKSTMT)
public class BankStatement implements Document {
	
	private String accountNumber;

	private String customerName;
	
	private List<Transaction> transactions;
	
	private String address;
	
	private String mobileNumber;
	
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