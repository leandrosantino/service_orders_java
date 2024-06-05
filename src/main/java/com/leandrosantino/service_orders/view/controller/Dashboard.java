package com.leandrosantino.service_orders.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.entity.machine.IMachineRepository;
import com.leandrosantino.service_orders.entity.machine.Machine;
import com.leandrosantino.service_orders.entity.service_order.IServiceOrderRepository;
import com.leandrosantino.service_orders.entity.ute.Ute;
import com.leandrosantino.service_orders.view.ViewController;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class Dashboard extends ViewController {

    @Autowired
    IMachineRepository machineRepository;

    @Autowired
    IServiceOrderRepository serviceOrderRepository;

    @FXML
    private BarChart<Number, String> mtbfChart;

    public void initialize() {

        var machine = new Machine();
        machine.setTag("M15");
        machine.setUte(Ute.UTE_1);
        machineRepository.save(machine);

        System.out.println(machineRepository.findAll());

        Series<Number, String> series = new Series<>();
        series.setName("MTBF");

        series.getData().add(new Data<>(30, "Formin moldinf"));
        series.getData().add(new Data<>(50, "Whater jet"));
        series.getData().add(new Data<>(30, "Injeção de pe"));
        series.getData().add(new Data<>(20, "Corte a layser"));
        series.getData().add(new Data<>(10, "Glausutec"));

        mtbfChart.getData().add(series);

        addDataLabels(mtbfChart);
        mtbfChart.setLegendVisible(false);
        mtbfChart.getXAxis().visibleProperty().set(false);
        mtbfChart.getXAxis().setTickLabelsVisible(false);
        mtbfChart.getXAxis().setTickMarkVisible(false);
        mtbfChart.getYAxis().setTickMarkVisible(false);
        mtbfChart.setHorizontalGridLinesVisible(false);
        mtbfChart.setVerticalGridLinesVisible(false);

        mtbfChart.getYAxis().setTickLabelFill(Color.BLACK);
        mtbfChart.getYAxis().setTickLabelFont(Font.font("Arial", 14));

    }

    private void addDataLabels(BarChart<Number, String> barChart) {
        for (XYChart.Series<Number, String> series : barChart.getData()) {
            for (XYChart.Data<Number, String> data : series.getData()) {
                StackPane bar = (StackPane) data.getNode();
                Text dataLabel = new Text(data.getXValue().toString());
                dataLabel.setFill(Color.WHITE);
                dataLabel.getStyleClass().add("chart-data-label");
                bar.getChildren().add(dataLabel);
            }
        }
    }

}
