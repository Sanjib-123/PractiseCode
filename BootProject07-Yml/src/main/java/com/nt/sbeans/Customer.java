package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("cust")
@ConfigurationProperties(prefix="cust.info")
@Data
public class Customer {
	private String custNo;
	private String custName;
	private String custAddrs;
	private Double billAmount;
	

}
