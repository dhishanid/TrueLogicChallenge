/**
 * 
 */
package com.dhishani.SpringBootChallenge.service;

import org.springframework.stereotype.Service;

import com.dhishani.SpringBootChallenge.dto.in.PlayerRequest;
import com.dhishani.SpringBootChallenge.dto.out.PlayerResponse;
import com.dhishani.SpringBootChallenge.exception.InvalidRequestException;

/**
 * @author dhishani
 *
 */
@Service
public interface RecordPlayerService {
	
	public PlayerResponse getPlayerResponse(PlayerRequest playerRequest) throws InvalidRequestException;

}
