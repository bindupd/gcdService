/**
 * 
 */
package com.test.gcd.dao;

import java.util.List;

/**
 * The DAO interface for database operations
 * 
 * @author Bindu
 *
 */
public interface GcdDAO {
	
	/**
	 * Save the numbers to the  database
	 * 
	 * @param gcdModel 
	 * @return the unique id of the saved values in database
	 */
	public Long addNumbers(GcdModel gcdModel);
	
	/**
	 * Retrieves the list of all the saved numbers in the database
	 * @return the list of all the saved numbers in the database
	 */
	public List<GcdModel> getAllNumbers();

}
