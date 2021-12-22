package sample;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
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
//    private int row = coordinates[1];
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
            double xTranslation = 29.70;
            double yTranslation = -37.75;
            for(int i = 0; i < count; i++) {
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
            Cell currentCell = GameBoard.getBoard().get(position-1);
            System.out.println(currentCell.getPosition());
            System.out.println(GameBoard.getBoard().get(position-1).isHasSnakeMouth());
            System.out.println(currentCell.isHasSnakeMouth());
//                if(position == 100){
//                    endGame();
//            return;
//                }
            int[] destination = new int[2];
            try {
                if (currentCell.isHasLadderBottom()) {
                    System.out.println("Ladder detected");
                    destination[0] = currentCell.getLadder().getTop()[0];
                    destination[1] = currentCell.getLadder().getTop()[1];
                    climbLadder(xTranslation, yTranslation, destination);
                } else if (currentCell.isHasSnakeMouth()) {
                    System.out.println("Snake Detected");
                    destination[0] = currentCell.getSnake().getTail()[0];
                    destination[1] = currentCell.getSnake().getTail()[1];
                    eatenBySnake(xTranslation, yTranslation, destination);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void climbLadder(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        climbLadder.setByX(xTransition*destination[0]);
        climbLadder.setByY((-1)*yTransition*destination[1]);
        climbLadder.play();
    }

    public void eatenBySnake(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        climbLadder.setByX((-1)*xTransition*destination[0]);
        climbLadder.setByY(yTransition*destination[1]);
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

//    public void endGame() throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("End.fxml")));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}
