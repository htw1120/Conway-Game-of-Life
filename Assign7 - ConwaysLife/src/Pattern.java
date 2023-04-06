
// Code partially developed by Dr. Curtis Dyreson of Utah State University
public class Pattern {
    protected boolean[][] currentPattern;
    public int getSizeX() {return this.currentPattern[0].length;}
    public int getSizeY() {
        return this.currentPattern.length;
    }

    public boolean getCell(int x, int y) {
        return this.currentPattern[y][x];
    }

}


