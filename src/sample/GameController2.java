package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController2 {
    @FXML
    Label name1;
    Label name2;

    public void disname(String playername1,String playername2){
        name1.setText(playername1);
        name2.setText(playername2);
    }

}
