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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Game {

    private final SimpleObjectProperty<Player> Player1 = new SimpleObjectProperty<>(this, "player1");
    private final SimpleObjectProperty<Player> Player2 = new SimpleObjectProperty<>(this, "player2");
    private final Board GameBoard = new Board();
    private final Die Die = new Die();

    @FXML
    public Button exitButton;
    public AnchorPane background;
    public ImageView imageview;
    public Button rollButton1;
    public TextField player1;
    public TextField player2;

    @FXML
    private ImageView diceImage;
    @FXML
    private Button rollButton;
    @FXML
    ImageView greenPawn;
    @FXML
    ImageView bluePawn;

    Random random = new Random();
    Stage stage;
    private boolean turn = true;

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
    int roll(ActionEvent event) throws InterruptedException {
        int n = Die.roll(event, rollButton, diceImage);
//        System.out.println(n);
        return n;
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

    //playerName inputs
    public void initializePlayers(ActionEvent event) throws IOException {
        String name1 = player1.getText();
        String name2 = player2.getText();

        Player1.set(new Player(name1, Color.BLUE, bluePawn));
        Player2.set(new Player(name2, Color.GREEN, greenPawn));

        Player1.get().setPosition(0);
        Player2.get().setPosition(0);

        System.out.println(name1);
        System.out.println(name2);
    }

    public void jump(ActionEvent event) {
        TranslateTransition translation = new TranslateTransition(Duration.millis(250), bluePawn);
        translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        translation.setByY(-25);
        translation.setAutoReverse(true);
        translation.setCycleCount(2);
//        translation.setByX(35);
        translation.play();
//        translation.setByX(35);
        TranslateTransition xTransition = new TranslateTransition(Duration.millis(500), bluePawn);
        xTransition.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
        xTransition.setByX(28);
        xTransition.play();
    }
}

//class PawnController implements Initializable {
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        TranslateTransition translation = new TranslateTransition(Duration.millis(500), this);
//        translation.interpolatorProperty().set(Interpolator.SPLINE(.1, .1, .7, .7));
//        translation.setByY(-50);
//        translation.setAutoReverse(true);
//        translation.setCycleCount(2);
//        translation.play();
//    }
//}