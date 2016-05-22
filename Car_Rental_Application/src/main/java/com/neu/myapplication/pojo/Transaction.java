package com.neu.myapplication.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "transactionId", unique = true, nullable = false)
	private int transactionId;
	
	@Column(name = "transactionamount")
	private double transactionAmount;
	
	@Column(name = "cardnumber")
	private long cardnumber;
	
	@Column(name = "expiryyear")
	private int expiryYear;
	
	@Column(name = "expirymonth")
	private int expirymonth;
	
	@Column(name = "cvv")
	private int cvv;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User userid;
	
	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getExpirymonth() {
		return expirymonth;
	}

	public void setExpirymonth(int expirymonth) {
		this.expirymonth = expirymonth;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public Transaction(){
		
	}
	
	public Transaction(double transactionamount, long number, int year, int month, int cvv, User userid){
		this.transactionAmount = transactionamount;
		this.cardnumber = number;
		this.expiryYear = year;
		this.expirymonth = month;
		this.cvv = cvv;
		this.userid = userid;
	}
}
