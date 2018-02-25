package com;



import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class CredentialsBean {
	private String username;
	private String password;

    public CredentialsBean() {
    	System.out.format("Init credentialsBean\n");
    }
	
	public void setUsername(String dummy){
		username = "werner";
		System.out.format("\nusername = " + username);
	}
	
	public void setPassword(String dummy){
		password = "bea123";
		System.out.format("\npassword = " + password);
	}
	
    public String getUsername(){
    //	System.out.format(Local.class.getEnclosingMethod().getName());
        return username;
    }
    
    public String getPassword(){
    //	System.out.format(Local.class.getEnclosingMethod().getName());
        return password;
    }
    
}
