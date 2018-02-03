package com;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EboxDetailsBean
 */
@Stateless
@LocalBean
public class EboxDetailsBean {

	private String serialNum;
	private String depot;
	
    public EboxDetailsBean() {
    	System.out.format("Init EboxDetailsBean");
    }
    
    public String getSerialNum(){
    	System.out.format("Get serial  : %s%n", this.serialNum);
        return serialNum;
    }
    
    public void setSerialNum(String instr){
        this.serialNum = instr;
        System.out.format("Set serial  : %s%n", this.serialNum);
     }
    
    public String getDepot() {
        return depot;
    }
    
    public void setDepot(String instr) {
        this.depot = instr;
     }
    
}
