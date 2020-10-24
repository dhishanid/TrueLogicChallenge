/**
 * 
 */
package com.dhishani.SpringBootChallenge.dto.out;

/**
 * @author dhishani
 *
 */
public class PlayerResult {
	
	private String outcome;

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	public String toString() {
		return "PlayerResult [outcome=" + outcome + "]";
	}

}
