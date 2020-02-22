package jplumberfinal;

public class TubeI extends Tube {

    protected TubeI(int indexI, int indexJ, int state){
    this.indexI = indexI;
    this.indexJ = indexJ;
    this.tubeName = "TubeI";
    this.state = state;

    if(state == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;

                }
            }
        }
        else if(state == 1){
            for(int i = 0; i<3;i++){
                for(int j = 0;j<3;j++){
                    if(j==1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
    }

    protected void rotate(){
        if(this.state ==0){
            this.state =1;
            for(int i = 0; i<3;i++){
                for(int j = 0;j<3;j++){
                    if(j==1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state ==1){
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
    }

    protected boolean isMatchable(Tube tube){
        boolean match = false;
        if(this.state == 0){
            if(tube.tubeMatrix[1][2] == 1)
                match = true;
        }
        else if(this.state == 1){
            if(tube.tubeMatrix[1][0] == 1)
                match = true;
        }
        return match;
    }

    protected int[] pathResearchRow(int i, int j){
        int[] rowResearch = new int[2];
        rowResearch[0] = 0;
        rowResearch[1] = 0;
        if(this.state == 0){
            if(j-1 >= 0 && j+1 < Grid.dimensione) {
                rowResearch[0] = i;
                rowResearch[1] = i;
            }
        }
        else if(this.state == 1){
            if(i-1 >= 0 && i+1 < Grid.dimensione){
                rowResearch[0] = i-1;
                rowResearch[1] = i+1;
            }
        }
        return rowResearch;
    }

    protected int[] patchResearchCols(int i, int j){
        int[] colsResearch = new int[2];
        colsResearch[0] = 0;
        colsResearch[1] = 0;
        if(this.state == 0){
            if(j-1 >= 0 && j+1 < Grid.dimensione) {
                colsResearch[0] = j-1;
                colsResearch[1] = j+1;
            }
        }
        else if(this.state == 1){
            if(i-1 >= 0 && i+1 < Grid.dimensione){
                colsResearch[0] = j;
                colsResearch[1] = j;
            }
        }
        return colsResearch;
    }
}
