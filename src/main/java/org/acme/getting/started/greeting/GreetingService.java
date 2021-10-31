package org.acme.getting.started.greeting;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingService {

    @Inject
    Instance<Action> actions;

    public Greeting buildGreet(){
        return new Greeting("hello!");
    }

    public void publishActions(){
        actions.forEach(Action::print);
    }
}
