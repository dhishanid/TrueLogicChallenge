/**
 * 
 */
package com.dhishani.SpringBootChallenge.dto.out;

import java.util.List;

/**
 * @author dimut
 *
 */
public class PlayerResponse {
	
	private List<PlayerResult> results;
	private String status;
	private String errorMsg;

	public List<PlayerResult> getResults() {
		return results;
	}

	public void setResults(List<PlayerResult> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
