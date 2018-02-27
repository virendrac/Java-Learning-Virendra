package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocConsistency;
import com.learning.pramati.annotations.common.Documents;

@DocConsistency
public class DocumentSet {
    @DocConsistency(type = Documents.AADHAAR)
    private Aadhar aadhar;
    @DocConsistency(type = Documents.PAN)
    private PanCard panCard;
    @DocConsistency(type = Documents.BANKSTMT)
    private BankStatement bankStatement;

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }

    public PanCard getPanCard() {
        return panCard;
    }

    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }

    public BankStatement getBankStatement() {
        return bankStatement;
    }

    public void setBankStatement(BankStatement bankStatement) {
        this.bankStatement = bankStatement;
    }
}
