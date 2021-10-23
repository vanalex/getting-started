package org.acme.getting.started.greeting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class GreetingServiceTest {

    @Inject
    GreetingService greetingService;

    @Test
    void testGreeting(){
        Greeting result = greetingService.buildGreet();
        Assertions.assertEquals("hello!", result.getGreet());
    }
}
