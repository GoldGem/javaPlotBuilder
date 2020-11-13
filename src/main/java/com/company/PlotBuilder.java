package com.company;

import javafx.scene.chart.XYChart;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface PlotBuilder {
	//метод принимает путь до файла
	//создает новый файл и записывает или записывает в существующий файл, если имеется, координаты в виде X	Y (два столбика. XтабуляцияY)
    void functionGenerator(File file) throws FileNotFoundException;
	//метод принимает на вход путь до файла и возвращает ArrayList, который хранит в себе классы Pair (этот класс существет в Java)
	//ArrayList хранит Pair; Pair хранит координаты
    ArrayList<Pair<Integer, Integer>> functionLoader(File file) throws IOException;
	//если panel == Null, то создать свой и вывести в него, если нет, то вывести в переданном
    XYChart.Series plotPainter(ArrayList<Pair<Integer, Integer>> function, XYChart.Series series);
}
