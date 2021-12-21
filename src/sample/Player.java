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
    private boolean started;
    private int[] coordinates = new int[2];
//    private int row = coordinates[1];
    private final Color color;
    private final String name;

    Player(String name, Color color, ImageView pawn, Board GameBoard){
        this.name = name;
        this.color = color;
        this.pawn = pawn;
        this.GameBoard = GameBoard;
        position = 0;
    }

    public void move(ImageView pawn, int count){
        if(!started){
            if(count == 1){
                started = true;
                position = 1;
                coordinates[0] = 1;
                coordinates[1] = 1;
            }
        }
        else {
            if(position%10 == 0){
                jumpRow(pawn);
            }
            else {
                jump(pawn, count, coordinates[0] % 2 == 1);
//                position += count;
//                coordinates[0] = position/10 + 1;
//                coordinates[1] = position%10;
            }
        }
    }

    public void incrementPosition(){
        position += 1;
        coordinates[0] = position / 10 + 1;
        coordinates[1] = position % 10;

    }

    public void jump(ImageView pawn, int count, boolean sideRight) {

        int xTranslation = 29;

        if(!sideRight){
            xTranslation *= -1;
        }

        int finalXTranslation = xTranslation;
        Thread thread = new Thread(() -> {
            for(int i = 0; i < count; i++) {
                if(coordinates[0] % 2 == 1) {
                    TranslateTransition translation = new TranslateTransition(Duration.millis(125), pawn);
                    translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    translation.setByY(-20);
                    translation.setAutoReverse(true);
                    translation.setCycleCount(2);
                    translation.play();
                    TranslateTransition xTransition = new TranslateTransition(Duration.millis(250), pawn);
                    xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    xTransition.setByX(finalXTranslation);
                    xTransition.play();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    incrementPosition();
                }
                else{
                    jumpRow(pawn);
                    incrementPosition();
                }
            }
        });
        thread.start();
    }

    public void jumpRow(ImageView pawn){
        TranslateTransition translation = new TranslateTransition(Duration.millis(125), pawn);
        translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        translation.setByY(-40.25);
        translation.play();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
