package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class UnfairAdvertisementApplication extends Application {

    @Override
    public void start(Stage window) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis(50.0, 100, 50); //made the graph range from 50-100
        yAxis.setTickLabelsVisible(true); //shows the numberical values for each line on the graph
        yAxis.setLabel("Speed in MB/s"); //renamed the side to not say "Faster and Better!" as that tells us nothing about the unit of measurement used in the graph, what exactly it is measuring, etc.

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Internet speed");
        barChart.setLegendVisible(false);

        XYChart.Series speeds = new XYChart.Series();
        speeds.getData().add(new XYChart.Data("NDA", 77.4));
        speeds.getData().add(new XYChart.Data("Fastie", 77.2));
        speeds.getData().add(new XYChart.Data("SuperNet", 77.1));
        speeds.getData().add(new XYChart.Data("Meganet", 77.1));

        barChart.getData().add(speeds);
        Scene view = new Scene(barChart, 400, 300);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(UnfairAdvertisementApplication.class);
    }

}
