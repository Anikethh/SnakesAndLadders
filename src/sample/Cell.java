package sample;

public class Cell {

    private boolean hasSnakeMouth;
    private boolean hasSnakeTail;
    private boolean hasLadderTop;
    private boolean hasLadderBottom;
    private int[] coordinate = new int[2];
    private final int position;

    Cell(int position, int[] coordinate){
        this.position = position;
        this.coordinate = coordinate;
    }
}
