/**
 * 
 */
package com.dhishani.SpringBootChallenge.exception;

/**
 * @author dimut
 *
 */
public class InvalidRequestException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String errorMessage) {
        super(errorMessage);
    }

}
