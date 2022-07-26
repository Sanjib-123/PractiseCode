package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DATA_JPA_ACTOR")
@Data
public class Actor {
	@Column(name="ACTOR_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //if no generator cfg default is auto
	private Integer aid;
	@Column(name="ACTOR_NAME",length=20)
	private String aname;
	@Column(name="CATAGORY",length=20)
	private String catagory;
	@Column(name="MOBILE_NUMBER")
	private Long mobileNo;

}
