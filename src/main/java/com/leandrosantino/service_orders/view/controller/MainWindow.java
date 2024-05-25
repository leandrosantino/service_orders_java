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

    private HashMap<String, ViewController> pages;

    @FXML
    public void initialize() {

        // pages.put("Home", fxWeaver.loadController(MainWindow.class));
        // pages.put("Ordens de Serviço",
        // fxWeaver.loadController(ServiceOrderForm.class));
        // pages.put("Teste", fxWeaver.loadController(TesteWindow.class));

        navbar.getItems().addAll(pages.keySet());
        navbar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // if (newValue != null)
            // pages.get(newValue).show();
        });

        this.getPrimaryStage().heightProperty().addListener((__, ___, ____) -> adjustLayoutSize());
        this.getPrimaryStage().maximizedProperty().addListener((__, ___, ____) -> adjustLayoutSize());
        adjustLayoutSize();
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
