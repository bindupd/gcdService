/**
 * 
 */
package com.test.gcd.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.gcd.bean.NumberBean;
import com.test.gcd.rest.service.GcdRestService;

/**
 * The controller class that process the request form the client
 * @author Bindu
 *
 */

@Controller
public class GcdRestController {
	
		
	@Autowired
	GcdRestService gcdTestService;
	
	
	/**
	 * Adds the parameters to the JMS queue and database
	 * 
	 * @param i1
	 * @param i2
	 * @return the status
	 */
	@RequestMapping(value = "/gcd/push")
	@ResponseBody
	public String push(@RequestParam("i1") int i1, @RequestParam("i2") int i2) {
		return this.gcdTestService.push(i1, i2);
	}
	
	
	/**
	 * Retrieves a list of all the elements ever added to the queue from a database in the order added.  
	 * 
	 * @return numbers as JSON structure
	 */
	@RequestMapping(value = "/gcd/list", headers="Accept=application/json")
	public @ResponseBody Collection<NumberBean> list(){
		System.out.println("Inside getAllRobots");
		return this.gcdTestService.list();
	}
	
	
}
