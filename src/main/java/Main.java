import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        PlotBuilder builder = new MyBuilder();

        builder.functionGenerator(new File("test.txt"));
        ArrayList<Pair<Integer, Integer>> XY = builder.functionLoader(new File("test.txt"));
//        builder.plotPainter(XY, null);

        Group root = new Group();
        Scene scene = new Scene(root);     // создание сцены
        stage.setScene(scene);
        stage.show();
    }
}
