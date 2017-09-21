# myBBCcodingChallengePushBulletService
This application has been created using Eclipse Oxygen by using Spring Boot

1- Clone the repository to your local folder
2- Add to your eclipse as already existing project

to run the application from eclipse:
 -right click on the project root folder and Run As Spring Boot App

to run tests from eclipse:
 -right click on the project root folder and Run As Junit Test

to run the application from command line:
 on the project folder run 
   mvn spring-boot:run

to run tests from command line:
 on the project folder run 
   mvn test
   
to call the api please use postman (a plugin to google crome)

to create a user set the url to http://localhost:8080/user/ and set the header "Content-Type" to "application/json" 
choose POST send method and the body should have the following json format:
{"userName":"a name", "accessToken":"xxxxxyyyyyzzzz"}

to retrieve all registered users set the url to http://localhost:8080/user/ and choose GET send method

to push a message to A registered user set the url to http://localhost:8080/push/ and set the header "Content-Type" to "application/json"
choose POST send method and the body should have the following format:
{"userName":"a name", "title":"a title" , "type":"note" , "body":"a body"}
