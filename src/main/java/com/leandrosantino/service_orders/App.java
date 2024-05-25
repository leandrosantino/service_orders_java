package com.leandrosantino.service_orders;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.leandrosantino.service_orders.infra.FxApplication;

import javafx.application.Application;

@EnableScheduling
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		Application.launch(FxApplication.class, args);
	}
}
