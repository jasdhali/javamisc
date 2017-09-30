package com.examples.powermock;
//http://www.gitshah.com/2010/05/how-to-mock-final-methods-and-classes.html
public final class FinalService {
 
    public final String doSomething() {
        throw new RuntimeException("Something went wrong");
    }
}