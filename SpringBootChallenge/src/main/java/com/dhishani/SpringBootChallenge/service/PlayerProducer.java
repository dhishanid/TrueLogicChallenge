package com.dhishani.SpringBootChallenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author dhishani
 *
 */
@Service
public class PlayerProducer {
	
	 private static final Logger logger = LoggerFactory.getLogger(PlayerProducer.class);
	    private static final String TOPIC = "novice-players";

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void sendMessage(String message) {
	    	
	    	logger.info("sendMessage: Message [{}] was sent to Topic [{}]" ,message ,TOPIC);
	    	
	        this.kafkaTemplate.send(TOPIC, message);
	    }

}