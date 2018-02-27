package com.learning.pramati.annotations.doc;

import com.learning.pramati.annotations.DocConsistency;

@DocConsistency
public class DocumentSet {
    private Aadhar aadhar;
    private PanCard panCard;
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
