package com.neu.myapplication.dao;

import org.hibernate.HibernateException;

import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Transaction;
import com.neu.myapplication.pojo.User;

public class TransactionDAO extends DAO{
	public Transaction addTransaction(Transaction t, User u){
		try {
            System.out.println("inside DAO");
            begin();
            Transaction transaction = new Transaction(t.getTransactionAmount(), t.getCardnumber(), t.getExpiryYear(),t.getExpirymonth(), t.getCvv(), u); 
            System.out.println("ssssss car"+transaction);
        	getSession().save(transaction);
            commit();
            close();
            return transaction;
            
        } catch (HibernateException e) {
            //throw new AdException("Could not create user " + username, e);
            System.out.println("Message"+e.getLocalizedMessage());
        }
		return null;
	}
}
