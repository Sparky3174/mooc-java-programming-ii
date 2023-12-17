package application;

import application.userinterface.UserInterface;

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

public class SavingsCalculatorApplication extends Application {

    private LineChart savingsChart;
    private XYChart.Series savingsData;
    private XYChart.Series interestData;
    private double monthlySavings;
    private double yearlyInterestRate;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane rootLayout = new BorderPane();

        NumberAxis years = new NumberAxis(0, 30, 30);
        NumberAxis savings = new NumberAxis();

        savingsChart = new LineChart(years, savings);
        savingsChart.setTitle("Yearly savings");

        savingsData = new XYChart.Series();
        savingsData.setName("Savings");

        interestData = new XYChart.Series();
        interestData.setName("Interest + Savings");

        savingsChart.getData().add(savingsData);
        savingsChart.getData().add(interestData);
        VBox slidersLayout = initSliders();

        rootLayout.setTop(slidersLayout);
        rootLayout.setCenter(savingsChart);

        Scene mainScene = new Scene(rootLayout);
        stage.setScene(mainScene);
        stage.show();
    }

    public void updateChart() {
        savingsData.getData().clear();
        interestData.getData().clear();

        double principal = 0.0;
        double savings = 0.0;
        double interest = 0.0;

        for (int i = 0; i <= 30; i++) {
            if (i != 0) {
                principal += monthlySavings * 12;
            }
            savings = principal;
            interest = principal * (yearlyInterestRate / 100.0);
            principal += interest;

            savingsData.getData().add(new XYChart.Data(i, savings));
            System.out.println("Savings: " + savings);
            System.out.println("Interest & savings: " + principal);
            interestData.getData().add(new XYChart.Data(i, principal));
        }
    }

    public VBox initSliders() {
        Label monthlySavingsLabel = new Label("Monthly savings");
        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Label monthlySavingsNumLabel = new Label("25");
        Label yearlyInterestRateNumLabel = new Label("0");
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        Slider yearlyInterestRateSlider = new Slider(0, 10, 0);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setShowTickLabels(true);
        monthlySavings = 25;
        yearlyInterestRate = 0;
        updateChart();

        monthlySavingsSlider.valueProperty().addListener((listener, oldVal, newVal) -> {
            monthlySavings = (double) newVal;
            monthlySavingsNumLabel.setText(String.valueOf(newVal));
            updateChart();
        });

        yearlyInterestRateSlider.valueProperty().addListener((listener, oldVal, newVal) -> {
            yearlyInterestRateNumLabel.setText(String.valueOf(newVal));
            yearlyInterestRate = (double) newVal;
            updateChart();
        });

        VBox slidersLayout = new VBox(new BorderPane(monthlySavingsSlider, null, monthlySavingsNumLabel, null, monthlySavingsLabel),
                new BorderPane(yearlyInterestRateSlider, null, yearlyInterestRateNumLabel, null, yearlyInterestRateLabel));

        return slidersLayout;
    }

}
