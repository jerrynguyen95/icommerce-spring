# icommerce-spring

#1. A brief explanation for the software development principles, patterns & practices being applied
- Use the Springboot framework to create an MVP ecommerce project
- Use swagger 2 to verify the API
- Use Spring Projection to handle restrict data response and optimize query
- Use Mapstruct lib to mapping Entity to DTO response automatically

#2. A brief explanation for the code folder structure and the key Java libraries and frameworks being used
- Code struct Server - Springboot
src
-- main
---- java
----- src/main/java/com/icommerce/icommerceproject
------- config
------- constant
------- controller
------- dto
---------- model
---------- projection
---------- request
---------- response
------------  mapper
------- entity
------- repository
------- service
---------- impl
---- resource
-- test

- Code struct Client - ReactJS
src
-- assets
-- common
-- component
-- redux
-- service
-- common

#3. All the required steps in order to get the application run on a local computer
Server: 
- Go to /icommerce-spring folder and run `mvn clean install` to download libs
- Go to main class Java `IcommerceprojectApplication` and run the `main` function
Client:
- Require: Node version 16.x.x, 
- Run command `npm install` to install libs from package.json
- Go to /icommerce-ui folder and run `npm start`

#4. Full CURL commands to verify the APIs (include full request endpoint, HTTP Headers and
request payload if any)
- After start the Server at the port 8080
- Go to link http://localhost:8080/api/icommerce/swagger-ui/ to see all API of project and verify

