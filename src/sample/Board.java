package sample;

import java.util.ArrayList;

public class Board {

    private final int Dimensions = 10;
    private final ArrayList<ArrayList<Cell>> Board = new ArrayList<ArrayList<Cell>>(Dimensions);

    public void populateBoard(){
        for(int i = 0; i < 10; i++){
            Board.add(new ArrayList<Cell>(Dimensions));
            for(int j = 0; j < 10; j++){
                int[] coordinates = {i, j};
                Cell newCell = new Cell((i*Dimensions) + (j), coordinates);
                Board.get(i).add(newCell);
            }
        }
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
