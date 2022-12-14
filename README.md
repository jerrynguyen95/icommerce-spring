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
<img width="784" alt="image" src="https://user-images.githubusercontent.com/16476251/200283729-a2b8d4bd-2196-45fb-84be-932dea6b4441.png">

3. Solution design:
<img width="879" alt="image" src="https://user-images.githubusercontent.com/16476251/200254815-ab3807a0-23ff-45cb-b02a-ccf6076d6a6f.png">

## Application
### 1. Homepage
![ICommerce Application](https://user-images.githubusercontent.com/16476251/201536804-e04035fe-3fbd-4c6c-a236-bd34dc5abf1f.png)

### 2. Cart
![ICommerce_cart](https://user-images.githubusercontent.com/16476251/201536800-71b5b499-3460-4fa9-af65-5ac75ca2b786.png)

### 3. Checkout
![ICommerce_Checkout](https://user-images.githubusercontent.com/16476251/201536799-646818c2-cbc9-44f7-8e17-d7e880043e0a.png)

### 4. Product Search
![ICommerce_product_search](https://user-images.githubusercontent.com/16476251/201536783-b4288236-ca66-4cab-90fa-28d405bc984a.png)

### 5. Product Detail
![Icommerce_product_detail](https://user-images.githubusercontent.com/16476251/201536793-0d738cef-624d-41f1-86f4-776af86a2053.png)





## License

MIT
