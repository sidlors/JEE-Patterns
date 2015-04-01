package com.sidlors.notificacion;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import junit.framework.Assert;



import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileTest {

	final static Logger logger = LoggerFactory.getLogger(ProfileTest.class);

	@Before
	public void up() throws Exception {
		

	}

	@Test
	public void readPropertiesTest() {
		
		Properties prop = new Properties();
		String propFileName = "../classes/enviroment.properties";

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		URL location = ProfileTest.class.getProtectionDomain().getCodeSource().getLocation();
		
		try {
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		Date time = new Date(System.currentTimeMillis());

		// get the property value and print it out
		String ip = prop.getProperty("ip.db");
		String port = prop.getProperty("ip.port");
		Assert.assertEquals("localhost", ip);
		Assert.assertEquals("1521", port);
		logger.info("ip: " + ip + " port: " + port + " "+time);
		
		
	}

}
