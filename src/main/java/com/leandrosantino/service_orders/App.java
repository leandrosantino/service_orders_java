package com.leandrosantino.service_orders;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.leandrosantino.service_orders.infra.FxApplication;

import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;

@EnableScheduling
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		Application.launch(FxApplication.class, args);
	}

	@Bean
	FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
		return new SpringFxWeaver(applicationContext);
	}
}
