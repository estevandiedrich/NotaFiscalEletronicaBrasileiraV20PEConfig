package br.com.hs.nfe.pe.ui;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	private static final Logger logger = Logger.getLogger("Main");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String log4jConfigurationFile = System.getProperty("log4j.configuration", "../conf/log4j.properties");
		PropertyConfigurator.configure(log4jConfigurationFile);
		logger.info("Aplicação iniciada");
		Runnable runnable = new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				new IntegrationUI();
			}
    	};
    	new Thread(runnable).start();
	}

}
