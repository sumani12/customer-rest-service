# customer-rest-service
This is a sample rest web service to create and get customer details. 

The service can be launched by starting the app as a spring boot application and test the customer resource via Swagger UI.

http://localhost:8080/swagger-ui.html#/customer-resource


* Retrieve all customers   - GET /customers

   GET http://localhost:8080/customers


* To retrieve a specific Customer based on id

   GET http://localhost:8080/customer/1


* Create a Customer - POST/customers

   POST http://localhost:8080/customers

* Making a request to non existing source returns a Customized Exception Response

    GET http://localhost:8080/customers/1000 

* Used HATEOS to return a hyperlink in the response

  GET http://localhost:8080/customer/1 with HATEOAS

* Documented  restful services using Swagger

* Filtering is a concept in Restful Web Service to filter out certain attributes in the bean for example NPI/SPI data.

     http://localhost:8080/filtering

* Versioning is to provide different versions of service to meet Client requirements.

  http://localhost:8080/v1/employee

  http://localhost:8080/v2/employee

