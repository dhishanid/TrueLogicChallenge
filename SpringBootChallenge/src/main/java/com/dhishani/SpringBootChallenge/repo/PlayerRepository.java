/**
 * 
 */
package com.dhishani.SpringBootChallenge.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhishani.SpringBootChallenge.beans.Player;



/**
 * @author dhishani
 *
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long>  {
	
	

}
