package com.example.gestione_campioni_sql;

import com.example.gestione_campioni_sql.Service.ChampionService;
import com.example.gestione_campioni_sql.Service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestioneCampioniSqlApplication implements ApplicationRunner, CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(GestioneCampioniSqlApplication.class);

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(GestioneCampioniSqlApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	public String helloWorld(){
		return "Hello World!";
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(helloWorld());
		//auto invia una mail all'avvio dell'app
		//emailService.sendSimpleEmail("latuamail@provamail.com", "Test mail", "prova springboot");
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
}
