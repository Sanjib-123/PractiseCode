package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {
	@Value("123456")
	private Integer hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.addrs}")
	private String hotelAddrs;
	@Value("${hotel.contactno}")
	private String mobileNo;
	
	@Value("${customer.name}")
	private String custName;
	@Value("#{menup.idlyPrice+menup.dosaPrice}")
	private Float billAmount;
	
	@Value("${os.name}")//os.name is fixed system properties
	private String osName;
	@Value("${user.name}")//user.name is fixed system properties
	private String macUser;
	
	@Value("${Path}")//path is fixed environment variable name
	private String pathData;

	//to String
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddrs=" + hotelAddrs + ", mobileNo="
				+ mobileNo + ", custName=" + custName + ", billAmount=" + billAmount + ", osName=" + osName
				+ ", macUser=" + macUser + ", pathData=" + pathData + "]";
	}
	
	
	
	
	
	

}

/*${<key>}
 * 
 * */
