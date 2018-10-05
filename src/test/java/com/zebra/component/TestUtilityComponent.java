/**
 * 
 */
package com.zebra.component;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author agl
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUtilityComponent {
	
	@Mock
	UtilityComponent utilityComponent;

	@Test
	public void testBuildResponse() {
		assertEquals("Testing", utilityComponent.buildResponse(new String("Testing")).getBody().toString());;
	}
	
	@Test
	public void testBuildErrorResponse() {
		assertEquals("Error", utilityComponent.buildErrorResponse(new String("Error")).getBody().toString());;
	}
	
	@Test
	public void testIsValidInputData() {
		assertEquals(false, utilityComponent.isValidInputData(null));
		assertEquals(true, utilityComponent.isValidInputData("ABC"));

	}

}
