package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class Die {

    public int numberRolled;

    Random random = new Random();

    @FXML
    private ImageView diceImage;
    @FXML
    private Button rollButton;
    @FXML
    int roll(ActionEvent event, Button rollButton, ImageView diceImage) throws InterruptedException {

        rollButton.setDisable(true);

        Thread thread = new Thread(() -> {
//            System.out.println("Thread Running");
            try {
                for (int i = 0; i < 15; i++) {
                    numberRolled = random.nextInt(6)+1;
                    File file = new File("src/sample/Images/dice/dice-0" + numberRolled +".png");
                    diceImage.setImage(new Image(file.toURI().toString()));
                    Thread.sleep(50);
                }
                rollButton.setDisable(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        return numberRolled;
    }
}
