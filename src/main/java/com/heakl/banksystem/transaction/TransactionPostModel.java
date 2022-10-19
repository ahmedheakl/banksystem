package com.heakl.banksystem.transaction;

public class TransactionPostModel {
    float amount;
    String receiverName;
    String senderName;

    public TransactionPostModel(float amount, String receiverName, String senderName) {
        this.amount = amount;
        this.receiverName = receiverName;
        this.senderName = senderName;
    }

    public TransactionPostModel() {
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
