package com.leandrosantino.service_orders.view.controller;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.view.ViewController;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class Main extends ViewController {

    @FXML
    private ListView<String> navbar;

    @FXML
    private VBox appContent;

    @FXML
    private VBox container;

    @FXML
    private HBox body;

    private HashMap<String, OpenPage> pages = new HashMap<>();

    private interface OpenPage {
        public Node call();
    }

    @FXML
    public void initialize() {
        loadNavbarOptions();
        adjustLayoutSize();

        getPrimaryStage().heightProperty().addListener((__, ___, ____) -> adjustLayoutSize());
        getPrimaryStage().widthProperty().addListener((__, ___, ____) -> adjustLayoutSize());
        getPrimaryStage().maximizedProperty().addListener((__, ___, ____) -> adjustLayoutSize());
    }

    private void loadNavbarOptions() {
        pages.put("Dashboard", () -> fxWeaver.loadView(Dashboard.class));

        navbar.getItems().addAll(pages.keySet());
        navbar.getSelectionModel().select(0);
        appContent.getChildren().setAll(pages.get("Dashboard").call());
        navbar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                appContent.getChildren().setAll(pages.get(newValue).call());
        });
    }

    public void adjustLayoutSize() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            if (getScene() != null) {
                System.out.println(getScene().getWidth());
                container.setPrefHeight(getScene().getHeight());
                body.setPrefHeight(getScene().getHeight() - 10);
                appContent.setPrefWidth(getScene().getWidth() - 200);
            }
        };
        scheduler.schedule(task, 50, TimeUnit.MILLISECONDS);
        scheduler.shutdown();
    }

}
