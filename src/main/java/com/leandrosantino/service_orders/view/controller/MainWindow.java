package com.leandrosantino.service_orders.view.controller;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.utils.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class MainWindow extends ViewController {

    @FXML
    private ListView<String> navbar;

    @FXML
    private AnchorPane appContent;

    @FXML
    private VBox container;

    @FXML
    private HBox body;

    private HashMap<String, ViewController> pages = new HashMap<>();

    @FXML
    public void initialize() {
        loadNavbarOptions();
        adjustLayoutSize();

        getPrimaryStage().heightProperty().addListener((__, ___, ____) -> adjustLayoutSize());
        getPrimaryStage().maximizedProperty().addListener((__, ___, ____) -> adjustLayoutSize());
    }

    private void loadNavbarOptions() {
        pages.put("Preventivas", fxWeaver.loadController(ServiceOrderForm.class));
        pages.put("Corretivas", fxWeaver.loadController(TesteWindow.class));

        navbar.getItems().addAll(pages.keySet());
        navbar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                appContent.getChildren().setAll(pages.get(newValue).load());
        });
    }

    private void adjustLayoutSize() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            if (getScene() != null) {
                System.out.println("scene: " + getScene().getWidth() + " x " + getScene().getHeight());
                container.setPrefHeight(getScene().getHeight());
                body.setPrefHeight(getScene().getHeight() - 10);
            }
        };
        scheduler.schedule(task, 50, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }

}