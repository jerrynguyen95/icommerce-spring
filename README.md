# ICommerce
## _The ecommerce MVP website_


ICommerce is a ecommerce website use Springboot and ReactJs
ReactJS-powered HTML5 Markdown editor at this repository https://github.com/jerrynguyen95/icommerce-ui

## Features

- We have the Homepage, ProductDetail, Checkout pages
- Function: get all paging products, search products, add to cart

## Software principle, patterns & best practices
- **Principle**: SOLID, OOP, RESTFul api
- **Patterns**: Builder, Singleton, Proxy Pattern
- **Best practice**: 
    + Use Spring Projection to optimimize the query and restrict the sensitive data response.
    + Need to map the response data by DTO.
    + Set defaultTimeZone to Application when handle with datetime
    + Use the native query instead of common query in Spring JPA to optimize query time.
    + Use paging for get huge datas
    + Use redux to store data from Client and send to Server to reduce redundant requests

## Tech Stacks
We have some stacks such as:

- [ReactJS] - HTML enhanced for web apps!
```sh
        Code structure:
        src
        -- assets         
        -- common
        -- component
        -- redux
        -- service
        -- common
```
        

- [Java Springboot] - Create RESTfull api to communite with client.
Code struct Server - Springboot
git config --global alias.tree '! git ls-tree --full-name --name-only -t -r HEAD | sed -e "s/[^-][^\/]*\//   |/g" -e "s/|\([^ ]\)/|-- \1/"'
```sh
        Code structure:
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
```

- [Database] - MySQL

Libraries:
- [Client]: StyleComponent, Jest, esLint, Redux Toolkit, React Bootstrap ( https://react-bootstrap.github.io/ )
- [Server]: Swagger2, Mapstruct, Lombok, Maven, Sonar

## Installation and start local
1. Install MySQL and init the Database map with the `application.properties` and `entity`.
Then run the test file `test/../IcommerceprojectApplicationTests.java` to init data

2. Install the dependencies and devDependencies and start the server 

```sh
cd /icommerce-spring/
mvn spring-boot:run
```

Then access to the link http://localhost:8080/api/icommerce/swagger-ui/ to verify the API by Swagger2.
<img width="612" alt="image" src="https://user-images.githubusercontent.com/16476251/200270619-ff71f84d-6833-4de8-8fd1-b0273e9a7ddf.png">

3. Install node ver 16.x.x and the dependencies and devDependencies and start the client.
Link repository: https://github.com/jerrynguyen95/icommerce-ui

```sh
npm install
npm start
```

## Architecture
1. Database: 
<img width="561" alt="image" src="https://user-images.githubusercontent.com/16476251/200240474-3e87a371-27df-4068-98d1-4444e8dbb8f4.png">

2. Architecture design:
<img width="793" alt="image" src="https://user-images.githubusercontent.com/16476251/200282430-9d40005c-f343-4aea-bc9f-c06f558c7647.png">

3. Solution design:
<img width="879" alt="image" src="https://user-images.githubusercontent.com/16476251/200254815-ab3807a0-23ff-45cb-b02a-ccf6076d6a6f.png">



## License

MIT
