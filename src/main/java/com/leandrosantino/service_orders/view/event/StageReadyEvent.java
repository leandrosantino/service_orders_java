package com.leandrosantino.service_orders.view.event;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;

public class StageReadyEvent extends ApplicationEvent {
    public StageReadyEvent(Stage stage) {
        super(stage);
    }

    public Stage getStage() {
        return ((Stage) getSource());
    }
}
