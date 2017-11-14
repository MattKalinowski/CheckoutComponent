# Checkout Component 3.0

The output of this project is a standalone, market checkout component with readable API that calculates the total price of a number of items

## Getting Started

To run the application, download Checkout-Component-3.0 project repository and open it in your IDE.
You can either run the app from IDE console level or you can build a project with Maven and open standalone JAR file located in "target" folder

### How to use it

Since the application itself doen't include user interface, all work takes place in the background.
You can test the API using special tool, like Postman.

**1. Add items to the basket**

```
POST http://localhost:8001/items
```

JSON body:

```
{
  "itemName": "D"
}
```

This operation can be performed any number of times, using one of four item names: A, B, C or D.
Each item has its own, unique price. 


**2. Show all items in basket**

```
GET http://localhost:8001/items
```

This way you can see all scanned items, each having ID number, name and price. 


**3. Calculate total price of items**

```
GET http://localhost:8001/items/price
```

The total price will be a worth of all items, minus discount. Discount applies only when you buy certain amount of items, each items has special discount. When you buy more than 4 of item "D", you'll get 4.5 discount for each acquired item "D".


**4. Delete unwanted item**

```
DELETE http://localhost:8001/items/4
```

Where number 4 is an item's ID.


**5. Empty your basket**

```
DELETE http://localhost:8001/items
```

This command will remove all items from the basket


## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](http://junit.org/junit5/) & [Mockito](http://site.mockito.org) - Testing

## Author

* **Mateusz Kalinowski** - [Linkedin Account](https://www.linkedin.com/in/mateusz-kalinowski-ba1544ba/)


