package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Game {

    private Player Player1;
    private Player Player2;
    private Board GameBoard;
    private Die Die;

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

    Random random = new Random();
    Stage stage;
    private int turn = 0;

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
    int roll(ActionEvent event) {

        boolean turnFlag = true;


        if(turn%2 == 0){

        }
        else{

        }

        rollButton.setDisable(true);
        final int[] numberRolled = new int[1];


        Thread thread = new Thread(){
            public void run(){

                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 15; i++) {
                        numberRolled[0] = random.nextInt(6)+1;
                        File file = new File("src/sample/Images/dice/dice-0" + numberRolled[0] +".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                    }
                    System.out.println(numberRolled[0]);
                    rollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        System.out.println(numberRolled[0]);
        return numberRolled[0];
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
    public void playerNames(ActionEvent event) throws IOException {
        String name1 = player1.getText();
        String name2 = player2.getText();

        System.out.println(name1);
        System.out.println(name2);

    }
}