package com.neu.myapplication.dao;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Reservation;
import com.neu.myapplication.pojo.User;

public class ReservationDAO extends DAO{
	public ReservationDAO(){
		
	}
	
	public Reservation addReservation(String picklocation, String droplocation, String status, Date pickupdate, int time, String timename, int hours, Car carid, User userid) throws Exception {
        try {
            System.out.println("inside DAO");
            begin();
            String status1 = "reserved";
            Reservation r = new Reservation(picklocation,droplocation, status1, pickupdate, time, timename, hours, carid, userid); 
            System.out.println("ssssss car"+r);
        	getSession().save(r);
        	System.out.println("after session"+r);
            commit();
            close();
            return r;
            
        } catch (HibernateException e) {
            //throw new AdException("Could not create user " + username, e);
            System.out.println("Message"+e.getLocalizedMessage());
        }
		return null;
    }
	
	public Reservation getReservationData(User user) throws AdException {
		System.out.println("inside ree data");
		try {
            begin();
            System.out.println("inside dao"+user);
            Query q=getSession().createQuery("from Reservation where userid= :userid and status= :status");
            q.setInteger("userid",user.getUserId());
            q.setString("status", "reserved");
            Reservation r=(Reservation)q.uniqueResult();
            commit();
            return r;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the reservation for user " + user.getFirstName() + " " + e.getMessage());
        }
	}
	
	public Reservation updateDropDetails(Reservation reservation, int r_id) throws AdException {
		System.out.println("inside drop data");
		try {
            begin();
            Reservation r = getReservation(r_id);
            System.out.println("dsfdsfdsf"+r.getDropdate());
			r.setDropdate(reservation.getDropdate());
			r.setDroptime(reservation.getDroptime());
			r.setDroptimeName(reservation.getDroptimeName());
			r.setStatus("dropped");
            getSession().update(r);
            commit();
            return r;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the reservation for user " + e.getMessage());
        }
		
	}
	
	public Reservation getReservation(int rid) throws AdException {
        try {
            
            Query q=getSession().createQuery("from Reservation where reservationId= :rid");
            q.setInteger("rid",rid);
            Reservation r=(Reservation)q.uniqueResult();
            
            return r;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named reservation ");
        }
    }
	
	public Long calculateHoursUsed(Reservation r){
		int pickuptime = r.getPickuptime();
		int droptime = r.getDroptime();
		String pickupname = r.getPickuptimeName();
		String dropname = r.getDroptimeName();
		String pickuptime1 = pickuptime + ":00" + " "+ pickupname;
		String droptime1 = droptime + ":00" + " " + dropname;
		System.out.println("inside hours cal"+ pickuptime1);
		System.out.println("inside hours cal"+ droptime1);
		DateTimeFormatter format = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.SHORT);
        LocalTime time1 = LocalTime.parse(pickuptime1, format);
        LocalTime time2 = LocalTime.parse(droptime1, format);
        Duration duration = Duration.between(time1, time2);
        long hours = Math.abs(duration.getSeconds() / 3600);
        System.out.println(hours);
        return hours;
	}
	
	public double calculateAmount(long hours){
		double amount = 5.0;
		double hours1 = (double) hours;
		amount = amount * hours1;
		return amount;
	}
	
	public double calculateTotalAmount(double amount){
		double tax = 1.25;
		double totalAmount = tax*amount;
		return totalAmount;
	}
}
