package org.acme.getting.started.greeting;

import io.quarkus.test.junit.NativeImageTest;
import org.acme.getting.started.greeting.GreetingResourceTest;

@NativeImageTest
public class NativeGreetingResourceIT extends GreetingResourceTest {

    // Execute the same tests but in native mode.
}