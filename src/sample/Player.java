package sample;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Player {

    @FXML
    private final ImageView pawn;
    private Cell playerCell;
    private final Board GameBoard;

    private int position;
    private int[] coordinates;
    private final Color color;
    private final String name;

    Player(String name, Color color, ImageView pawn, Board GameBoard){
        this.name = name;
        this.color = color;
        this.pawn = pawn;
        this.GameBoard = GameBoard;
    }

//    int count = 5;
    public void jump(ImageView pawn, int count) {

        Thread thread = new Thread(() -> {
            for(int i = 0; i < count; i++){
                TranslateTransition translation = new TranslateTransition(Duration.millis(125), pawn);
                translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                translation.setByY(-20);
                translation.setAutoReverse(true);
                translation.setCycleCount(2);
                translation.play();
                TranslateTransition xTransition = new TranslateTransition(Duration.millis(250), pawn);
                xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                xTransition.setByX(29);
                xTransition.play();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
