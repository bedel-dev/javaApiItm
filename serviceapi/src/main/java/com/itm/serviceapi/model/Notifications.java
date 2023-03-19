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
@Table(name = "notifications")
public class Notifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "idmission", nullable = true)
	private String idmission;
	
	@Column(name = "iduser", nullable = true)
	private String iduser;
	
	@Column(name = "message", nullable = true)
	private String message;
	
	@Column(name = "state", nullable = true)
	private String state;
	
	
	@CreationTimestamp
	@Column(name="createdat", nullable = false, updatable = false, insertable = false)
	private Timestamp createdat;

	@UpdateTimestamp
	@Column(name = "updatedat", nullable = false, updatable = true, insertable = false)
	private Timestamp updatedat;
}
