package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ARTIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamicInsert(value=true)
@DynamicInsert(true)
@Proxy(lazy = false)
public class Artist implements Serializable {
	@Id
	@Column(name="AID")
	private Integer aid;
	@Column(name="NAME")
	private String name;
	@Column(name="Addrs")
	private String addrs;
	@Column(name="MobileNo")
	private Long mobileNo;
	@Column(name="CATAGORY")
	private String  catagory;

}
