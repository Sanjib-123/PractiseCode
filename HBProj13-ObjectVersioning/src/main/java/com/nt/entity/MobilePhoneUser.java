package com.nt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
//@Entity
public class MobilePhoneUser {
	//@Id
	private Long regNo;
	@NonNull
	private Long mobileNo;
	@NonNull
	private boolean prepaid; //gives isPrepaid() insted of get 
	@NonNull
	private String circle;
	@NonNull
	private String callerTune;
	//@Version
	private Integer updateCount;
	

}
