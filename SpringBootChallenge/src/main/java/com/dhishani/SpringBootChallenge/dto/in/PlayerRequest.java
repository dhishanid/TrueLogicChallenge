/**
 * 
 */
package com.dhishani.SpringBootChallenge.dto.in;

import java.util.List;

/**
 * @author dhishani
 *
 */
public class PlayerRequest {
	
	private List<Player> players;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
