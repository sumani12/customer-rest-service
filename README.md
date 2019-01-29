# customer-rest-service
This is a rest services to create and get customer details based on a id.

launch the service by starting the app as a spring boot application and test the customer resource via Swagger UI.

http://localhost:8080/swagger-ui.html#/customer-resource


* Retrieve all customers   - GET /customers

   GET http://localhost:8080/customers


* To retrieve a specific Customer based on id

   GET http://localhost:8080/customer/1


* Create a Customer - POST/customers

   POST http://localhost:8080/customers

* Get request to non existing source and the response shows a Customized Exception Response

    GET http://localhost:8080/customers/1000

* Enhanced POST method to return correct HTTP Status Code and Location

* When a GET request is called on a specific Customer the data of that customer is retrieved. HATEOS is a concept  which returns a link to retrieve all customers along with a specific customer details

  GET http://localhost:8080/customer/1 with HATEOAS

* Documented  restful services using Swagger

* Spring boot Actuator provides monitoring facilities around the services. Spring Boot Actuator API are in the HAL format. The HAL bowser looks at the API’s identifies the links so that we can easily browse  through Api with the links provided. The HaL browser makes it easy to consume HAL services which are being exposed by Spring Boot Actuator

     http://localhost:8080/browser/index.html#/

* Filtering is a concept in Restful Web Service to filter out certain attributes in the bean that is confidential and sensitive information

     http://localhost:8080/filtering

* Versioning is to provide different versions of services to different clients to meet the Client requirements

  http://localhost:8080/v1/employee

  http://localhost:8080/v2/employee

