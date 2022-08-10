package com.nt.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MOBILE_PHONE_USER_TS_VER")
public class MobilePhoneUser {
	@Id
	private Long regNo;
	@NonNull
	private Long mobileNo;
	@NonNull
	private boolean prepaid; //gives isPrepaid() insted of get 
	@NonNull
	private String circle;
	@NonNull
	private String callerTune;
	
	
	@CreationTimestamp
	private Timestamp doj;
	@UpdateTimestamp
	private Timestamp lastUpdated;
	@Version
	private Integer updationCount;
	

}
