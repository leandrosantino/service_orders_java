package com.leandrosantino.service_orders.view.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leandrosantino.service_orders.entity.DataPage;
import com.leandrosantino.service_orders.view.ViewController;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView
@Component
public class ServiceOrderForm extends ViewController {

    @FXML
    private Button btPrint;
    @FXML
    private Button btReload;
    @FXML
    private WebView view;
    @FXML
    private TextField amountField;

    @FXML
    private VBox testeC;

    @FXML
    public void initialize() {

    }

    @FXML
    private void loadDoc() {
        List<DataPage.Itens> itens = new ArrayList<>();

        int amount = Integer.parseInt(amountField.getText());

        for (int i = 1; i <= amount; i++) {
            itens.add(new DataPage.Itens(i + "", "Leandro Santino", "Teste"));
        }

        DataPage page = DataPage.builder()
                .id("94568")
                .weekCode(22)
                .machineTag("M20")
                .year(2024)
                .duration(50)
                .nature("Elétrica")
                .itens(itens)
                .build();

        TemplateEngine templateEngine = TemplateEngine.createPrecompiled(ContentType.Html);
        TemplateOutput output = new StringOutput();
        templateEngine.render("template.jte", page, output);

        var webEngine = view.getEngine();
        webEngine.loadContent(output.toString(), "text/html");
    }

    @FXML
    public void teste() {
        PrinterJob job = PrinterJob.createPrinterJob();
        Printer printer = job.getPrinter();

        if (job != null && job.showPrintDialog(view.getScene().getWindow())) {

            PageLayout layout = printer.createPageLayout(
                    Paper.A4,
                    PageOrientation.PORTRAIT,
                    10, 10, 15, 15);

            job.getJobSettings().setPageLayout(layout);

            view.getEngine().print(job);
            System.out.println("Print Success!!");
            job.endJob();
        }
    }

    @FXML
    public void back() {
        fxWeaver.loadController(MainWindow.class).show();
    }
}
