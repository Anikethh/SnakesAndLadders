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

import static com.sun.javafx.application.PlatformImpl.exit;

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
    private Scene scene;
    Stage newStage;
    Stage stage;

    Player(String name, Color color, ImageView pawn, Board GameBoard, Stage stage ){
        this.name = name;
        this.color = color;
        this.pawn = pawn;
        this.GameBoard = GameBoard;
        this.stage=stage;
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

//        position = 100;

        if(position + count <= 100) {
            Thread thread = new Thread(() -> {

                if(position + count == 100){
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByX(-29.70*count );
                    move.play();
                    if(this.name.equals("Anshul")){
                        System.out.println("Anshul Won");
                        System.out.println("Aniketh loss");
                    }
                    else{
                        System.out.println("Aniketh Won");
                        System.out.println("Anshul loss");
                    }
                    System.out.println("Game ended! ");
                    System.exit(0);
                }

                for (int i = 0; i < count; i++) {
                    double xTranslation = 29.70;
                    double yTranslation = -37.75;
                    if (coordinates[0] % 2 == 0) {
                        xTranslation *= -1;
                    }
                    if (coordinates[1] != 0) {
                        jumpAnimation(pawn);
                        horizontalMove(pawn, xTranslation);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        verticalMove(pawn, yTranslation);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    incrementPosition();
                }
                System.out.println(this.name+ ": "+ position);

                double xTranslation = 29.70;
                double yTranslation = -38.75;
                int[] destination;

                if (position == 3) {
                    setPosition(24);
                    updateCoordinates();
                    destination = new int[]{2, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 7) {
                    setPosition(34);
                    updateCoordinates();
                    destination = new int[]{3, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 12) {
                    setPosition(31);
                    updateCoordinates();
                    destination = new int[]{2, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }
                if (position == 15) {
                    setPosition(5);
                    updateCoordinates();
                    destination = new int[]{-1, -1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);

                }

                if (position == 20) {
                    setPosition(41);
                    updateCoordinates();
                    destination = new int[]{3, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 22) {
                    setPosition(2);
                    updateCoordinates();
                    destination = new int[]{-2, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 33) {
                    setPosition(8);
                    updateCoordinates();
                    destination = new int[]{-3, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 36) {
                    setPosition(46);
                    updateCoordinates();
                    destination = new int[]{1, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 44) {
                    setPosition(23);
                    updateCoordinates();
                    destination = new int[]{-2, -1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 56) {
                    setPosition(63);
                    updateCoordinates();
                    destination = new int[]{1, -2};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 60) {
                    setPosition(81);
                    updateCoordinates();
                    destination = new int[]{3, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }


                if (position == 68) {
                    setPosition(50);
                    updateCoordinates();
                    destination = new int[]{-2, 2};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 69) {
                    setPosition(93);
                    updateCoordinates();
                    destination = new int[]{4, -1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 75) {
                    setPosition(95);
                    updateCoordinates();
                    destination = new int[]{2, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 78) {
                    setPosition(97);
                    updateCoordinates();
                    destination = new int[]{2, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " used ladder, position: "+position);
                }

                if (position == 79) {
                    setPosition(43);
                    updateCoordinates();
                    destination = new int[]{-3, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 85) {
                    setPosition(65);
                    updateCoordinates();
                    destination = new int[]{-2, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 92) {
                    setPosition(71);
                    updateCoordinates();
                    destination = new int[]{-2, 1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 94) {
                    setPosition(47);
                    updateCoordinates();
                    destination = new int[]{-5, 0};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }

                if (position == 98) {
                    setPosition(82);
                    updateCoordinates();
                    destination = new int[]{-1, -1};
                    TranslateTransition move = new TranslateTransition(Duration.millis(250), pawn);
                    move.setByY(yTranslation * destination[0]);
                    move.setByX(xTranslation * destination[1]);
                    move.play();
                    System.out.println(this.name+ " got bitten by snake, position: "+position);
                }
            });
            thread.start();
        }
    }

    public void translate(double xTransition, double yTransition, int[] destination){
        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
        System.out.println("y: " + destination[0]);
        System.out.println("x: " + destination[1]);
        climbLadder.setByY((-1)*xTransition*destination[0]);
        climbLadder.setByX(yTransition*destination[1]);
        climbLadder.play();
    }

    public void updateCoordinates(){
        coordinates[0] = position / 10 + 1;
        coordinates[1] = position % 10;
    }

    public void jumpAnimation(ImageView pawn){
        TranslateTransition translation = new TranslateTransition(Duration.millis(75), pawn);
        translation.setByY(-10);
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
        System.out.println("Endyr");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("winnners.fxml")));
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.show();
    }
}

//playerCell = GameBoard.getBoard().get(position);
//        System.out.println(playerCell.getPosition());
////            System.out.println("Snake: " + playerCell.isHasSnakeMouth());
////            System.out.println("Ladder: " + playerCell.isHasLadderBottom());
//        if(position >= 100){
//        try {
////                    win.setVisible(true);
//        endGame();
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        return;
//        }
//        int[] destination = new int[2];
//        int[] yr = new int[2];
//        try {
//        if (playerCell.isHasLadderBottom()) {
//        System.out.println("Ladder detected");
//        destination[0] = playerCell.getLadder().getTop()[0] - coordinates[0];
//        destination[1] = playerCell.getLadder().getTop()[1] - coordinates[1];
//        System.out.println(destination[0] + " " + destination[1]);
////                    climbLadder(xTranslation, yTranslation, destination);
////                    translate(xTranslation, yTranslation, destination);
//        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
//        System.out.println("y: " + destination[0]);
//        System.out.println("x: " + destination[1]);
//        climbLadder.setByY(yTranslation*destination[0]);
//        climbLadder.setByX(xTranslation*destination[1]);
//        climbLadder.play();
//        try {
//        Thread.sleep(250);
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        } else if (playerCell.isHasSnakeMouth()) {
//        System.out.println("Snake Detected");
//        destination[0] = playerCell.getSnake().getTail()[0] - coordinates[0];
//        destination[1] = playerCell.getSnake().getTail()[1] - coordinates[1];
//        System.out.println(destination[0] + " " + destination[1]);
////                    eatenBySnake(xTranslation, yTranslation, destination);
////                    translate(xTranslation, yTranslation, destination);
//        TranslateTransition climbLadder = new TranslateTransition(Duration.millis(250), pawn);
//        System.out.println("y: " + destination[0]);
//        System.out.println("x: " + destination[1]);
//        climbLadder.setByY(yTranslation*destination[0]);
//        climbLadder.setByX(xTranslation*destination[1]);
//        climbLadder.play();
//        try {
//        Thread.sleep(250);
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//        }
//        } catch (Exception e){
//        e.printStackTrace();
//        }