package jplumberfinal;

public class Sorgente extends Tube {

    public Sorgente(){
        this.tubeName = "Sorgente";
        this.state = 0;
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

    protected boolean isMatchable (Tube tube){
        boolean match = false;
            if(tube.tubeMatrix[1][2] == 1 || tube.tubeMatrix[1][0] == 1)
                match = true;
        else if(this.state == 1){
            if(tube.tubeMatrix[0][1] == 1 || tube.tubeMatrix[2][1] == 1)
                match = true;
        }
        return match;
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
