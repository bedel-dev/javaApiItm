package com.itm.serviceapi.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;



@Data
@Entity
@Table(name = "users",
uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username", nullable = true)
	private String username;
	
	@Column(name = "contact", nullable = true)
	private String contact;
	
	@Column(name = "mail", nullable = true)
	private String mail;
	
	@Column(name = "nomprenom", nullable = true)
	private String nomprenom;
	
	@Column(name = "pass", nullable = true)
	private String pass;
	
	@Column(name = "role", nullable = true)
	private String role;
	
	@CreationTimestamp
	@Column(name="createdat", nullable = false, updatable = false, insertable = false)
	private Timestamp createdat;

	
	@UpdateTimestamp
	@Column(name = "updatedat", nullable = false, updatable = true, insertable = false)
	private Timestamp updatedat;
	
}
