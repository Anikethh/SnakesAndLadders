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

//    private final SimpleObjectProperty<Player> Player1 = new SimpleObjectProperty<>(this, "player1");
    private final Player Player1;
    private final Player Player2;
//    private final SimpleObjectProperty<Player> Player2 = new SimpleObjectProperty<>(this, "player2");
    private final Board GameBoard = new Board();
    private final Die Die = new Die();

    @FXML
    public Button exitButton;
    public AnchorPane background;
    public ImageView imageview;
    public Button Jump;
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

    public Game() {
        Player1 = (new Player("yr", Color.BLUE, bluePawn));
        Player2 = (new Player("yr2", Color.GREEN, greenPawn));

        Player1.setPosition(0);
        Player2.setPosition(0);
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

        int n = Die.roll(event, rollButton, diceImage);
        System.out.println(n);

        if(turn) {
            Player1.setPosition(Player1.getPosition()+n);
            Player1.jump(bluePawn);
//            for(int i = 0; i < n; i++){
//                Player1.jump(bluePawn);
//            }
//            jump(count);
            turn = false;
        }
        else{
            Player2.setPosition(Player2.getPosition()+n);
            Player2.jump(greenPawn);
            turn = true;
        }
//        System.out.println(n);
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
        initializePlayers();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //playerName inputs
    public void initializePlayers() throws IOException {
//        String name1 = player1.getText();
//        String name2 = player2.getText();

//        Player1 = (new Player("yr", Color.BLUE, bluePawn));
//        Player2 = (new Player("yr2", Color.GREEN, greenPawn));
//
//        Player1.setPosition(0);
//        Player2.setPosition(0);

//        System.out.println(name1);
//        System.out.println(name2);
    }



}