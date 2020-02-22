package jplumberfinal;

public class Grid {
    protected Tube[][] grid;
    protected int livello;
    protected static final int dimensione = 100;
    protected boolean[][] path;

    public Grid(int livello){
        this.grid = new Tube[dimensione][dimensione];
        this.path = new boolean[dimensione][dimensione];
        this.livello = livello;

        for(int i = 0; i<dimensione; i++){
            for(int j = 0; j<dimensione; j++){
                this.path[i][j] = false;
            }
        }

        /*
        popolo la griglia con i tubi
         */
        if(this.livello == 1)
            /*
            to do
             */
         else if(this.livello == 2)
             /*
             to do
              */
          else if(this.livello == 3)
              /*
              to do
               */

    }

    protected int[] findSource(){
        int[] sourceIndex = new int[2];
        for(int i = 0; i<this.dimensione; i++){
            for(int j = 0; j<this.dimensione; j++){
                if(this.grid[i][j].getTubeName() == "Sorgente") {
                    sourceIndex[0] = i;
                    sourceIndex[1] = j;
                }
            }
        }
        return sourceIndex;
    }

    protected void waterPath(int i, int j){
        int tempRow = i;
        int tempCols = j;
        if(this.grid[i][j].getTubeName() == "Destinazione")
            this.path[i][j] = true;
        else{
            for(int t = 0; t<this.grid[i][j].pathResearchRow(i,j).length; i++){
                for(int z = 0; z<this.grid[i][j].pathResearchCols(i,j).length; z++){
                    if(this.grid[this.grid[i][j].pathResearchRow(i,j)[t]][this.grid[i][j].pathResearchCols(i,j)[z]] != null){
                        if(this.grid[i][j].pathResearchRow(i,j)[t] != tempRow && this.grid[i][j].pathResearchCols(i,j)[z] != tempCols){
                            if(this.grid[i][j].isMatchable(this.grid[t][z])) {
                                this.path[t][z] = true;
                                tempRow = t;
                                tempCols = z;
                                waterPath(t, z);
                            }
                         else{
                                for(int x = 0; x<dimensione; x++){
                                    for(int y = 0; y<dimensione; y++){
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







}
