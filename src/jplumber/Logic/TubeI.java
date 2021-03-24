package jplumber.Logic;

// I tube
public class TubeI extends Tube {


    TubeI(int state){
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
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
    }

    public int[][] getTubeMatrix(){
        return this.tubeMatrix;
    }

    public void rotate(){
        if(this.state == 0){
            this.state = 1;
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else {
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

    public boolean tubeMatch(Tube tube, int i, int j, int x, int y){
        boolean match = false;
        if(this.state == 0) {
            if (j > y ) {
                if (tube.tubeMatrix[1][2] == 1)
                    match = true;
            }
            else
                if(tube.tubeMatrix[1][0] == 1) {
                    match = true;
                }
        }
        else if(this.state == 1) {
            if (i > x) {
                if (tube.tubeMatrix[2][1] == 1)
                    match = true;
            }
            else
                if (tube.tubeMatrix[0][1] == 1) {
                match = true;
            }
        }
        return match;
    }

    public int[] tubeRow(int i, int j){
        int dim = 0;
        int[] rowResearch = new int[dim];
        if(this.state == 0){

            if(j == 0){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }

            else if(j == Grid.DIMENSION -1) {
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }

            else{
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i;
                rowResearch[1] = i;
            }

        }

        else if(this.state == 1){

            if(i == 0){
            dim = 1;
            rowResearch = new int[dim];
            rowResearch[0] = i+1;
            }

            else if(i == Grid.DIMENSION -1){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
            }

            else {
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i-1;
            }
        }
        return rowResearch;
    }

    public int[] tubeCols(int i, int j){
        int dim = 0;
        int[] colsResearch = new int[dim];

        if(this.state == 0){

            if(j == 0) {
            dim = 1;
            colsResearch = new int[dim];
            colsResearch[0] = j+1;
            }

            else if(j == Grid.DIMENSION -1){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
            }

            else {
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j+1;
                colsResearch[1] = j-1;
            }
        }

        else if(this.state == 1){

            if(i == 0){
            dim = 1;
            colsResearch = new int[dim];
            colsResearch[0] = j;
            }

            else if(i == Grid.DIMENSION -1){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }

            else {
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j;
            }
        }
        return colsResearch;
    }
}
