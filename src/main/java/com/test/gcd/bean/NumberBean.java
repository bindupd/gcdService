package com.test.gcd.bean;

import java.io.Serializable;

/**
 * This bean class acts as a value object
 * 
 * @author Bindu
 *
 */
public class NumberBean implements Serializable {
	
	private static final long serialVersionUID = 2990163663123741291L;
	
	private int i1;
	private int i2;
	
	public NumberBean(int i1, int i2){
		this.setI1(i1);
		this.setI2(i2);
	}
	
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public int getI2() {
		return i2;
	}
	public void setI2(int i2) {
		this.i2 = i2;
	}

}
