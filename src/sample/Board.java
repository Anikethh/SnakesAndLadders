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
        Board.get(15).createSnake(new Snake(5));

        Board.get(22).setHasSnakeMouth(true);
        Board.get(22).createSnake(new Snake(2));

        Board.get(33).setHasSnakeMouth(true);
        Board.get(33).createSnake(new Snake(8));

        Board.get(44).setHasSnakeMouth(true);
        Board.get(44).createSnake(new Snake(22));

        Board.get(68).setHasSnakeMouth(true);
        Board.get(68).createSnake(new Snake(50));

        Board.get(79).setHasSnakeMouth(true);
        Board.get(79).createSnake(new Snake(43));

        Board.get(85).setHasSnakeMouth(true);
        Board.get(85).createSnake(new Snake(65));

        Board.get(92).setHasSnakeMouth(true);
        Board.get(92).createSnake(new Snake(71));

        Board.get(94).setHasSnakeMouth(true);
        Board.get(94).createSnake(new Snake(47));

        Board.get(98).setHasSnakeMouth(true);
        Board.get(98).createSnake(new Snake(82));
    }

    public void setLadders(){
        Board.get(3).setHasLadderBottom(true);
        Board.get(3).createLadder(new Ladder(24));

        Board.get(7).setHasLadderBottom(true);
        Board.get(7).createLadder(new Ladder(34));

        Board.get(12).setHasLadderBottom(true);
        Board.get(12).createLadder(new Ladder(31));

        Board.get(20).setHasLadderBottom(true);
        Board.get(20).createLadder(new Ladder(41));

        Board.get(36).setHasLadderBottom(true);
        Board.get(36).createLadder(new Ladder(46));

        Board.get(56).setHasLadderBottom(true);
        Board.get(56).createLadder(new Ladder(63));

        Board.get(60).setHasLadderBottom(true);
        Board.get(60).createLadder(new Ladder(81));

        Board.get(69).setHasLadderBottom(true);
        Board.get(69).createLadder(new Ladder(93));

        Board.get(75).setHasLadderBottom(true);
        Board.get(75).createLadder(new Ladder(95));

        Board.get(78).setHasLadderBottom(true);
        Board.get(78).createLadder(new Ladder(97));
    }
}

class Snake{
    private int[] mouth = new int[2];
    private int[] tail = new int[2];
    private int mouthPosition;
    private int tailPosition;

    public Snake(int tailPosition){
        this.tailPosition = tailPosition;
        tail[0] = tailPosition/10 + 1;
        tail[1] = tailPosition%10;
    }

    public int[] getTail() {
        return tail;
    }
}

class Ladder{
    private int[] bottom = new int[2];
    private int[] top = new int[2];
    private int bottomPosition;
    private int topPosition;

    public Ladder(int topPosition){
        this.topPosition = topPosition;
        top[0] = topPosition/10 + 1;
        top[1] = topPosition%10;
    }

    public int[] getBottom() {
        return bottom;
    }

    public int[] getTop() {
        return top;
    }
}
