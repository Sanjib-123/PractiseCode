package com.nt.entity;

import jakarta.persistence.Column;

public interface IArtist {
	
	public Integer getAid();
	public void setAid(Integer aid);
	public String getName();
	public void setName(String name);
    public String getAddrs() ;
	public void setAddrs(String addrs) ;
	public Long getMobileNo() ;
	public void setMobileNo(Long mobileNo) ;
	public String getCatagory() ;
	public void setCatagory(String catagory);
	
	

}
