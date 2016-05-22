package com.neu.myapplication.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue
	@Column(name= "messageid", unique = true, nullable = false)
	private int messageid;
	
	@Column(name="fromaddress")
	private String fromaddress;
	
	@Column(name="toaddress")
	private String toaddress;
	
	public String getFromaddress() {
		return fromaddress;
	}

	public void setFromaddress(String fromaddress) {
		this.fromaddress = fromaddress;
	}

	public String getToaddress() {
		return toaddress;
	}

	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}

	@Column(name="status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public Message(){
		
	}
	
	public Message(String fromAddress, String toAddress, String status){
		this.fromaddress = fromAddress;
		this.toaddress = toAddress;
		this.status = status;
	}
	
}
