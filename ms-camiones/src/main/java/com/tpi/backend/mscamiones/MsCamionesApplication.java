package com.tpi.backend.mscamiones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;

@SpringBootApplication
public class MsCamionesApplication {

	public static void main(String[] args) {
		// Establecer la timezone por defecto a UTC para evitar problemas con PostgreSQL
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(MsCamionesApplication.class, args);
	}

}
