package jplumber.Logic;

public class Grid {


    // Matrix of tubes which represent the grid of the game
    protected Tube[][] grid;


    // Dimension of the grid
    public static final int DIMENSION = 11;


    // Needed to determine the number of execution of the waterPath() method every time a tube rotate
    protected int nOfBranches;


    // It represent the number of tubes present in the right path from the source to the destination
    protected int win;


    // Needed to not make the water flow backward in already scanned tubes via waterPath() method
    protected boolean[][] prev;


    // Needed to distinguish the branch where to pass with the waterPath() method when a T-tube is reached
    protected int[][] branchCount;


    // Needed to count the number of tubes connected from the source, when the number is equal to variable win, the player win the level
    protected boolean[][] path;


    public Grid() {
        this.prev = new boolean[DIMENSION][DIMENSION];
        this.branchCount = new int[DIMENSION][DIMENSION];
        this.path = new boolean[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                prev[i][j] = false;
            }
        }

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                branchCount[i][j] = 0;
            }
        }

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                path[i][j] = false;
            }
        }
    }



    // Return the position of the source inside the grid
    public int[] findSource() {
        int[] sourceIndex = new int[2];
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if ("Source".equals(this.grid[i][j].getTubeName())) {
                    sourceIndex[0] = i;
                    sourceIndex[1] = j;
                }
            }
        }
        return sourceIndex;
    }


    // Recursive method called every time a tube is rotated, needed to build the matrix of boolean variable "path", with whom it
    // is established if a correct path from source to destination has been discovered
    public void waterPath(int i, int j) {
        int tempRow;
        int tempCols;

        if ("Destination".equals(this.grid[i][j].getTubeName())) {
            this.prev[i][j] = true;
            this.path[i][j] = true;
        } else if (!(this.gridMatch(i, j))) {
            this.prev[i][j] = true;
        } else {
            this.prev[i][j] = true;
            this.path[i][j] = true;
            if ("TubeT".equals(this.grid[i][j].getTubeName())) {
                tempRow = this.gridRowT(i, j);
                tempCols = this.gridColsT(i, j);
                this.branchCount[tempRow][tempCols]++;

            } else {
                tempRow = this.gridRow(i, j);
                tempCols = this.gridCols(i, j);
                this.branchCount[tempRow][tempCols]++;
            }
            waterPath(tempRow, tempCols);
        }
    }



    // Control if the tube in position (i,j) is connected with some other tube around it, if so return true, otherwise false
    public boolean gridMatch(int i, int j) {
        boolean match = false;
        int count = 0;

        for (int x = 0; x < this.grid[i][j].tubeRow(i, j).length; x++) {
            if (this.grid[i][j].tubeMatch
                    (this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]], i, j,
                            this.grid[i][j].tubeRow(i, j)[x], this.grid[i][j].tubeCols(i, j)[x]))
                count++;
        }

        if (("Source".equals(this.grid[i][j].getTubeName()) && count == 1) || (!("TubeT".equals(this.grid[i][j].getTubeName())) && count == 2)
                || ("TubeT".equals(this.grid[i][j].getTubeName()) && count == 3))
            match = true;

        return match;
    }


    // Return the row of the grid where the next tube I or L in which "waterPath()" method will be called
    public int gridRow(int i, int j) {
        int row = 0;
        if ("Source".equals(this.grid[i][j].getTubeName())) {
            for (int x = 0; x < this.grid[i][j].tubeRow(i, j).length; x++) {
                if ("TubeI".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "TubeT".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "TubeL".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "Destination".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()))
                    row = this.grid[i][j].tubeRow(i, j)[x];
            }
        } else {
            for (int x = 0; x < this.grid[i][j].tubeRow(i, j).length; x++) {
                if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]]))
                    row = this.grid[i][j].tubeRow(i, j)[x];
            }
        }

        return row;
    }


    // Return the column of the grid where the next tube I or L in which "waterPath()" method will be called
    public int gridCols(int i, int j) {
        int cols = 0;
        if ("Source".equals(this.grid[i][j].getTubeName())) {
            for (int x = 0; x < this.grid[i][j].tubeCols(i, j).length; x++) {
                if ("TubeI".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "TubeT".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "TubeL".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName()) ||
                        "Destination".equals(this.grid[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]].getTubeName())) {
                    cols = this.grid[i][j].tubeCols(i, j)[x];
                }
            }
        } else {
            for (int x = 0; x < this.grid[i][j].tubeCols(i, j).length; x++) {
                if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]]))
                    cols = this.grid[i][j].tubeCols(i, j)[x];
                else {
                    this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]] = false;
                }
            }
        }
        return cols;
    }


    // Return the row of the grid where the next tube T in which "waterPath()" method will be called
    public int gridRowT(int i, int j) {
        int cols = this.grid[i][j].tubeRow(i, j)[0];
        int tempRow = 0;

        for (int x = 0; x < this.grid[i][j].tubeRow(i, j).length; x++) {
            if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]])) {
                cols = this.grid[i][j].tubeRow(i, j)[x];
                tempRow = x;
            }
        }
        for (int x = 0; x < this.grid[i][j].tubeRow(i, j).length; x++) {
            if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]])) {
                if (this.branchCount[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]]
                        < this.branchCount[this.grid[i][j].tubeRow(i, j)[tempRow]][this.grid[i][j].tubeCols(i, j)[tempRow]])
                    cols = this.grid[i][j].tubeRow(i, j)[x];
            }
        }
        return cols;
    }



    // Return the column of the grid where the next T in which "waterPath()" method will be called
    public int gridColsT(int i, int j) {
        int cols = this.grid[i][j].tubeCols(i, j)[0];
        int tempCols = 0;

        for (int x = 0; x < this.grid[i][j].tubeCols(i, j).length; x++) {
            if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]])) {
                cols = this.grid[i][j].tubeCols(i, j)[x];
                tempCols = x;
            }
        }
        for (int x = 0; x < this.grid[i][j].tubeCols(i, j).length; x++) {
            if (!(this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]])) {
                if (this.branchCount[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]]
                        < this.branchCount[this.grid[i][j].tubeRow(i, j)[tempCols]][this.grid[i][j].tubeCols(i, j)[tempCols]])
                    cols = this.grid[i][j].tubeCols(i, j)[x];
            } else {
                this.prev[this.grid[i][j].tubeRow(i, j)[x]][this.grid[i][j].tubeCols(i, j)[x]] = false;
            }
        }
        return cols;
    }



    // Called every time a tube is rotated, executes the waterPath() method a number of times equal to variable "nOfBranches"
    // At this point counts how many cells of the path grid are equal to true, if this number is equal to variable "win" then
    // the correct path is found
    public boolean correctFlow() {
        boolean waterpath = false;
        int count = 0;

        for (int i = 0; i < this.nOfBranches; i++) {
            this.waterPath(this.findSource()[0], this.findSource()[1]);
            for (int x = 0; x < DIMENSION; x++) {
                for (int y = 0; y < DIMENSION; y++) {
                    this.prev[x][y] = false;
                }
            }
        }

        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                if (this.path[x][y])
                    count++;
            }
        }

        if (count == this.win)
            waterpath = true;

        for (int x = 0; x < DIMENSION; x++) {
            for (int y = 0; y < DIMENSION; y++) {
                if (this.path[x][y])
                    this.path[x][y] = false;
            }
        }
        return waterpath;
    }




    // Return a matrix of integer of dimension equal to the grid, having cells with value 1 where there is a tube, 0 otherwise
    public int[][] oneGrid() {
        int[][] onesPath = new int[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if ("TubeI".equals(this.grid[i][j].getTubeName()) ||
                        "TubeT".equals(this.grid[i][j].getTubeName()) ||
                        "TubeL".equals(this.grid[i][j].getTubeName()) ||
                        "Source".equals(this.grid[i][j].getTubeName()) ||
                        "Destination".equals(this.grid[i][j].getTubeName()))
                    onesPath[i][j] = 1;
                else
                    onesPath[i][j] = 0;
            }
        }
        return onesPath;
    }

    public boolean[][] getCorrectFlow(){
        return this.path;
    }
}
