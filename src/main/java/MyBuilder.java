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


    }

    public void plotPainter(ArrayList<Pair<Integer, Integer>> function, JPanel panel) {

    }
}
