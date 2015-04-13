/**
 * 
 */
package com.test.gcd.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The model class for the database operations
 * 
 * @author Bindu
 *
 */
@Entity
public class GcdModel {
	
	@Id
	@GeneratedValue
	private Long id;
	private Integer i1;
	private Integer i2;
	
	public GcdModel(){}
	
	public GcdModel(int i1, int i2){
		this.i1 = i1;
		this.i2 = i2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getI1() {
		return i1;
	}

	public void setI1(Integer i1) {
		this.i1 = i1;
	}

	public Integer getI2() {
		return i2;
	}

	public void setI2(Integer i2) {
		this.i2 = i2;
	}

	/*public Integer getGcd() {
		return gcd;
	}

	public void setGcd(Integer gcd) {
		this.gcd = gcd;
	}*/
	
	

}
