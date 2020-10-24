/**
 * 
 */
package com.dhishani.SpringBootChallenge.dao;

import org.springframework.stereotype.Component;

import com.dhishani.SpringBootChallenge.dto.in.Player;

/**
 * @author dhishani
 *
 */
@Component
public interface PlayerH2Dao {
	
	public void saveExpertInH2DB(Player player);

}
