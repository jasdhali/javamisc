package com.examples.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
/* Preparing the final FinalService class so that we could mock it*/
@PrepareForTest(FinalService.class)
public class AnotherServiceTest {
 
    //I know its a very bad name for the test case but,
    //could not think of any other name while I was writing this post
    @Test
    public void shouldReturnResultOfDoSomething() {
      //Creating the mock of FinalService class 
      //using the standard mock method of PowerMockito.
      final FinalService finalService = PowerMockito.mock(FinalService.class);
         
      //Stubbing the doSomething method on mocked FinalService object
      //Stub returns "Hello World"
      when(finalService.doSomething()).thenReturn("Hello World");
 
      //Asserting that the return value of invokeFinalService
      //is actually "Hello World"
      assertEquals("Hello World", 
          new AnotherService(finalService).invokeFinalService());
    }
    @Test
    public void shouldInvokeDoSomethingMethod() {
      //Same as above code, creating the mock of FinalService class.
      final FinalService finalService = PowerMockito.mock(FinalService.class);
 
      //Performing the business operation
      new AnotherService(finalService).invokeFinalService();
 
      //Verifying that the doSomething method was invoked 
      //on the mocked FinalService object
      verify(finalService).doSomething();
    }
}