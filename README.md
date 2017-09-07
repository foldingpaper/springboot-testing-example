Unit and Integration Testing sample
===================================

An app that serves Spring Boot REST APIs with simple unit tests
using Mockito, MockMVC, and other Spring Boot tools. This is intended
to help as a simple sample setup for testing for a Spring Boot based
ReST API service.

Controller Test
---------------

For Controller Tests, we use mockMVC. This way we can test invocation
and the response. We can continue to mock the controller dependencies
since all we are interested in is the controller behavior and the
ReSTFul interface.

Application Test
----------------
In the ApplicationTest, we test with TestRestTemplate.

We setup as a proper Spring Boot App to make sure we cover the
config properties, autowiring, and all the Spring goodies.
Basically, this starts to feel like an Integration Test. This
will also cause the filters to be included in the test which
does not happen when testing with mockMVC. So, this is integration
test within the app with the external dependencies like DB
(via services) still mocked out.

Running
-------

$ mvn clean package

Or run in your IDE after importing the maven project.