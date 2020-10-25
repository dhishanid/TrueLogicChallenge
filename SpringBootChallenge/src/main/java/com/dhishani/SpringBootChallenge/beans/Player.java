/**
 * 
 */
package com.dhishani.SpringBootChallenge.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author dhishani
 *
 */
@Entity
public class Player {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String playerType;
	
	
	
	public Player() {
		
	}
	
	
	public Player(Long id, String name, String playerType) {
		super();
		this.id = id;
		this.name = name;
		this.playerType = playerType;
	}


	public Player(String name, String playerType) {
		super();
		this.name = name;
		this.playerType = playerType;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

}
