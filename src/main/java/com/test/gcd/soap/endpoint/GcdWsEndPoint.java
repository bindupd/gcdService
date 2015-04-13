/**
 * 
 */
package com.test.gcd.soap.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.test.gcd.soap.service.GcdSoapService;
import com.test.gcd.soap.webservice.GcdListResponse;
import com.test.gcd.soap.webservice.GcdResponse;
import com.test.gcd.soap.webservice.GcdSumResponse;

/**
 * The EndPoint class for the SOAP service
 * 
 * @author Bindu
 *
 */

@Endpoint
public class GcdWsEndPoint {
	
	private static final String TARGET_NAMESPACE = "http://com/test/gcd/soap/WebService";
	
	@Autowired
	private GcdSoapService gcdSoapService;

	
	/**
	 * Handles the request for getting gcd from the queue
	 * @return the gcd.
	 * @return 0 if queue is empty
	 */
	@PayloadRoot(localPart="gcdRequest", namespace=TARGET_NAMESPACE)
	public @ResponsePayload GcdResponse gcd(){
		int gcd = gcdSoapService.gcd();
		GcdResponse response = new GcdResponse();
		response.setGcd(gcd);
		return response;
	}
	
	
	/**
	 * Returns a list of all the computed greatest common divisors from a database. 
	 * @return List of int - the gcd
	 */
	@PayloadRoot(localPart="gcdListRequest", namespace=TARGET_NAMESPACE)
	public @ResponsePayload GcdListResponse gcdList(){
		List<Integer> gcdList = this.gcdSoapService.gcdList();
		GcdListResponse response = new GcdListResponse();
		response.getGcd().addAll(gcdList);
		return response;
	}
	
	
	/**
	 * Returns the sum of all computed greatest common divisors from a database.
	 * 
	 * @return int - sum of GCD
	 */
	@PayloadRoot(localPart="gcdSumRequest", namespace=TARGET_NAMESPACE)
	public @ResponsePayload GcdSumResponse gcdSum(){
		int gcdSum = this.gcdSoapService.gcdSum();
		GcdSumResponse response = new GcdSumResponse();
		response.setGcd(gcdSum);
		return response;
	}
	
	
	public void setGcdSoapService(GcdSoapService gcdSoapService){
		this.gcdSoapService = gcdSoapService;
	}
}
