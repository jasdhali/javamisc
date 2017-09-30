package com.examples.powermock;
public class AnotherService {
    private FinalService service;
 
    public AnotherService(FinalService service) {
 
        this.service = service;
    }
 
    public String invokeFinalService() {
        return service.doSomething();
    }
}