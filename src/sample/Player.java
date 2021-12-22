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
                    pawn.setTranslateY(-38);
                }
//                TranslateTransition putOnBoard = new TranslateTransition(Duration.millis(75), pawn);
//                putOnBoard.setByX(0);
//                putOnBoard.setByY(-40);
//                putOnBoard.play();
            }
        }
        else {
            jump(pawn, count);
        }
    }

    public void incrementPosition(){
        position += 1;
        coordinates[0] = position / 10 + 1;
        coordinates[1] = position % 10;
    }

    public void jump(ImageView pawn, int count) {
        Thread thread = new Thread(() -> {
            for(int i = 0; i < count; i++) {
                double xTranslation = 29.75;
                double yTranslation = -38;
                if(coordinates[0] % 2 == 0){
                    xTranslation *= -1;
                }
                if(coordinates[1] != 0) {
                    jumpAnimation(pawn);
                    horizontalMove(pawn, xTranslation);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    verticalMove(pawn, yTranslation);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                incrementPosition();
                Cell currentCell = GameBoard.getBoard().get(coordinates[0]).get(coordinates[1]);
                int[] destination = new int[2];
                try {
                    if (currentCell.isHasLadderBottom()) {
                        System.out.println("Ladder detected");
                        destination[0] = currentCell.getLadder().getTop()[0];
                        destination[1] = currentCell.getLadder().getTop()[1];
                        pawn.setTranslateX(xTranslation * destination[0] - pawn.getX());
                        pawn.setTranslateY(yTranslation * destination[1] - pawn.getY());
                    } else if (currentCell.isHasSnakeMouth()) {
                        System.out.println("Snake Detected");
                        destination[0] = currentCell.getLadder().getTop()[0];
                        destination[1] = currentCell.getLadder().getTop()[1];
                        pawn.setTranslateX(xTranslation * destination[0] - pawn.getX());
                        pawn.setTranslateY(yTranslation * destination[1] - pawn.getY());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void jumpAnimation(ImageView pawn){
        TranslateTransition translation = new TranslateTransition(Duration.millis(75), pawn);
        translation.setByY(-20);
        translation.setAutoReverse(true);
        translation.setCycleCount(2);
        translation.play();
    }

    public void horizontalMove(ImageView pawn, double xTranslation){
        TranslateTransition xTransition = new TranslateTransition(Duration.millis(150), pawn);
        xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        xTransition.setByX(xTranslation);
        xTransition.play();
    }

    public void verticalMove(ImageView pawn, double yTranslation){
        TranslateTransition translationY = new TranslateTransition(Duration.millis(150), pawn);
        translationY.setByY(yTranslation);
        translationY.play();
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
