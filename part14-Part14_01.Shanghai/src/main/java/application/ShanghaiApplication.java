package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.LineChart.*;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Arrays;

import javafx.application.Application;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) {

        String data = "2007 73\n"
                + "2008 68\n"
                + "2009 72\n"
                + "2010 72\n"
                + "2011 74\n"
                + "2012 73\n"
                + "2013 76\n"
                + "2014 73\n"
                + "2015 67\n"
                + "2016 56\n"
                + "2017 56";
        String[] dataPoints = data.split("\n");

        String[][] universityData = new String[dataPoints.length][2];
        for (int i = 0; i < dataPoints.length; i++) {
            universityData[i] = dataPoints[i].split(" ");
        }

        NumberAxis xAxis = new NumberAxis(2007, 2017, 4);
        NumberAxis yAxis = new NumberAxis(50, 100, 4);
        xAxis.setLabel("Ranking");
        yAxis.setLabel("Year");

        LineChart<Number, Number> chart = new LineChart(xAxis, yAxis);
        XYChart.Series universitySeries = new XYChart.Series();
        universitySeries.setName("University of Helsinki");
        
        for (int i = 0; i < universityData.length; i++) {
                XYChart.Data dataPoint = new XYChart.Data(Integer.parseInt(universityData[i][0]), Integer.parseInt(universityData[i][1]));
                universitySeries.getData().add(dataPoint);
        }

        chart.getData().add(universitySeries);
        chart.setTitle("University of Helsinki, Shanghai ranking");
        
        Scene mainScene = new Scene(chart, 500, 500);
        stage.setScene(mainScene);
        stage.show();
    }

    }
