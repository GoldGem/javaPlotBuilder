package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PlotBuilder builder = new com.company.MyBuilder();

        builder.functionGenerator(new File("test.txt"));
        ArrayList<Pair<Integer, Integer>> XY = builder.functionLoader(new File("test.txt"));


        primaryStage.setTitle("LineChart");
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X axis");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y axis");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Series");

        lineChart.getData().add(builder.plotPainter(XY, dataSeries));

        VBox vbox = new VBox(lineChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
