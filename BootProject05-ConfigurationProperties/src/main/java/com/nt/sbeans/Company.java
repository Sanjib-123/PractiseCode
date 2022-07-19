package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
@Setter //if did not place setter then nll will be displayed
@ToString
@ConfigurationProperties(prefix="org.nit")
public class Company {
	private String name;
	private String addrs;
	private Long pincode;
	private long contact;
	

}
