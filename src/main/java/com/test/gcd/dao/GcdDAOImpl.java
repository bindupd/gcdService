/**
 * 
 */
package com.test.gcd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The implementation class for database operations
 * 
 * @author Bindu
 *
 */
@Repository
@Transactional
public class GcdDAOImpl implements GcdDAO {


	@PersistenceContext
    private EntityManager em;
	
	/**
	 * Save the numbers to the  database
	 * 
	 * @param gcdModel 
	 * @return the unique id of the saved values in database
	 */
	public Long addNumbers(GcdModel gcdModel) {
		em.persist(gcdModel);
		System.out.println("id="+gcdModel.getId());
		return gcdModel.getId();
	}

	/**
	 * Retrieves the list of all the saved numbers in the database
	 * @return the list of all the saved numbers in the database
	 */
	public List<GcdModel> getAllNumbers() {
		return em.createQuery("SELECT g FROM GcdModel g", GcdModel.class).getResultList();
	}

}
