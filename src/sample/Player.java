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

    private int position;
    private int[] coordinates;
    private final Color color;
    private final String name;

    Player(String name, Color color, ImageView pawn){
        this.name = name;
        this.color = color;
        this.pawn = pawn;
    }

    public void jump(ImageView pawn) {

//        Thread thread = new Thread(() -> {
//        if(count > 0) {
        TranslateTransition translation = new TranslateTransition(Duration.millis(125), pawn);
        translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        translation.setByY(-20);
        translation.setAutoReverse(true);
        translation.setCycleCount(2);
        translation.play();
        TranslateTransition xTransition = new TranslateTransition(Duration.millis(250), pawn);
        xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        xTransition.setByX(28);
        xTransition.play();
//            count--;
//            jump(count);
//        }
//        });
//        thread.start();
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
