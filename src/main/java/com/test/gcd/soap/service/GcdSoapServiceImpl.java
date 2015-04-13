/**
 * 
 */
package com.test.gcd.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.gcd.bean.NumberBean;
import com.test.gcd.dao.GcdDAO;
import com.test.gcd.dao.GcdModel;
import com.test.gcd.jms.consumer.GcdMessageConsumer;

/**
 * Service class that handles the SOAP requests
 * 
 * @author Bindu
 *
 */

@Service
public class GcdSoapServiceImpl implements GcdSoapService {

	@Autowired
	GcdDAO gcdDao;
	
	@Autowired
	GcdMessageConsumer consumer;
	
	private static final Logger logger = LogManager.getLogger(GcdSoapServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.test.gcd.soap.service.GcdSoapService#gcd()
	 */
	public int gcd() {
		
		logger.debug("Enter method: gcd");
		
		NumberBean numbers = consumer.getMessage();
		
		if(null != numbers)
			return (calculateGCD(numbers.getI1(), numbers.getI2()));
		else
			logger.debug("Message not received from the queue");
		
		logger.debug("Exit method: gcd");
		return 0;
	}

	
	/* (non-Javadoc)
	 * @see com.test.gcd.soap.service.GcdSoapService#gcdList()
	 */
	public List<Integer> gcdList() {
		
		logger.debug("Enter method: gcdList");
		List<Integer> gcdList = new ArrayList<Integer>();
		List<GcdModel>  modelList = this.gcdDao.getAllNumbers();
		for(GcdModel model: modelList){
			int gcd = calculateGCD(model.getI1(), model.getI2());
			gcdList.add(gcd);
		}
		logger.debug("Exit method: gcdList");
		return gcdList;
	}

	
	/* (non-Javadoc)
	 * @see com.test.gcd.soap.service.GcdSoapService#gcdSum()
	 */
	public int gcdSum() {
		logger.debug("Enter method: gcdSum");
		List<GcdModel>  modelList = this.gcdDao.getAllNumbers();
		int sum=0;
		for(GcdModel model: modelList){
			int gcd = calculateGCD(model.getI1(), model.getI2());
			sum+=gcd;
		}
		logger.debug("Exit method: gcdSum");
		return sum;
	}
	
	
	/**
	 * Calculates the GCD of two numbers
	 * 
	 * @param number1
	 * @param number2
	 * @return int the calculated GCD
	 */
	private int calculateGCD(int number1, int number2) {
        if(number2 == 0){
            return number1;
        }
        return calculateGCD(number2, number1%number2);
    }

}
