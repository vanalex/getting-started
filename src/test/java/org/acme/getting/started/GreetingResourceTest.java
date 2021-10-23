package org.acme.getting.started;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.getting.started.greeting.Greeting;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testHelloEndpoint() throws JsonProcessingException {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is(mapper.writeValueAsString(new Greeting("Hello Rest Easy!"))));
    }

}