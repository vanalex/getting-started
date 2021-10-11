package org.acme.getting.started;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Printer {

    public String print(){
        return "hallo!";
    }

}
