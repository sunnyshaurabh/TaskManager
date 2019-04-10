package com.taskmanager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;

import com.taskmanager.exception.InvalidPrioritiesException;
import com.taskmanager.pojo.UserRequest;
/***
 * 
 * @author sunny
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TaskHandlerImplTest {

	private TaskHandlerImpl taskHandlerImpl;
	
	@Mock
	private UserRequest userRequest;

	@Before
	public void setup() {
		taskHandlerImpl = new TaskHandlerImpl();
	}

	@Test
	public void shouldReturnValidPriorities() throws Exception {
		when(userRequest.getPriority()).thenReturn("CRITICAL");
		String result = Whitebox.invokeMethod(taskHandlerImpl, "getPriority", userRequest);
		assertEquals(result, "CRITICAL");
		when(userRequest.getPriority()).thenReturn("HIGH");
		result = Whitebox.invokeMethod(taskHandlerImpl, "getPriority", userRequest);
		assertEquals(result, "HIGH");
		when(userRequest.getPriority()).thenReturn("MEDIUM");
		result = Whitebox.invokeMethod(taskHandlerImpl, "getPriority", userRequest);
		assertEquals(result, "MEDIUM");
	}
	
	/***
	 * should throw an exception for any invalid inputs
	 * @throws Exception 
	 */
	@Test
	public void shouldthrowException() throws Exception {
		when(userRequest.getPriority()).thenReturn("wrongInput");
		try {
			String result = Whitebox.invokeMethod(taskHandlerImpl, "getPriority", userRequest);
			assertEquals(result, "MEDIUM");
			  } catch (InvalidPrioritiesException expected) {
			    assertEquals("the priority entered was out of scope please enter a valid priority", expected.getMessage());
			  }
	}
} 
