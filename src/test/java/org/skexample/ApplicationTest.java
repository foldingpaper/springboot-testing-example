package org.skexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    // Typically we will test just enough to see that
    // we can reach the endpoint and all the filters
    // are covered. The rest of the integration scenario
    // need not be covered here. And, we cannot mock
    // dependencies here. Best to test an endpoint that
    // does not depend on all the integration. It is best
    // tested via something like RestAssured and as a different
    // test job while this ApplicationTest is run as part of
    // the regular build.

    @Test
    public void canGetHelloWorld() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:8888/hello", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}