# Integration testing example
### Using Jetty, Selenium and JUnit.

This projects shows how you could do integration testing on a modern Web application. It features several techiniques:

* How to seperate fast unit tests from slow ones.
* How to start Jetty from JUnit and test against a real web server using Selenium.
* Using multi browser testing with JUnit's [@Parameterized](http://junit.sourceforge.net/javadoc/org/junit/runners/Parameterized.html) feature.

## Dependencies
This project depends on having Selenium server runing on localhost. This is fairly easy to achieve. Just [download the Selenium server](http://seleniumhq.org/download/) jar and the appropiate drivers for the browsers you want to test on. You can use [this gist](https://gist.github.com/4120566) as a start stop script for selenium. 

## Running
You can start the project from Eclipse using the main method in `com.alexnederlof.inttesting.MyWebServer.java`.

## Testing

You can run the dummy fast tests on any machine using
		
		mvn test
		
If you have selenium running on local host with the Chrome and Firefox drivers installed, you can run the integration tests using

		mvn test -P integrationtests

The techniques are explained in detail in two blogposts concerning [splitting op JUnit tests](http://alex.nederlof.com/separating-the-fast-from-the-slow-junit-tests) and [using Selenium, JUnit and Jetty for integration testing](http://alex.nederlof.com).