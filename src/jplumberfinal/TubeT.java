package jplumberfinal;

public class TubeT extends Tube {

    public TubeT(int indexI, int indexJ, int state){
        this.indexI = indexI;
        this.indexJ = indexJ;
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


}
