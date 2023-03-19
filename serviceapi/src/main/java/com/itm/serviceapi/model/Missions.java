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
@Table(name = "missions")
public class Missions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "iduser", nullable = true)
	private String iduser;
	
	@Column(name = "information", nullable = true)
	private String information;
	
	@Column(name = "motif", nullable = true)
	private String motif;
	
	@Column(name = "state", nullable = true)
	private String state;
	
	@Column(name = "datefinmission", nullable = true)
	private String datefinmission;
	
	@CreationTimestamp
	@Column(name="datedebutmission", nullable = false, updatable = false, insertable = false)
	private Timestamp datedebutmission;

	@UpdateTimestamp
	@Column(name = "updatedat", nullable = false, updatable = true, insertable = false)
	private Timestamp updatedat;
}
