package sample;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Game {

    private final Player Player1;
    private final Player Player2;
    private final Board GameBoard = new Board();
    private final Die Die = new Die();

    @FXML
    public Button exitButton;
    public AnchorPane background;
    public ImageView imageview;
    public TextField player1;
    public TextField player2;
    public Button replay;
    public Button backk;
    @FXML
    public Rectangle p1shadow;
    @FXML
    public Rectangle p2shadow;


    @FXML
    private ImageView diceImage;
    @FXML
    private Button rollButton;
    @FXML
    ImageView greenPawn;
    @FXML
    ImageView bluePawn;

    Stage stage;
    private boolean turn = true;

    public Game() {

//        String name1 = player1.getText();
//        String name2 = player2.getText();

        GameBoard.populateBoard();
        GameBoard.setSnakes();
        GameBoard.setLadders();

        Player1 = (new Player("yr", Color.BLUE, bluePawn, GameBoard));
        Player2 = (new Player("yr2", Color.GREEN, greenPawn, GameBoard));

        Player1.setPosition(0);
        Player2.setPosition(0);
//        Player1.setPosition(0);
//        Player2.setPosition(0);
    }

    public void exit(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to Exit!");
        alert.setContentText("Do you want to save before exiting?: ");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) imageview.getScene().getWindow();
            System.out.println("You successfully exited the game!");
            stage.close();
        }

    }

    public void exitGame(ActionEvent actionEvent) {
    }

    @FXML
    void roll(ActionEvent event) throws InterruptedException, IOException {

        int steps = Die.roll(event, rollButton, diceImage);

        if(p2shadow.isVisible()){
            p2shadow.setVisible(false);
            p1shadow.setVisible(true);
        }
        else{
            p2shadow.setVisible(true);
            p1shadow.setVisible(false);
        }

        if(turn) {
            Player1.move(bluePawn, steps);
            turn = false;
        }
        else{
            Player2.move(greenPawn, steps);
            turn = true;
        }
    }

    public ImageView cover;
    public ImageView player;
    private Scene scene;


    public void coverToPlayer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void playerToCover(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Scene1.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playerToGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void winnertogame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}