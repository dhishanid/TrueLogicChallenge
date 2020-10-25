/**
 * 
 */
package com.dhishani.SpringBootChallenge.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhishani.SpringBootChallenge.dto.in.Player;
import com.dhishani.SpringBootChallenge.dto.in.PlayerRequest;
import com.dhishani.SpringBootChallenge.dto.out.PlayerResponse;
import com.dhishani.SpringBootChallenge.dto.out.PlayerResult;
import com.dhishani.SpringBootChallenge.exception.InvalidRequestException;
import com.dhishani.SpringBootChallenge.repo.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
/**
 * @author dhishani
 *
 */
@Service("com.dhishani.SpringBootChallenge.service.RecordPlayerService")
public class RecordPlayerServiceImpl implements RecordPlayerService{
	
	private static Logger logger = LoggerFactory.getLogger(RecordPlayerServiceImpl.class);
	
	private static final String TYPE_EXPERT="expert";
	private static final String TYPE_NOVICE="novice";
	private static final String TYPE_OTHER="meh";
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	PlayerProducer playerProducer;
	
	public PlayerResponse getPlayerResponse(PlayerRequest playerRequest) throws InvalidRequestException{
	
		List<Player> playersList = playerRequest.getPlayers();
		
		PlayerResponse playerResponse=new PlayerResponse();

		List<PlayerResult> resultList = new ArrayList<PlayerResult>();

		if (playersList != null && !playersList.isEmpty()) {

			
			for (Player player : playersList) {

				String type = player.getType();
				String name=player.getName();

				if (TYPE_EXPERT.equalsIgnoreCase(type)) {
					
					com.dhishani.SpringBootChallenge.beans.Player repoPlayer=new com.dhishani.SpringBootChallenge.beans.Player();
					
					repoPlayer.setName(name);
					repoPlayer.setPlayerType(type);
					playerRepository.save(repoPlayer);//persist Player record in H2 DB
					logger.info("getPlayerResponse: Player [{}] was saved in DB" ,name); 

					String result = "player Sub zero stored in DB";
					PlayerResult playerResult = new PlayerResult();
					playerResult.setOutcome(result);
					resultList.add(playerResult);//add to Response
					
					

				} else if (TYPE_NOVICE.equalsIgnoreCase(type)) {
					
					String message=getJsonString(player);
					
					playerProducer.sendMessage(message);
					
					logger.info("getPlayerResponse: Player [{}] sent to Kafka topic with message [{}]" ,name,message);

					String result = "player Scorpion sent to Kafka topic";
					PlayerResult playerResult = new PlayerResult();
					playerResult.setOutcome(result);
					resultList.add(playerResult);
					
				} else if (TYPE_OTHER.equalsIgnoreCase(type)) {

					String result = "player Reptile did not fit";
					PlayerResult playerResult = new PlayerResult();
					playerResult.setOutcome(result);
					resultList.add(playerResult);

				}

			}
			
		}else{
			throw new InvalidRequestException("List of players was empty or null in the Request");
		}
		  playerResponse.setResults(resultList);
		  playerResponse.setStatus("OK");
		  playerResponse.setErrorMsg("");
		  
		
		return playerResponse;

	}

	private String getJsonString(Player player) {
		
		String json="";
		
				
		ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		try {
			json=ow.writeValueAsString(player);
			
		} catch (JsonProcessingException ex) {
			
			logger.error("getJsonString: Exception thrown : ",ex);
		}
		
		return json;
	}

}
