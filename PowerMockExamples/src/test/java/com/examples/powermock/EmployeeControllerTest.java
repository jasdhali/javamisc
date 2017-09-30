package com.examples.powermock;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testng.annotations.Test;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TerminatedEmployee.class)
public class EmployeeControllerTest {
	
	@Test(expectedExceptions = { UnsupportedOperationException.class })
	public void shouldGetCountOfEmployees() {
		EmployeeController employeeController = new EmployeeController(new EmployeeService());
		assertEquals(10, employeeController.getProjectedEmployeeCount());
	}

	public void firstPowerMockTest() {
		// Creating a mock using the PowerMockito.mock
		// method for the EmployeeService class.
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);
		PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);
		EmployeeController employeeController = new EmployeeController(mock);
		assertEquals(16, employeeController.getProjectedEmployeeCount());
		
	}

	@Test
	public void verifyMethodInvokationTest() 
	{
	EmployeeService mock =PowerMockito.mock(EmployeeService.class);
	EmployeeController employeeController = new EmployeeController(mock);
	final TerminatedEmployee exEmployee = PowerMockito.mock(TerminatedEmployee.class);
	
	Employee employee = new Employee();
	employeeController.saveEmployee(employee);
	
	//Verifying that controller did call the
	//saveEmployee() method on the mocked service instance.
	Mockito.verify(mock).saveEmployee(employee);
	}
}
