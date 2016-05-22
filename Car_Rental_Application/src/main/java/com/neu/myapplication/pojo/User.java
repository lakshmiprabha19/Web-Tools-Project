package com.neu.myapplication.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue
	@Column(name= "userid", unique = true, nullable = false)
	private int userid;
	
	@Column(name="username", unique = true)
    private String username;
	
	@Column(name="password")
    private String password;
	
	@Column(name="firstname")
    private String firstName;
    
    @Column(name="lastname")
    private String lastName;
    
    @Column(name="role")
    private String role;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dob")
    private Date dob;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userid")
    private Set<Reservation> reservation = new HashSet<Reservation>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userid")
    private Set<Transaction> transaction = new HashSet<Transaction>();

	public User() {
    }
	
	public User(String username, String password, String firstname, String lastname, String role, Date dob) {
        this.username = username;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.role = role;
        this.dob = dob;
    }
    
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
