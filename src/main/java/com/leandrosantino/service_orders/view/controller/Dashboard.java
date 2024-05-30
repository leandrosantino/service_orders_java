package com.leandrosantino.service_orders.view.controller;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.view.ViewController;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class Dashboard extends ViewController {

    @FXML
    private BarChart<Number, String> mtbfChart;

    public void initialize() {

        Series<Number, String> series = new Series<>();
        series.setName("MTBF");

        series.getData().add(new Data<>(30, "Formin moldinf"));
        series.getData().add(new Data<>(50, "Whater jet"));
        series.getData().add(new Data<>(30, "Injeção de pe"));
        series.getData().add(new Data<>(20, "Corte a layser"));
        series.getData().add(new Data<>(10, "glausutec"));

        mtbfChart.getData().add(series);

        addDataLabels(series);
        mtbfChart.setLegendVisible(false);
        mtbfChart.getXAxis().setTickLabelsVisible(false);
        mtbfChart.getXAxis().setTickMarkVisible(false);
        mtbfChart.getYAxis().setTickMarkVisible(false);
        mtbfChart.setHorizontalGridLinesVisible(false);
        mtbfChart.setVerticalGridLinesVisible(false);

        for (Data<Number, String> data : series.getData()) {
            data.getNode().setStyle("-fx-bar-fill: " + toRgbString(Color.BLUE) + ";");
        }
    }

    private void addDataLabels(XYChart.Series<Number, String> series) {
        for (XYChart.Data<Number, String> data : series.getData()) {
            Node node = data.getNode();
            Text dataLabel = new Text(data.getXValue().toString());
            node.parentProperty().addListener((ov, oldParent, parent) -> {
                if (parent != null) {
                    ((Group) parent).getChildren().add(dataLabel);
                }
            });
            node.boundsInParentProperty().addListener((ov, oldBounds, bounds) -> {
                dataLabel.setLayoutX(bounds.getMaxX() + 5);
                dataLabel.setLayoutY(bounds.getMinY() + bounds.getHeight() / 2);
            });
        }
    }

    private String toRgbString(Color color) {
        return String.format("rgb(%d,%d,%d)",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

}
