package sample;

public class Cell {

    private boolean hasSnakeMouth;
    private boolean hasSnakeTail;
    private boolean hasLadderTop;
    private boolean hasLadderBottom;
    private final int[] coordinate;
    private final int position;

    Cell(int position, int[] coordinate){
        this.position = position;
        this.coordinate = coordinate;
    }


    public boolean isHasSnakeMouth() {
        return hasSnakeMouth;
    }

    public void setHasSnakeMouth(boolean hasSnakeMouth) {
        this.hasSnakeMouth = hasSnakeMouth;
    }

    public boolean isHasSnakeTail() {
        return hasSnakeTail;
    }

    public void setHasSnakeTail(boolean hasSnakeTail) {
        this.hasSnakeTail = hasSnakeTail;
    }

    public boolean isHasLadderTop() {
        return hasLadderTop;
    }

    public void setHasLadderTop(boolean hasLadderTop) {
        this.hasLadderTop = hasLadderTop;
    }

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
}
