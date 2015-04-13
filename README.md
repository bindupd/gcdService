# gcdService
Spring web app with Rest and SOAP web service, JMS(ActiveMQ), JPA, Hibernate and HSQLDB 

This project exposes two rest APIs and three SOAP APIs

1. REST APIs
	a) public String push(int i1, intI2) - push the integers to JMS queue as message and saves it to database
	b) public List<Integer> list() - displays the list of all saved numbers in JSON format

2. SOAP APIs
	a) public int gcd() - get the message from the JMS queue and calulates the GCD of the numbers.
	b)public List<Integer> gcdList() - calcualtes the GCD of all numbers saved to database and return as a list
	c)public int gcdSum() - returns the sum of all calculated GCD from database

Technology Used

This is a Spring web application. It uses ActiveMQ as JMS provider, JPA to connect to database that use Hibernate as ORM, HSQLDB for database and Maven as build tool.

When deployed locally, the REST APIs can be accessed as follows

http://localhost:8080/gcdService/rest/gcd/push?i1=45&i2=15
http://localhost:8080/gcdService/rest/gcd/list

The WSDL for SOAP is 
http://localhost:8080/gcdService/ws/GcdSoapService.wsdl

