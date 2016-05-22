package com.neu.myapplication.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.neu.myapplication.exception.AdException;
import com.neu.myapplication.pojo.Car;
import com.neu.myapplication.pojo.Message;
import com.neu.myapplication.pojo.User;

public class MessageDAO extends DAO{

	public MessageDAO(){
		
	}
	public Message saveMessage(User user) throws Exception {
		try {
            begin();
            System.out.println("inside message DAO");
            Query q = getSession().createQuery("from User where role = :role");
            q.setString("role", "admin");
            User user1 = (User) q.uniqueResult();          
            System.out.println("inside message DAO user"+user1.getFirstName());
            System.out.println("inside message DAO user"+user.getFirstName());
            Message message=new Message(user.getUsername(), user1.getUsername(), "sent");
            getSession().save(message);
            commit();     
            return message;
        } catch (HibernateException e) {
            //throw new AdException("Could not create user " + username, e);
            System.out.println("Message"+e.getLocalizedMessage());
        }
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getMessageList() throws AdException {
        try {
            begin();
            System.out.println("inside message");
            Query query = getSession().createQuery("from Message where status = :status");
            query.setString("status", "sent");
            System.out.println("after query message");
            List<Message> listMessage = query.list();
            System.out.println("list value"+listMessage);
            commit();
            return listMessage;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Messages", e);
        }
    }
	
	public int approveRequest(Message message) throws AdException{
		int result=0;
		try {
            begin();
            System.out.println("inside message");
            Query query = getSession().createQuery("update Message set status = :status1 where fromaddress = :fromaddress and status = :status");
            query.setString("fromaddress", message.getFromaddress());
            query.setString("status", "sent");
            query.setParameter("status1", "approved");
            result =  query.executeUpdate();
            commit();
		}
     catch (HibernateException e) {
        rollback();
        System.out.println("eee"+e.getMessage());
        throw new AdException("Could not update the message", e);
    }
		return result;
	}
	
	
	public String getStatus(User u) throws AdException{
		String status=null;
		try {
            begin();
            System.out.println("inside message");
            Query query = getSession().createQuery("from Message where fromaddress = :fromaddress");
            query.setString("fromaddress", u.getFirstName());
            Message m = (Message)query.uniqueResult();
            if (m != null){
            	status = m.getStatus();
		}
            commit();
		}
     catch (HibernateException e) {
        rollback();
        System.out.println("eee"+e.getMessage());
        throw new AdException("Could not update the message", e);
    }
		return status;
	}
	
	public int checkMessage(User u) throws AdException{
		int result = 0;
		try {
            begin();
            System.out.println("inside message");
            Query query = getSession().createQuery("from Message where fromaddress = :fromaddress");
            query.setString("fromaddress", u.getFirstName());
            Message m = (Message)query.uniqueResult();
            if(m != null){
            	result = 1;
            }
            else{
            	result = 2;
            }
            commit();
		}
     catch (HibernateException e) {
        rollback();
        System.out.println("eee"+e.getMessage());
        throw new AdException("Could not update the message", e);
    }
		return result;
	}
}
