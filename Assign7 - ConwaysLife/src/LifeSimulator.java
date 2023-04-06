public class LifeSimulator {
    boolean[][] booleanArray;
    int xSize;
    int ySize;

    public LifeSimulator(int sizeX, int sizeY) {
        this.xSize = sizeX;
        this.ySize = sizeY;
        this.booleanArray = new boolean[this.xSize][this.ySize];
    }
    public int getSizeX() {return xSize;}
    public int getSizeY() {return ySize;}
    public int deadOrAlive(int x, int y) {
        int counter = 0;
//      Check to make sure the right and upper right neighbors are on the screen.
        if (x+1 < this.getSizeX()) {
            if (getCell(x + 1, y)) {
                counter += 1;
            }
            if (y+1 < this.getSizeY()){
                if (getCell(x + 1, y + 1)) {
                    counter += 1;
                }
            }
        }
//      Check to make sure that the upper and upper left neighbors are on the screen.
            if (y+1 < this.getSizeY()) {
                if (getCell(x, y+1)) {
                    counter += 1;
                }
                if (x-1 >= 0) {
                    if (getCell(x-1, y+1)) {
                        counter += 1;
                    }
                }
            }
//      Check to make sure that the left and lower left neighbors are on the screen.
            if (x-1 >= 0) {
                if (getCell(x - 1, y)) {
                    counter += 1;
                }
                if (y-1 >= 0) {
                    if (getCell(x - 1, y - 1)) {
                        counter += 1;
                    }
                }
            }
//      Check to make sure that the lower and lower right neighbors are on the screen
                if (y-1 >= 0) {
                    if (getCell(x, y - 1)) {
                        counter += 1;
                    }
                    if (x + 1 < getSizeX()) {
                        if (getCell(x + 1, y - 1)) {
                            counter += 1;
                        }
                    }
                }
        return counter;
    }

    public boolean getCell(int x, int y) {
        return this.booleanArray[x][y];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int row = 0; row < pattern.getSizeY(); row++) {
            for (int column = 0; column < pattern.getSizeX(); column++) {
                if (startX + column <= getSizeX() && startY + row <= getSizeY()){
                    this.booleanArray[startX + column][startY + row] = pattern.getCell(column, row);
                }
            }
        }
    }
    public void update() {
        boolean[][] updatedArray = new boolean[getSizeX()][getSizeY()];
        for (int row = 0; row < getSizeX(); row++) {
            for (int column = 0; column < getSizeY(); column++) {
                    if (deadOrAlive(row, column) < 2) {
                        updatedArray[row][column] = false;
                    }
                    if (deadOrAlive(row, column) ==2 && this.booleanArray[row][column]) {
                        updatedArray[row][column] = true;
                    }
                    if (deadOrAlive(row, column) == 3) {
                        updatedArray[row][column] = true;
                    }
                    if (deadOrAlive(row, column) > 3) {
                        updatedArray[row][column] = false;
                }
            }
        }
        this.booleanArray = updatedArray;
    }


};
