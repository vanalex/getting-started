package org.acme.getting.started.cdi;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BarNamingService implements NamingService{

  @Override
  public String name() {
    return "bar";
  }
}
