package sample;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Player {

    @FXML
    private final ImageView pawn;
    private Cell playerCell;
    private final Board GameBoard;

    private int position;
    private boolean started;
    private final int[] coordinates = new int[2];
//    private int row = coordinates[1];
    private final Color color;
    private final String name;
    private boolean blueTurn = true;

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
                if(blueTurn){
                    blueTurn = false;
                }
//                TranslateTransition putOnBoard = new TranslateTransition(Duration.millis(75), pawn);
//                putOnBoard.setByX(0);
//                putOnBoard.setByY(-40);
//                putOnBoard.play();
                pawn.setTranslateX(-10);
                pawn.setTranslateY(-40);
            }
        }
        else {
            if(position%10 == 0){
                jumpRow(pawn);
            }
            else {
                jump(pawn, count, coordinates[1] % 10 == 1);
            }
        }
    }

    public void incrementPosition(){
        position += 1;
        coordinates[0] = position / 10 + 1;
        coordinates[1] = position % 10;
        System.out.println(coordinates[1]);
    }

    public void jump(ImageView pawn, int count, boolean sideRight) {
//        int finalXTranslation = xTranslation;
        Thread thread = new Thread(() -> {
            for(int i = 0; i < count; i++) {
                double xTranslation = 28.5;
//                sideRight = (coordinates[1] % 10) == 1;
                if(coordinates[0] % 2 == 0){
                    xTranslation *= -1;
                }
                if(coordinates[1] != 0) {
                    TranslateTransition translation = new TranslateTransition(Duration.millis(75), pawn);
//                    translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    translation.setByY(-20);
                    translation.setAutoReverse(true);
                    translation.setCycleCount(2);
                    translation.play();
                    TranslateTransition xTransition = new TranslateTransition(Duration.millis(150), pawn);
                    xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
                    xTransition.setByX(xTranslation);
                    xTransition.play();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    jumpRow(pawn);
                }
                incrementPosition();
            }
        });
        thread.start();
    }

    public void jumpRow(ImageView pawn){
        Translate trans = new Translate();
        trans.setX(trans.getX());
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
