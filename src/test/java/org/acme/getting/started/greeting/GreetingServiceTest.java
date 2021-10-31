package org.acme.getting.started.greeting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Inject
    Server server;

    @Test
    void testGreeting(){
        Greeting result = greetingService.buildGreet();
        Assertions.assertEquals("hello!", result.getGreet());
    }

    @Test
    void testConfigServerSettings(){
        String host = server.host();
        Assertions.assertEquals("localhost", host);

        int port = server.port();
        Assertions.assertEquals(8080, port);

        boolean enabled = server.log().enabled();
        Assertions.assertTrue( enabled);

    }

    @Test
    void testActions(){
        greetingService.publishActions();
    }
}
