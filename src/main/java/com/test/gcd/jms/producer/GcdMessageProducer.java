/**
 * 
 */
package com.test.gcd.jms.producer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.test.gcd.bean.NumberBean;



/**
 * The producer class for JMS messaging
 * 
 * @author Bindu
 *
 */
@Component("producer")
public class GcdMessageProducer {

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	private static final Logger logger = LogManager.getLogger(GcdMessageProducer.class);

	/**
	 * Convert the object to message and send it to the queue.
	 * 
	 * @param numberBean the object that is send in message
	 */
	public void convertAndSendMessage(NumberBean numberBean) {
		logger.debug("Enter method: convertAndSendMessage");
		jmsTemplate.convertAndSend(numberBean);
	}
	
		
}