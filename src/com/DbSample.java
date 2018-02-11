package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;



@Stateless
@LocalBean
public class DbSample {
	private String username;
	private String password;
	private String serialnum;
	private String organization;

    public DbSample() {
    	System.out.format("Init DbSample\n");
    }
	
	public void setUsername(String uname){
		username = uname;
		System.out.format("\nusername = " + username);
	}
	
	public void setPassword(String pword){
		password = pword;
		System.out.format("\npassword = " + password);
	}
	
	public void setSerialnum(String ser){
		serialnum = ser;
		System.out.format("\npassword = " + serialnum);
	}
	
	
	public String getOrganization( )
	{
		if (serialnum != null) {
			if (organization == null) { 
				organization = "dummyOrg";
				System.out.println("This is where we run a database query to get the Organization based on Serial Number");
			}
		}
		return organization;
	}

}
