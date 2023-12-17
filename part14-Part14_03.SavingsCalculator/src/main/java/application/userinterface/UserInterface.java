/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.userinterface;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Andre
 */
public class UserInterface extends Application {

    public UserInterface() {

    }

    @Override
    public void start(Stage stage) {
        BorderPane rootLayout = new BorderPane();

        VBox slidersLayout = initSliders();

        NumberAxis years = new NumberAxis(0, 30, 4);
        NumberAxis savings = new NumberAxis();
        LineChart savingsChart = new LineChart(years, savings);
        savingsChart.setTitle("Yearly savings");

        rootLayout.setTop(slidersLayout);
        rootLayout.setCenter(savingsChart);

        Scene mainScene = new Scene(rootLayout);
        stage.setScene(mainScene);
        stage.show();
    }

    public VBox initSliders() {
        Label monthlySavingsLabel = new Label("Monthly savings");
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Slider monthlySavingsSlider = new Slider(25, 250, 3);
        Slider yearlyInterestRateSlider = new Slider(0, 10, 3);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setSnapToTicks(true);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setSnapToTicks(true);

        VBox slidersLayout = new VBox(new BorderPane(monthlySavingsSlider, null, null, null, monthlySavingsLabel),
                new BorderPane(yearlyInterestRateSlider, null, null, null, yearlyInterestRateLabel));

        return slidersLayout;
    }

}
