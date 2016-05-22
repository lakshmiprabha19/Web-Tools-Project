package com.neu.myapplication.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Reservation;
import com.neu.myapplication.pojo.User;

public class CarDAO extends DAO{
	
	public CarDAO() {
    }
	
	public Car addCar(Car car) throws Exception {
        try {
            System.out.println("inside DAO");
            begin();
            Car car1= new Car(car.getCarName(),car.getCarBrand(), car.getCarModel(), car.getColor(), car.getProductionYear(), car.getPhotoName()); 
            System.out.println("ssssss car"+car1);
        	getSession().save(car1);
        	System.out.println("after session"+car1);
            commit();
            close();
            return car1;
            
        } catch (HibernateException e) {
            //throw new AdException("Could not create user " + username, e);
            System.out.println("Message"+e.getLocalizedMessage());
        }
		return null;
    }
	
	public List<Car> getCarList() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Car");
            List<Car> list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the cars", e);
        }
    }
	
	public Car getCar(int carId) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Car where carId= :carId");
            q.setInteger("carId",carId);
            Car car=(Car)q.uniqueResult();
            commit();
            return car;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named car " + carId + " " + e.getMessage());
        }
    }
	
	public Car getCarFromReservation(Car carId) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Car where carId= :carId");
            q.setEntity("carId",carId);
            Car car=(Car)q.uniqueResult();
            System.out.println("after"+car);
            commit();
            return car;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named car " + carId + " " + e.getMessage());
        }
    }
	
}
