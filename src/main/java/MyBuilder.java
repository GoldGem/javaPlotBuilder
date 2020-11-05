import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.util.Pair;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MyBuilder implements PlotBuilder{
    public void functionGenerator(File file) throws FileNotFoundException {
        int a;
        int b;
        PrintWriter out = new PrintWriter(file);

        for (int i = 0; i < 2000; i++) {
            a = (int)(Math.random() * 100);
            b = (int)(Math.random() * 100);

            out.println(a + "\t" + b);

        }
        out.close();
    }

    public ArrayList<Pair<Integer, Integer>> functionLoader(File file) throws IOException {

        String sCurrentLine;

        ArrayList<Pair<Integer,Integer>> arrayList = new ArrayList<Pair<Integer, Integer>>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\t");
            arrayList.add(new Pair <Integer, Integer>(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
        }
        System.out.println(arrayList);
        br.close();
        return arrayList;
    }

    public void plotPainter(ArrayList<Pair<Integer, Integer>> function, JPanel panel) {
        LineChart<Number, Number> chart = null;
        chart.getData().clear();
        XYChart.Series series = new XYChart.Series();
//        for (int i = 0; i < function.size(); i++) {
//            series.getData().add(new XYChart.Data(function[i].getKey, function[i].getValue));
//        }
        for (Pair<Integer, Integer> item: function) {
            series.getData().add(new XYChart.Data(item.getKey(), item.getValue()));
        }
        chart.getData().add(series);
    }
}
