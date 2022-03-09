package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane(new StopSign());
        Text stop = new Text("STOP");
        stop.setFont(Font.font("Highway Gothic", FontWeight.BOLD, 110));
        stop.setFill(Color.WHITE);
        pane.getChildren().add(stop);
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("STOP Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
