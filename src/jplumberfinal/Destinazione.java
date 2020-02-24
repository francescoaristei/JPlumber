package jplumberfinal;

public class Destinazione extends Tube {

    public Destinazione (int state){
        this.state = 0;
        this.tubeName = "Destinazione";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1)
                    this.tubeMatrix[i][j] = 1;
                else
                    this.tubeMatrix[i][j] = 0;

            }
        }
    }

    protected void rotate(){

    }

    protected boolean isMatchable(Tube tube){
        return true;
    }

    protected int[] pathResearchRow(int i, int j){
        int dim = 0;
        int[] rowResearch = new int[dim];
        if(j-1 >= 0 && j+1 < Grid.dimensione) {
            dim = 2;
            rowResearch = new int[dim];
            rowResearch[0] = i;
            rowResearch[1] = i;
        }
        else if(!(j-1 >= 0) && j+1 < Grid.dimensione) {
            dim = 1;
            rowResearch = new int[dim];
            rowResearch[0] = i;
        }
        else if(j-1 >= 0 && !(j+1 < Grid.dimensione)) {
            dim = 1;
            rowResearch = new int[dim];
            rowResearch[0] = i;
        }
        else if(!(j-1 >= 0) && !(j+1 < Grid.dimensione)) {
            dim = 0;
            rowResearch = new int[dim];
        }
        return rowResearch;
    }

    protected int[] pathResearchCols(int i, int j){
        int dim = 0;
        int[] colsResearch = new int[dim];
        if(j-1 >= 0 && j+1 < Grid.dimensione) {
            dim = 2;
            colsResearch = new int[dim];
            colsResearch[0] = j-1;
            colsResearch[1] = j+1;
        }
        else if(!(j-1 >= 0) && j+1 < Grid.dimensione) {
            dim = 1;
            colsResearch = new int[dim];
            colsResearch[0] = j+1;
        }
        else if(j-1 >= 0 && !(j+1 < Grid.dimensione)) {
            dim = 1;
            colsResearch = new int[dim];
            colsResearch[0] = j-1;
        }
        else if(!(j-1 >= 0) && !(j+1 < Grid.dimensione)) {
            dim = 0;
            colsResearch = new int[dim];
        }
        return colsResearch;
    }
}
