# RESTfulCRUDDev3l
RESTful Web Service using Jersey - CRUD resource implemented (template)

	- Uses annotations for configuration
		- No need for a web.xml
	- REST Client 
		- Jersey
		- com.sun.jersey : v1.19
	- Dependency Injection 
		- Google Guice
		- com.google.inject : guice : v3.0
	- Commons Lang
		- org.apache.commons : commons-lang3 : v3.3.2
	- Logging
		- Log4j
		- org.apache.logging.log4j : v2.1

#Usage Instructions to Pull down and use template project from GitHub
1. From command line retrieve project from GitHub
	- git clone https://github.com/DEV3L/RESTfulCRUDDev3l.git

2. Run maven package from inside the created directory
	- mvn clean package

3. RESTfulCRUDDev3l.war can be deployed to container of choice
	- http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user
		- My personal OpenShift server I deploy projects too
	- CURL Commands to exercise CRUD operations
		- GET
			- curl http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user
		- GET
			- curl http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user/{id}
		- POST
			- curl -X POST http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user -H "Content-Type: application/json" -d '{"userName":"user_name","email":"email@email.com","status":"AC","password":"password"}'
		- PUT
			- curl -X PUT http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user/{id} -H "Content-Type: application/json" -d '{"id":{id},"userName":"user_name","email":"email@email.com","status":"AC","password":"password"}'
		- DELETE
			- curl -X DELETE http://services-dev3l.rhcloud.com/RESTfulCRUDDev3l/user/{id}

4. Use Maven to resolve the dependencies and create eclipse dynamic web project and class/project files
	- mvn eclipse:eclipse -Dwtpversion=2.0

5. Import the project into Eclipse as an existing project