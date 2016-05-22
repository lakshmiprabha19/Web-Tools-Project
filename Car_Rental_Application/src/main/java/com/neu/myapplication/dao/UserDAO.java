package com.neu.myapplication.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.User;


public class UserDAO extends DAO{

	public UserDAO() {
    }
	
	public boolean create(String username, String password, String firstname, String lastname, Date dob) throws Exception {
		boolean flag = false;
        try {
            String role = "user";
            Date date = getDateOfBirth(dob);
            User user=new User(username,password, firstname, lastname, role, date);
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", user.getUsername());
            boolean f = (q.uniqueResult()!=null);
            if(f){
            	flag = false;
            }
            else{
            	getSession().save(user);
                commit();
                close();
                flag = true;
            }
            
        } catch (HibernateException e) {
            //throw new AdException("Could not create user " + username, e);
            System.out.println("Message"+e.getLocalizedMessage());
        }
		return flag;
        
    }
	
	public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUserId(), e);
        }
    }
	
	public User checkUser(User user) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", user.getUsername());
            User resultUser = (User) q.uniqueResult();
            commit();
            System.out.println("result user"+resultUser);
            if(resultUser != null){
	            if((resultUser.getUsername().equals(user.getUsername())) && (resultUser.getPassword().equals(user.getPassword()))){
	            	user = resultUser;
	            }
            }
            else{
            	user = null;
            }
            return user;
		
		} catch(HibernateException e){
			rollback();
			throw new AdException("User Not authenticated");
		}
	}
	
	public Date getDateOfBirth(Date dob){
		SimpleDateFormat stringFormat = new SimpleDateFormat("yyyy-MM-dd");
	    DateFormat requiredFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date=null;

	    String parsed = "";
	    if( dob != null ) {
	    	parsed = requiredFormat.format(dob);
	    }

	    System.out.println(parsed);
	    try {
			date = stringFormat.parse(parsed);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return date;
	}
}
