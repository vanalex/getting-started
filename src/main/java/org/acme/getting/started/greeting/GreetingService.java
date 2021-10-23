package org.acme.getting.started.greeting;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public Greeting buildGreet(){
        return new Greeting("hello!");
    }
}
