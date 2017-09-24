package de.marcusjanke.casestudies.medicalprocedurescheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Programming exercise "Medical Procedure Scheduler"
 * 
 * @author marcus
 *
 */
@SpringBootApplication
public class App {
	
	/**
	 * do not use externally
	 */
	App() {		
	}

	/**
	 * start up app
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}