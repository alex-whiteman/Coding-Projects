package sample;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class StopSign extends Pane {
    private void paint() {

        Polygon StopSign = new Polygon();
        StopSign.setFill(Color.RED);
        StopSign.setStroke(Color.WHITE);
        ObservableList<Double> list = StopSign.getPoints();
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }
        StopSign.setRotate(22.5);
        getChildren().clear();
        getChildren().add(StopSign);
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}