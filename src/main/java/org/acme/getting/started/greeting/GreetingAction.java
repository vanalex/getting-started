package org.acme.getting.started.greeting;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
public class GreetingAction implements Action{
    @Override
    public void print() {
      log.info("Hello!");
    }
}
