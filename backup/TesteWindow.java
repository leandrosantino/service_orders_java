package com.leandrosantino.service_orders.view.controller;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.view.ViewController;
import com.leandrosantino.service_orders.view.components.ServiceOrderCard;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class TesteWindow extends ViewController {

    @FXML
    private FlowPane container;

    @FXML
    private VBox body;

    @FXML
    private ScrollPane scrollPaneContainer;

    @FXML
    public void initialize() {

        for (int i = 1; i <= 20; i++) {

            FxControllerAndView<ServiceOrderCard, VBox> controllerAndView = fxWeaver.load(ServiceOrderCard.class);
            Optional<VBox> card = controllerAndView.getView();
            if (card.isPresent()) {
                ServiceOrderCard cardController = controllerAndView.getController();
                cardController.setData(Integer.toString(i), "M" + (i + 12));
                container.getChildren().add(card.get());
            }
        }

    }

    public void test() {
        System.out.println("Teste");
    }

}