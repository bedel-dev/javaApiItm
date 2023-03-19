package com.itm.serviceapi.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class Emails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content", nullable = true)
	private String content;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "nomprenom", nullable = true)
	private String nomprenom;
	
	@Column(name = "sujet", nullable = true)
	private String sujet;
	
	@CreationTimestamp
	@Column(name="createdat", nullable = false, updatable = false, insertable = false)
	private Timestamp createdat;

	@UpdateTimestamp
	@Column(name = "updatedat", nullable = false, updatable = true, insertable = false)
	private Timestamp updatedat;
}
