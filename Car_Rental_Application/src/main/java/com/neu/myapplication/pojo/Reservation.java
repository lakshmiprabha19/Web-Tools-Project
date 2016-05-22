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
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "reservationId", unique = true, nullable = false)
	private int reservationId;

	@Column(name = "pickLocation")
	private String picklocation;
	
	@Column(name = "dropLocation")
	private String droplocation;
	
	@Column(name="status")
	private String status;	
	
	@Column(name="hours")
	private int hours;
	
	@Column(name="pickupdate")
	private Date pickupdate;
	
	@Column(name="pickuptime")
	private int pickuptime;
	
	@Column(name="pickuptimename")
	private String pickuptimeName;
	
	@Column(name="dropdate")
	private Date dropdate;
	
	@Column(name="droptime", nullable = false)
	private int droptime;
	
	@Column(name="droptimename")
	private String droptimeName;
	

	@ManyToOne
	@JoinColumn(name = "userid")
	private User userid;
	
	@ManyToOne
	@JoinColumn(name = "carId")
	private Car carId;
	
	public int getPickuptime() {
		return pickuptime;
	}

	public void setPickuptime(int pickuptime) {
		this.pickuptime = pickuptime;
	}

	public String getPickuptimeName() {
		return pickuptimeName;
	}

	public void setPickuptimeName(String pickuptimeName) {
		this.pickuptimeName = pickuptimeName;
	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Date getDropdate() {
		return dropdate;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	}

	public void setDropdate(Date dropdate) {
		this.dropdate = dropdate;
	}

	public int getDroptime() {
		return droptime;
	}

	public void setDroptime(int droptime) {
		this.droptime = droptime;
	}

	public String getDroptimeName() {
		return droptimeName;
	}

	public void setDroptimeName(String droptimeName) {
		this.droptimeName = droptimeName;
	}
	
	public Date getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(Date pickupdate) {
		this.pickupdate = pickupdate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getPicklocation() {
		return picklocation;
	}

	public void setPicklocation(String picklocation) {
		this.picklocation = picklocation;
	}

	public String getDroplocation() {
		return droplocation;
	}

	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Car getCarId() {
		return carId;
	}

	public void setCarId(Car carId) {
		this.carId = carId;
	}
	
	public Reservation(){
		
	}
	
	public Reservation(String picklocation, String droplocation, String status, Date pickupdate, int time, String timename, int hours, Car carid, User userid){
		this.droplocation = droplocation;
		this.picklocation = picklocation;
		this.status = status;
		this.carId = carid;
		this.userid = userid;
		this.pickupdate = pickupdate;
		this.pickuptime = time;
		this.pickuptimeName = timename;
		this.hours = hours;
	}
}
