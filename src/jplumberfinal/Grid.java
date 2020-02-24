package jplumberfinal;

public class Grid {
    protected Tube[][] grid;
    protected int level;
    protected static final int dimensione = 100;
    protected boolean[][] path;

    public Grid(int level) {
        this.grid = new Tube[dimensione][dimensione];
        this.path = new boolean[dimensione][dimensione];
        this.level = level;

        for (int i = 0; i < dimensione; i++) {
            for (int j = 0; j < dimensione; j++) {
                this.path[i][j] = false;
            }
        }

        /*
        popolo la griglia con i tubi
         */
        if (this.level == 1){
            this.grid[0][0] = new Sorgente();
        }
            /*
            to do
             */
         else if (this.level == 2){
             this.grid[1][1] = new Sorgente();
        }
             /*
             to do
              */
          else if (this.level == 3){
              this.grid[3][1] = new Sorgente();
        }
              /*
              to do
               */

    }

    protected int[] findSource() {
        int[] sourceIndex = new int[2];
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.grid[i][j].getTubeName() == "Sorgente") {
                    sourceIndex[0] = i;
                    sourceIndex[1] = j;
                }
            }
        }
        return sourceIndex;
    }

    protected void waterPath(int i, int j) {
        int tempRow = i;
        int tempCols = j;
        if (this.grid[i][j].getTubeName() == "Destinazione")
            this.path[i][j] = true;
        else {
            for (int t = 0; t < this.grid[i][j].pathResearchRow(i, j).length; i++) {
                for (int z = 0; z < this.grid[i][j].pathResearchCols(i, j).length; z++) {
                    if (this.grid[this.grid[i][j].pathResearchRow(i, j)[t]][this.grid[i][j].pathResearchCols(i, j)[z]] != null) {
                        if (this.grid[i][j].pathResearchRow(i, j)[t] != tempRow && this.grid[i][j].pathResearchCols(i, j)[z] != tempCols) {
                            if (this.grid[i][j].isMatchable(this.grid[t][z])) {
                                this.path[t][z] = true;
                                tempRow = t;
                                tempCols = z;
                                waterPath(t, z);
                            }
                            else {
                                for (int x = 0; x < dimensione; x++) {
                                    for (int y = 0; y < dimensione; y++) {
                                        this.path[i][j] = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

        /*
        Tale metodo andrà attivato dalla view ogni volta che si ruota un tubo
         */

    protected boolean searchRowWaterPath() {
        boolean waterPath = false;
        this.waterPath(this.findSource()[0], this.findSource()[1]);
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.grid[i][j].getTubeName() == "Destinazione")
                    if (this.path[i][j] == true)
                        waterPath = true;
            }
        }

        return waterPath;
    }

    protected int[] rowIndexWaterPath() {
        int dim = 0;
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.path[i][j] == true)
                    dim++;
            }
        }
        int[] rowWaterPath = new int[dim];
        int count = 0;
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.path[i][j] == true)
                    rowWaterPath[count] = i;
                count++;
            }
        }
        return rowWaterPath;
    }

    protected int[] colsIndexWaterPath() {
        int dim = 0;
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.path[i][j] == true)
                    dim++;
            }
        }
        int[] colsWaterPath = new int[dim];
        int count = 0;
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.path[i][j] == true)
                    colsWaterPath[count] = j;
                count++;
            }
        }
        return colsWaterPath;
    }
}

