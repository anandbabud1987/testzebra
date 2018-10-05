/**
 * 
 */
package com.zebra.component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author anand
 *
 */
@Component
public class UtilityComponent {

	public static ResponseEntity<Object> buildResponse(Object object) {
		
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> buildErrorResponse(Object object) {
		
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}

	public static boolean isValidInputData(String data) {
		
		return (data!=null);
	}
}
