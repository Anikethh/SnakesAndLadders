package sample;

import java.util.ArrayList;

public class Board {

    private final int Dimensions = 10;
    private final ArrayList<ArrayList<Cell>> Board = new ArrayList<ArrayList<Cell>>(Dimensions);

    public void populateBoard(){
        for(int i = 0; i < Dimensions; i++){
            Board.add(new ArrayList<Cell>(Dimensions));
            for(int j = 0; j < Dimensions; j++){
                int[] coordinates = {i, j};
                Cell newCell = new Cell((i*Dimensions) + (j), coordinates);
                Board.get(i).add(newCell);
            }
        }
    }

    public ArrayList<ArrayList<Cell>> getBoard() {
        return Board;
    }

    public void setSnakes(){
        Board.get(5).get(5).setHasSnakeMouth(true);
        Board.get(5).get(5).setHasSnakeTail(true);
    }

    public void setLadders(){
        Board.get(10).get(9).setHasLadderTop(true);
        Board.get(4).get(5).setHasLadderBottom(true);
    }
}

class Snake{
    private int[] mouth = new int[2];
    private int[] tail = new int[2];
    private int mouthPosition;
    private int tailPosition;

    public int[] getTail() {
        return tail;
    }
}

class Ladder{
    private int[] bottom = new int[2];
    private int[] top = new int[2];
    private int bottomPosition;
    private int topPosition;

    public int[] getBottom() {
        return bottom;
    }

    public int[] getTop() {
        return top;
    }
}
