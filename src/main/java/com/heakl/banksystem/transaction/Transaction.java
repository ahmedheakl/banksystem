package com.heakl.banksystem.transaction;

import com.heakl.banksystem.customer.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="sender_foreign_key"))
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="receiver_foreign_key"))
    private Customer receiver;

    @Column(name = "time_stamp", columnDefinition = "timestamp default now()", nullable = false)
    private Date timeStamp;

    private float amount;


    public Transaction(Long id, Customer sender, Customer receiver, float amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Transaction() {

    }

    public Transaction(Customer sender, Customer receiver, float amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;

    }

    public Long getId() {
        return id;
    }

    public Customer getSender() {
        return sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public Date getTimeStamp(){
        return timeStamp;
    }

    public float getAmount(){
        return amount;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }

    public String toString(){
        return "Transaction: {" + id + ", " + amount + ", " + receiver + "}";
    }

}
