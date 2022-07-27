package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="DATA_JPA_ACTOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Actor {
	@Column(name="ACTOR_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //if no generator cfg default is auto
	
	private Integer aid;
	@Column(name="ACTOR_NAME",length=20)
	@NonNull
	private String aname;
	@Column(name="CATAGORY",length=20)
	@NonNull
	private String catagory;
	@Column(name="MOBILE_NUMBER")
	@NonNull
	private Long mobileNo;

}
