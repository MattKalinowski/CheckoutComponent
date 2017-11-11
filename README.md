# Checkout Component 3.0

The output of this project is a standalone, market checkout component with readable API that calculates the total price of a number of items

## Getting Started

To run the application, download Checkout-Component-3.0 project repository and open it in your IDE.
You can either run the app from IDE console level or you can build a project and open standalone JAR file located in "target" folder

### How to use it

Since the application itself doen't include user interface, all work takes place in the background.
To use created API you first need to set up a corresponding [API consumer](https://github.com/MatthewHayworth/CheckoutConsumer/archive/master.zip) I created for testing purposes. 
This API consumer is a simple console app, after it running you should see classic Spring ASCII art and couple of log messages bellow it, including:

```
Choose item (A, B, C, D):
```

Input should be a single letter from A to D (case insensitive). Each letter represents a seperate item, each item has its own uniqe price and discout type.
After pressing ENTER, you'll see another input request:

```
Choose quantity: 
```

This time, you need to put a number of items you're willing to scan. Items numer is directly connected to discount calculating mechanism.

After choosing item A in quantity of 5, you see something like that:
```
Current value of items: 75.0 cents

Type ADD to add more items or EXIT to finish
```

Now you can either type "add" to add scan another item whose price will be included in a summary or type "exit" to stop the program.

NOTE 1: API consumer works only in collaboration with Checkout Component 3.0(API) process in the background. If you encounter any issuses, make sure that Checkout Component process is running in the background.

NOTE 2: In case of running standalone JAR file, you won't see any apparent visual effect, but the proces of JVM marked as "java" will be added to your computer activity. You can reach it and kill it using process activity monitor.



## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](http://junit.org/junit5/) & [Mockito](http://site.mockito.org) - Testing

## Author

* **Mateusz Kalinowski** - [Linkedin Account](https://www.linkedin.com/in/mateusz-kalinowski-ba1544ba/)


