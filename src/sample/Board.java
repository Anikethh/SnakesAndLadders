package sample;

import java.util.ArrayList;

public class Board {

    private final int Dimensions = 11;
    private final int[] coordinateArray = new int[100];
//    private final ArrayList<ArrayList<Cell>> Board = new ArrayList<ArrayList<Cell>>(Dimensions+1);
    private final ArrayList<Cell> Board = new ArrayList<>(101);

    public void populateBoard(){
        int position = 1;
//        for(int i = 1; i < Dimensions; i++){
//            Board.add(new ArrayList<Cell>(Dimensions));
//            for(int j = 1; j < Dimensions; j++){
//                int[] coordinates = {i, j};
//                Cell newCell = new Cell(position, coordinates);
//                position++;
//                Board.get(i).add(newCell);
//            }
//        }
        for (int i = 0; i < 101; i++){
            int[] coordinates = {i, 0};
            Cell newCell = new Cell(position, coordinates);
            Board.add(newCell);
            position++;
        }
    }

    public ArrayList<Cell> getBoard() {
        return Board;
    }

    public void setSnakes(){
        Board.get(15).setHasSnakeMouth(true);
        Board.get(22).setHasSnakeMouth(true);
        Board.get(33).setHasSnakeMouth(true);
        Board.get(44).setHasSnakeMouth(true);
        Board.get(68).setHasSnakeMouth(true);
        Board.get(79).setHasSnakeMouth(true);
        Board.get(85).setHasSnakeMouth(true);
        Board.get(92).setHasSnakeMouth(true);
        Board.get(94).setHasSnakeMouth(true);
        Board.get(98).setHasSnakeMouth(true);
//        Board.get(0).get(0).setHasSnakeMouth(true);
//        Board.get(3).get(2).setHasSnakeMouth(true);
//        Board.get(1).get(2).setHasSnakeTail(true);
//        Board.get(2).get(5).setHasSnakeMouth(true);
//        Board.get(1).get(5).setHasSnakeTail(true);
//        Board.get(4).get(3).setHasSnakeMouth(true);
//        Board.get(4).get(2).setHasSnakeTail(true);
    }

    public void setLadders(){
//        Board.get(10).get(9).setHasLadderTop(true);
//        Board.get(4).get(5).setHasLadderBottom(true);
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
