package com.leandrosantino.service_orders.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.leandrosantino.service_orders.view.PrimaryStage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

public class ViewController {
    @Autowired
    protected FxWeaver fxWeaver;

    @Autowired
    private PrimaryStage stageReadyEventListener;

    public void show() {
        this.stageReadyEventListener.setRoot(this.load());
    }

    protected Stage getPrimaryStage() {
        return stageReadyEventListener.stage;
    }

    protected Scene getScene() {
        return stageReadyEventListener.scene;
    }

    public Parent load() {
        return fxWeaver.loadView(this.getClass());
    }

}
