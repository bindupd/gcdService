/**
 * 
 */
package com.test.gcd.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.gcd.bean.NumberBean;
import com.test.gcd.dao.GcdDAO;
import com.test.gcd.dao.GcdModel;
import com.test.gcd.jms.producer.GcdMessageProducer;

/**
 * @author Bindu
 *
 */
@Service
public class GcdRestServiceImpl implements GcdRestService{
	
	@Autowired
	private GcdMessageProducer producer;
	
	@Autowired
	GcdDAO gcdDao;
	
	 private static final Logger logger = LogManager.getLogger(GcdRestServiceImpl.class);

	@Override
	public String push(int i1, int i2) {
		logger.debug("Enter method: push");
		String message = "Numbers added successfully...";
		try{
		producer.convertAndSendMessage(new NumberBean(i1, i2));
		gcdDao.addNumbers(new GcdModel(i1, i2));
		}catch(Exception e){
			message = "Adding numbers failed";
		}
		
		logger.debug("Exit method: push");
		return message;
	}

	@Override
	public Collection<NumberBean> list() {
		logger.debug("Enter method: list");
		Collection<NumberBean> numberList = new ArrayList<NumberBean>();
		List<GcdModel>  modelList = this.gcdDao.getAllNumbers();
		NumberBean numBean;
		for(GcdModel model: modelList){
			numBean = new NumberBean(model.getI1(), model.getI2());
			numberList.add(numBean);
		}
		
		logger.debug("Exit method: list");
		
		return numberList;
	}
	
}
