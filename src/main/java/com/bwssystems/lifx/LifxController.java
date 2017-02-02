package com.bwssystems.lifx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.besherman.lifx.LFXClient;
import com.github.besherman.lifx.LFXLight;

public class LifxController {
    private static final Logger log = LoggerFactory.getLogger(LifxController.class);

    public static void main(String[] args) {
    	LFXClient client = new LFXClient();
    	LogManager.getLogManager().getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE);
    	try {
    		log.info("Open Lifx client....");
			client.open(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
    		log.info("List Lifx lights....");
    	    for(LFXLight light: client.getLights()) {
    	        System.out.format("Light: %n");
    	        System.out.format("\tid=%s%n", light.getID());
    	        System.out.format("\tlabel=%s%n", light.getLabel());
    	        System.out.format("\tpower=%s%n", light.isPower());
    	        System.out.format("\ttime=%s%n", light.getTime());
    	        System.out.format("\tcolor=%s%n", light.getColor());                
    	    }
    	} finally {
    	    client.close();
    	}
		log.info("Finished.");

    }
}
