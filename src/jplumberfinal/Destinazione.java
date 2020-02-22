package jplumberfinal;

public class Destinazione extends Tube {

    public Destinazione (int indexI, int indexJ, int state){
        this.indexI = indexI;
        this.indexJ = indexJ;
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
}
