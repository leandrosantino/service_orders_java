package com.leandrosantino.service_orders.view.components;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.view.ViewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class ServiceOrderCard extends ViewController {

    @FXML
    private Label lbNumber;
    @FXML
    private Label lbTag;

    public void setData(String number, String tag) {
        lbNumber.setText(number);
        lbTag.setText(tag);
    }

}
