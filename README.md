#### This is a java web application which creates Orders for a basic ecommerce flow. 

#### Tech Stack used 

1. Java 8
2. Spring Boot 2.2.2.RELEASE
3. Maven 
3. The database is simulated using HashMap 

#### Steps to run :

1. Import the project to IDE
2. Run mvn:install 
3. Run VedantuOrdersApplication.java as a Java Application

#### Sample request:

POST: http://localhost:8090/order/create
{
"orderItems":[{
"sku":"1234-5-7",
"quantity": 1
}],
"sessionId":"abc123"
}

Response:
{
    "message": {
        "message": "Order is successfully created",
        "status": "SUCCESS"
    }
}
