package sample;

import javafx.scene.paint.Color;

public class Player {

    private int position;
    private int[] coordinates;
    private Color color;
    private final String name;

    Player(String name, Color color){
        this.name = name;
        this.color = color;
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

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }
}
