/**
 * 
 */
package com.test.gcd.jms.consumer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.test.gcd.bean.NumberBean;

/**
 * This class consumes the JMS message
 * and save the numbers received in the message to the database.
 * Also it saves the message to a simple queue.
 * 
 * @author Bindu
 *
 */
@Component("consumer")
public class GcdMessageConsumer {
	
	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	private static final Logger logger = LogManager.getLogger(GcdMessageConsumer.class);
		
    /**
     * Retrieves the numbers from the head of the queue
     * and removes it from the queue
     * 
     * @return NumberBean retrieved from the queue
     * @return null if queue is empty
     */
    public NumberBean getMessage() {
    	logger.debug("Enter method: GcdMessageConsumer");
    	NumberBean numBean = null;
    	Object obj = jmsTemplate.receiveAndConvert();
    	if(obj instanceof NumberBean)
    		numBean = (NumberBean)obj;
    	
    	logger.debug("Exit method: GcdMessageConsumer");
    	return numBean;
        
    }

}
