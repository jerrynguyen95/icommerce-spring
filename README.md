# ICommerce
## _The ecommerce MVP website_


ICommerce is a ecommerce website use Springboot and ReactJs
ReactJS-powered HTML5 Markdown editor at this repo https://github.com/jerrynguyen95/icommerce-ui

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

## Tech
We have some stacks such as:

- [ReactJS] - HTML enhanced for web apps!
Code structure:
// TODO

- [Java Springboot] - Create RESTfull api to communite with client.
- [Database] - MySQL

Libraries:
- [Client]: React Bootstrap ( https://react-bootstrap.github.io/ )
- [Server]: Swagger2, Mapstruct, Lombok, Maven.

## Installation and start local
1. Install MySQL and init the Database map with the `application.properties` and `entity`.
Then run the test file `test/../IcommerceprojectApplicationTests.java` to init data

2. Install the dependencies and devDependencies and start the server 

```sh
cd /icommerce-spring/
mvn spring-boot:run
```

Then access to the link http://localhost:8080/api/icommerce/swagger-ui/ to verify the API by Swagger2.

3. Install node ver 16.x.x and the dependencies and devDependencies and start the client.

```sh
npm install
npm start
```

## License

MIT
