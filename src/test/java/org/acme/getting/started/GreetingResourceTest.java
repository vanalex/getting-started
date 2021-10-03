package org.acme.getting.started;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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