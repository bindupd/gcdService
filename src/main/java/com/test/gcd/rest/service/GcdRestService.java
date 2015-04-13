/**
 * 
 */
package com.test.gcd.rest.service;

import java.util.Collection;

import com.test.gcd.bean.NumberBean;

/**
 * The interface for Rest service
 * 
 * @author Bindu
 *
 */
public interface GcdRestService {

	/**
	 * This method add the numbers to the messgage queue and database
	 * @param i1
	 * @param i2
	 * @return String the status of te operation
	 */
	public String push(int i1, int i2);
	
	/**
	 * Retrieves all the numbers saved to the queue from database
	 * 
	 * @return numbers as a collection of NumberBean
	 */
	public Collection<NumberBean> list();
	
}
