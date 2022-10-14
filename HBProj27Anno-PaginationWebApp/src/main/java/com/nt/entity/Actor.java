package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Actor implements Serializable {
	
	@Id
	private Integer actorId;
	private String actorName;
	private String actorAddrs;
	private Long mobileNo;

}
