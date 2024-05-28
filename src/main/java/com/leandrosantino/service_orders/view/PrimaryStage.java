package com.leandrosantino.service_orders.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.view.controller.Main;
import com.leandrosantino.service_orders.view.event.StageReadyEvent;

import fr.brouillard.oss.cssfx.CSSFX;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxWeaver;

@Component
@RequiredArgsConstructor
public class PrimaryStage implements ApplicationListener<StageReadyEvent> {

    @Value("${ui-title}")
    private final String applicationTitle;

    private final FxWeaver fxWeaver;

    public Scene scene;
    public Stage stage;

    public void setRoot(Parent parent) {
        scene.setRoot(parent);
    }

    @Override
    public void onApplicationEvent(@SuppressWarnings("null") StageReadyEvent event) {
        this.stage = event.getStage();
        Parent parent = fxWeaver.loadView(Main.class);
        this.scene = new Scene(parent, 1150, 700);
        System.out.println(scene.getHeight());
        stage.setMinWidth(scene.getWidth() + 16);
        stage.setMinHeight(scene.getHeight() + 39);

        CSSFX.start();
        stage.setScene(scene);
        stage.setTitle(applicationTitle);
        stage.centerOnScreen();
        stage.show();
    }
}