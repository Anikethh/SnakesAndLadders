package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Player {

    @FXML
    private ImageView pawn;

    private int position;
    private int[] coordinates;
    private final Color color;
    private final String name;

    Player(String name, Color color, ImageView pawn){
        this.name = name;
        this.color = color;
        this.pawn = pawn;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
