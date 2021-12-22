package sample;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Objects;

public class Player {

    @FXML
    private final ImageView pawn;
    private Cell playerCell;
    private final Board GameBoard;

    private int position;
    private boolean started;
    private final int[] coordinates = new int[2];
    private final Color color;
    private final String name;
    private boolean blueTurn = true;

    Stage stage;
    private Scene scene;

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
                    pawn.setTranslateY(-37);
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
                double xTranslation = 29.70;
                double yTranslation = -37.75;
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
            }

            double xTranslation = 29.70;
            double yTranslation = -37.75;

            playerCell = GameBoard.getBoard().get(position);
            System.out.println(playerCell.getPosition());
//            System.out.println("Snake: " + playerCell.isHasSnakeMouth());
//            System.out.println("Ladder: " + playerCell.isHasLadderBottom());
//                if(position == 100){
//                    endGame();
//            return;
//                }
            int[] destination = new int[2];
            int[] yr = new int[2];
            try {
                if (playerCell.isHasLadderBottom()) {
                    System.out.println("Ladder detected");
                    destination[0] = playerCell.getLadder().getTop()[0] - coordinates[0];
                    destination[1] = playerCell.getLadder().getTop()[1] - coordinates[1];
                    System.out.println(destination[0] + " " + destination[1]);
//                    climbLadder(xTranslation, yTranslation, destination);
//                    translate(xTranslation, yTranslation, destination);
                    TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
                    System.out.println("y: " + destination[0]);
                    System.out.println("x: " + destination[1]);
                    climbLadder.setByY(yTranslation*destination[0]);
                    climbLadder.setByX(xTranslation*destination[1]);
                    climbLadder.play();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (playerCell.isHasSnakeMouth()) {
                    System.out.println("Snake Detected");
                    destination[0] = playerCell.getSnake().getTail()[0] - coordinates[0];
                    destination[1] = playerCell.getSnake().getTail()[1] - coordinates[1];
                    System.out.println(destination[0] + " " + destination[1]);
//                    eatenBySnake(xTranslation, yTranslation, destination);
//                    translate(xTranslation, yTranslation, destination);
                    TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
                    System.out.println("y: " + destination[0]);
                    System.out.println("x: " + destination[1]);
                    climbLadder.setByY(yTranslation*destination[0]);
                    climbLadder.setByX(xTranslation*destination[1]);
                    climbLadder.play();
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void translate(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        System.out.println("y: " + destination[0]);
        System.out.println("x: " + destination[1]);
        climbLadder.setByY((-1)*xTransition*destination[0]);
        climbLadder.setByX(yTransition*destination[1]);
        climbLadder.play();
//        TranslateTransition translation = new TranslateTransition(Duration.millis(75), pawn);
//        translation.setByY(-20);
//        translation.setAutoReverse(true);
//        translation.setCycleCount(2);
//        translation.play();
    }

    public void climbLadder(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        System.out.println("x: " + destination[0]);
        System.out.println("y: " + destination[1]);
        climbLadder.setByX(yTransition*destination[0]);
        climbLadder.setByY(xTransition*destination[1]);
        climbLadder.play();
    }
//    (-1)

    public void eatenBySnake(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        System.out.println("x: " + destination[0]);
        System.out.println("y: " + destination[1]);
        climbLadder.setByX(yTransition*destination[0]);
        climbLadder.setByY(xTransition*destination[1]);
        climbLadder.play();
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

    public void endGame() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("winnners.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("End.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }
}
