package org.formation.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {

	private static Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

	public static void main(String[] args) {

		LOGGER.info("Information");
		LOGGER.debug("Ca ne marche pas!!!");
		LOGGER.trace("YAHOOOO");
		LOGGER.warn("Attention!");
		LOGGER.error("FATAL ERROR!!!!");

	}

}
