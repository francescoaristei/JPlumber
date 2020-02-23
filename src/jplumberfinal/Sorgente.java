package jplumberfinal;

public class Sorgente extends Tube {

    public Sorgente(int indexI, int indexJ){
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
}
