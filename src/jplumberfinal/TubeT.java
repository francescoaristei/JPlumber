package jplumberfinal;

public class TubeT extends Tube {

    public TubeT(int state){
        this.state = state;
        this.tubeName = "TubeT";

        if(this.state == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 0 && j == 1) || i == 1)
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 1){
            for(int i = 0; i<3 ; i++){
                for(int j = 0; j<3; j++){
                    if(i==0 || (i==2 && j==1))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;

                }
            }
        }
        else if(this.state == 2){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1 || (i==1 && j==0))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 3){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1 || (i==1 && j==2))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
    }

    protected void rotate(){
        if(this.state == 0){
            this.state = 1;
            for(int i = 0; i<3 ; i++){
                for(int j = 0; j<3; j++){
                    if(i==0 || (i==2 && j==1))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;

                }
            }
        }

        if(this.state == 1){
            this.state = 2;
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1 || (i==1 && j==0))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }

        if(this.state == 2){
            this.state = 3;
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    if(j==1 || (i==1 && j==2))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }

        if(this.state == 3){
            this.state = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 0 && j == 1) || i == 1)
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
            if(tube.tubeMatrix[0][1] == 1 || tube.tubeMatrix[1][0] == 1 || tube.tubeMatrix[1][2] == 1)
                match = true;
        }
        else if(this.state == 1){
            if(tube.tubeMatrix[1][0] == 1 || tube.tubeMatrix[1][2] == 1 || tube.tubeMatrix[2][1] == 1)
                match = true;
        }
        else if(this.state == 2){
            if(tube.tubeMatrix[0][1] == 1 || tube.tubeMatrix[1][0] == 1 || tube.tubeMatrix[2][1] == 1)
                match = true;
            }
        else if(this.state == 3){
            if(tube.tubeMatrix[0][1] == 1 || tube.tubeMatrix[1][2] == 1 || tube.tubeMatrix[2][1] == 1)
                match = true;
        }
        return match;
    }

    protected int[] pathResearchRow(int i, int j){
        int dim = 0;
        int[] rowResearch = new int[dim];
        if(this.state == 0){
            if(i-1 >= 0 && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 3;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i;
                rowResearch[2] = i;
            }
            else if(!(i-1 >= 0) && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i;
                rowResearch[1] = i;
            }
            else if(i-1 >= 0 && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i;
            }
            else if(i-1 >= 0 && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i;
            }
            else if(!(i-1 >= 0) && !(j-1 >=0) && j+1 < Grid.dimensione){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(!(i-1 >= 0) && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(i-1 >= 0 && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
            }
            else if(!(i-1 >= 0) && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 0;
                rowResearch = new int[dim];
            }
        }
        else if(this.state == 1){
            if(i+1 < Grid.dimensione && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 3;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i;
                rowResearch[2] = i;
            }
            else if(!(i+1 < Grid.dimensione) && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i;
                rowResearch[1] = i;
            }
            else if(i+1 < Grid.dimensione && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i;
            }
            else if(i+1 < Grid.dimensione && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i;
            }
            else if(!(i+1 < Grid.dimensione) && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(!(i+1 < Grid.dimensione) && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(i+1 < Grid.dimensione && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
            }
            else if(!(i+1 < Grid.dimensione) && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 0;
                rowResearch = new int[dim];
            }
        }
        else if(this.state == 2){
            if(i-1 >= 0 && i+1 < Grid.dimensione && j-1 >= 0){
                dim = 3;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i+1;
                rowResearch[2] = i;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && j-1 >= 0){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && j-1 >= 0){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i;
            }
            else if(i-1 >= 0 && i+1 < Grid.dimensione && !(j-1 >= 0)){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i+1;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && j-1 >= 0){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && !(j-1 >= 0)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && !(j-1 >= 0)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && !(j-1 >= 0)){
                dim = 0;
                rowResearch = new int[dim];
            }
        }
        else if(this.state == 3){
            if(i-1 >= 0 && i+1 < Grid.dimensione && j+1 < Grid.dimensione){
                dim = 3;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i+1;
                rowResearch[2] = i;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
                rowResearch[1] = i;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && j+1 < Grid.dimensione){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[0] = i;
            }
            else if(i-1 >= 0 && i+1 < Grid.dimensione && !(j+1 < Grid.dimensione)){
                dim = 2;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
                rowResearch[1] = i+1;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && j+1 < Grid.dimensione){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i+1;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && !(j+1 < Grid.dimensione)){
                dim = 1;
                rowResearch = new int[dim];
                rowResearch[0] = i-1;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && !(j+1 < Grid.dimensione)){
                dim = 0;
                rowResearch = new int[dim];
            }
        }
        return rowResearch;
    }

    protected int[] pathResearchCols(int i, int j){
        int dim = 0;
        int[] colsResearch = new int[dim];
        if(this.state == 0){
            if(i-1 >= 0 && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 3;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
                colsResearch[2] = j+1;
            }
            else if(!(i-1 >= 0) && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
                colsResearch[1] = j+1;
            }
            else if(i-1 >= 0 && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j+1;
            }
            else if(i-1 >= 0 && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
            }
            else if(!(i-1 >= 0) && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j+1;
            }
            else if(!(i-1 >= 0) && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
            }
            else if(i-1 >= 0 && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(!(i-1 >= 0) && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 0;
                colsResearch = new int[dim];
            }
        }
        else if(this.state == 1){
            if(i+1 < Grid.dimensione && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 3;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
                colsResearch[2] = j+1;
            }
            else if(!(i+1 < Grid.dimensione) && j-1 >= 0 && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
                colsResearch[1] = j+1;
            }
            else if(i+1 < Grid.dimensione && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j+1;
            }
            else if(i+1 < Grid.dimensione && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
            }
            else if(!(i+1 < Grid.dimensione) && !(j-1 >= 0) && j+1 < Grid.dimensione){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j+1;
            }
            else if(!(i+1 < Grid.dimensione) && j-1 >= 0 && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
            }
            else if(i+1 < Grid.dimensione && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(!(i+1 < Grid.dimensione) && !(j-1 >= 0) && !(j+1 < Grid.dimensione)){
                dim = 0;
                colsResearch = new int[dim];
            }
        }
        else if(this.state == 2){
            if(i-1 >= 0 && i+1 < Grid.dimensione && j-1 >= 0){
                dim = 3;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j;
                colsResearch[2] = j-1;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && j-1 >= 0){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && j-1 >= 0){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j-1;
            }
            else if(i-1 >= 0 && i+1 < Grid.dimensione && !(j-1 >= 0)){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && j-1 >= 0){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j-1;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && !(j-1 >= 0)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && !(j-1 >= 0)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && !(j-1 >= 0)){
                dim = 0;
                colsResearch = new int[dim];
            }
        }
        else if(this.state == 3){
            if(i-1 >= 0 && i+1 < Grid.dimensione && j+1 < Grid.dimensione){
                dim = 3;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j;
                colsResearch[2] = j+1;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j+1;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && j+1 < Grid.dimensione){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[0] = j+1;
            }
            else if(i-1 >= 0 && i+1 < Grid.dimensione && !(j+1 < Grid.dimensione)){
                dim = 2;
                colsResearch = new int[dim];
                colsResearch[0] = j;
                colsResearch[1] = j;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && j+1 < Grid.dimensione){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j+1;
            }
            else if(!(i-1 >= 0) && i+1 < Grid.dimensione && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(i-1 >= 0 && !(i+1 < Grid.dimensione) && !(j+1 < Grid.dimensione)){
                dim = 1;
                colsResearch = new int[dim];
                colsResearch[0] = j;
            }
            else if(!(i-1 >= 0) && !(i+1 < Grid.dimensione) && !(j+1 < Grid.dimensione)){
                dim = 0;
                colsResearch = new int[dim];
            }
        }
        return colsResearch;
    }
}
