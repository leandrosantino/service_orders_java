package com.leandrosantino.service_orders.infra;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.leandrosantino.service_orders.App;
import com.leandrosantino.service_orders.view.event.StageReadyEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class FxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(App.class)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

}
