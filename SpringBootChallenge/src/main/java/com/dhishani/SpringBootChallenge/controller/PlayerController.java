/**
 * 
 */
package com.dhishani.SpringBootChallenge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dhishani.SpringBootChallenge.dto.in.PlayerRequest;
import com.dhishani.SpringBootChallenge.dto.out.PlayerResponse;
import com.dhishani.SpringBootChallenge.exception.InvalidRequestException;
import com.dhishani.SpringBootChallenge.service.RecordPlayerService;

/**
 * @author dhishani
 *
 */

@RestController
@RequestMapping("/TrueLogic/REST")
public class PlayerController {
	
	private static Logger logger = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	RecordPlayerService  recordPlayerService;
	
	
	
	@RequestMapping(value="/recordPlayerEvents", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlayerResponse> recordPlayerEvents(@RequestBody PlayerRequest playerRequest, HttpServletRequest request, HttpServletResponse response) throws InvalidRequestException{
		
		PlayerResponse playerResponse=null;
		
		if(playerRequest!=null && request!=null){
			
			playerResponse=recordPlayerService.getPlayerResponse(playerRequest);
		}
		
		
		
		return new ResponseEntity<PlayerResponse>(playerResponse, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<PlayerResponse> handleInvalidRequest(HttpServletRequest request,InvalidRequestException ex ){
		logger.error("handleInvalidRequest: InvalidRequestException occured" ,ex);
		PlayerResponse playerResponse=new PlayerResponse();
		playerResponse.setStatus("406");
		playerResponse.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<PlayerResponse>(playerResponse, HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<PlayerResponse> handleException(HttpServletRequest request,Exception ex ){
		logger.error("handleInvalidRequest: Exception occured" ,ex);
		PlayerResponse playerResponse=new PlayerResponse();
		playerResponse.setStatus("500");
		playerResponse.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<PlayerResponse>(playerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
