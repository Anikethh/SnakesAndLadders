package sample;

public class Cell {

    private boolean hasSnakeMouth;
    private boolean hasSnakeTail;
    private boolean hasLadderTop;
    private boolean hasLadderBottom;
    private final int[] coordinate;
    private final int position;
    private Snake snake;
    private Ladder ladder;

    Cell(int position, int[] coordinate){
        this.position = position;
        this.coordinate = coordinate;
    }

    public void createSnake(Snake newSnake){
        this.snake = newSnake;
    }

    public void createLadder(Ladder newLadder){
        this.ladder = ladder;
    }

    public boolean isHasSnakeMouth() {
        return hasSnakeMouth;
    }

    public void setHasSnakeMouth(boolean hasSnakeMouth) {
        this.hasSnakeMouth = hasSnakeMouth;
    }

//    public boolean isHasSnakeTail() {
//        return hasSnakeTail;
//    }
//
//    public void setHasSnakeTail(boolean hasSnakeTail) {
//        this.hasSnakeTail = hasSnakeTail;
//    }
//
//    public boolean isHasLadderTop() {
//        return hasLadderTop;
//    }
//
//    public void setHasLadderTop(boolean hasLadderTop) {
//        this.hasLadderTop = hasLadderTop;
//    }

    public boolean isHasLadderBottom() {
        return hasLadderBottom;
    }

    public void setHasLadderBottom(boolean hasLadderBottom) {
        this.hasLadderBottom = hasLadderBottom;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public int getPosition() {
        return position;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
