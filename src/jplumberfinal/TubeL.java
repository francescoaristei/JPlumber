package jplumberfinal;

public class TubeL extends Tube {

    public TubeL(int indexI, int indexJ, int state){
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.tubeName = "TubeL";
        this.state = state;

        if(this.state == 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==0 && j==1) || (i==1 && j==1) || (i==1 && j ==0))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 1){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==0 && j==1) || (i==1 && j==1) || (i==1 && j==2))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 2){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==1 && j==1) || (i==1 && j==2) || (i==2 && j==1))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 3){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==1 && j==0) || (i==1 && j==1) || (i==2 && j==1))
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
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==0 && j==1) || (i==1 && j==1) || (i==1 && j==2))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 1){
            this.state = 2;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if((i==1 && j==1) || (i==1 && j==2) || (i==2 && j==1))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 2) {
            this.state = 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 1 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 1))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
        else if(this.state == 3){
            this.state = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 0 && j == 1) || (i == 1 && j == 1) || (i == 1 && j == 0))
                        this.tubeMatrix[i][j] = 1;
                    else
                        this.tubeMatrix[i][j] = 0;
                }
            }
        }
    }

    protected int[] pathResearchRow(int i, int j) {
       int[] rowResearch = new int[4];
       rowResearch[0] = 0;
       rowResearch[1] = 0;
       rowResearch[2] = 0;
       rowResearch[3] = 0;

       if(this.state == 0){
           if(j-1 >= 0 && j+1 < Grid.dimensione)

       }
    }
}


