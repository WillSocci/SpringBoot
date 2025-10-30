# SpringBoot# Lab 5
In order to run my code you must use these exact commands:

in order to just run the mvn you do this:
./mvnw clean package
./mvnw spring-boot:run

then in another terminal run:
curl -X POST http://localhost:8080/password-quality -d "StrongPass1!"
curl -X POST http://localhost:8080/email-address-valid -d "test@example.com"


Then in order to run tests you just need to run:
from workspaces:
cd SpringBoot/springboot/demo/demo

./mvnw test
