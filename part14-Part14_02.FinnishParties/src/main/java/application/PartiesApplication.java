package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.application.Application;

import java.util.Scanner;
import java.util.HashMap;
import java.nio.file.Paths;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(PartiesApplication.class);

    }

    @Override
    public void start(Stage stage) {

        HashMap<String, HashMap<Integer, Double>> chartData = collectData();
        NumberAxis years = new NumberAxis(1968, 2008, 4);
        NumberAxis supportRankings = new NumberAxis();
        LineChart chart = new LineChart(years, supportRankings);
        chart.setTitle("Relative support of the parties");

        //make a series for the party
        //set its name
        //add new XYChart data to it
        chartData.keySet().stream().forEach(partyName -> {
            XYChart.Series party = new XYChart.Series(); //making a new party dataset
            HashMap<Integer, Double> partyData = chartData.get(partyName); //getting the data associated with the party
            party.setName(partyName); //setting name of party

            partyData.entrySet().stream().forEach(dataPair -> { //for each data point in the party data set
                if (dataPair.getValue() != null) { 
                    party.getData().add(new XYChart.Data(dataPair.getKey(), dataPair.getValue())); //add the data point to the party if it is not null
                }
            });
            
            chart.getData().add(party); //finally, add the party to the chart
        });
        
        Scene mainScene = new Scene(chart, 500, 500);
        stage.setScene(mainScene);
        stage.show();

    }

    public HashMap<String, HashMap<Integer, Double>> collectData() {
        try {
            Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"));
            String[] years = scanner.nextLine().split("\t"); //make a seperate array that lists the years, as we want the file reading process to start on the 2nd line, we call `nextLine()` to advance the scanner

            HashMap<String, HashMap<Integer, Double>> collectedData = new HashMap(); //make a master hashmap that stores party data like so: <partyName, HashMap<year,data>>
            while (scanner.hasNextLine()) { //keep going for the whole file
                HashMap<Integer, Double> listedData = new HashMap(); //the internal hashmap that will link each datapoint to a year
                String[] partyData = scanner.nextLine().split("\t"); //making an array of the data listed on the line
                String partyName = partyData[0]; //saving the name of the party
                for (int i = 1; i < partyData.length; i++) { //for each item in the array/line
                    if (!partyData[i].equals("-")) { //making sure to catch if there is no data present, represented by a "-"
                        listedData.put(Integer.parseInt(years[i]), Double.parseDouble(partyData[i])); //if there is data, add it
                    } else {
                        listedData.put(Integer.parseInt(years[i]), null); //if there is not any data, put a null placeholder
                    }
                    System.out.println(partyName + ", " + years[i] + ", " + listedData.get(Integer.parseInt(years[i]))); //print the collected data for debugging
                }
                collectedData.put(partyName, listedData); //add the party's name and it's associated data to the master HashMap
            }
            return collectedData; //return the main HashMap if all went well
        } catch (Exception e) {
            System.out.println("oops. " + e);
        }
        return null; //return null if it did not go well.
    }

}
