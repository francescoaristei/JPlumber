package jplumber.Logic;

// Level 3 of the game
public class Grid3 extends Grid {
    public Grid3(){
        super();
        this.grid = new Tube[DIMENSION][DIMENSION];
        for(int i = 0; i< DIMENSION; i++){
            for(int j = 0; j< DIMENSION; j++){
                this.grid[i][j] = new EmptyCell();
            }
        }
        this.win = 27;
        this.nOfBranches=5;

        this.grid[0][1] = new TubeL(2);
        this.grid[0][2] = new TubeI(1);
        this.grid[0][3] = new TubeI(1);
        this.grid[0][4] = new TubeT(2);
        this.grid[0][5] = new TubeI(1);
        this.grid[0][6] = new TubeI(1);
        this.grid[0][7] = new TubeI(1);
        this.grid[0][8] = new TubeI(1);
        this.grid[0][9] = new TubeI(1);
        this.grid[0][10] = new Destination(0);
        this.grid[1][0] = new Source(0);
        this.grid[1][1] = new TubeL(1);
        this.grid[1][2] = new TubeL(3);
        this.grid[1][3] = new TubeL(3);
        this.grid[1][4] = new TubeI(1);
        this.grid[1][5] = new TubeL(3);
        this.grid[1][6] = new TubeL(3);
        this.grid[1][7] = new TubeL(3);
        this.grid[1][8] = new TubeI(1);
        this.grid[2][2] = new TubeL(0);
        this.grid[2][3] = new TubeI(0);
        this.grid[2][4] = new TubeT(2);
        this.grid[2][5] = new TubeI(1);
        this.grid[2][6] = new TubeL(3);
        this.grid[2][7] = new TubeI(0);
        this.grid[2][8] = new TubeL(0);
        this.grid[3][1] = new TubeL(3);
        this.grid[3][2] = new TubeI(1);
        this.grid[3][3] = new TubeL(1);
        this.grid[3][4] = new TubeL(0);
        //this.grid[3][5] = new TubeI(1);
        this.grid[3][6] = new TubeI(0);
        //this.grid[3][7] = new TubeI(0);
        this.grid[3][8] = new TubeL(3);
        this.grid[4][1] = new TubeL(3);
        this.grid[4][2] = new TubeI(0);
        this.grid[4][3] = new TubeI(0);
        this.grid[4][4] = new TubeT(0);
        this.grid[4][5] = new TubeL(2);
        this.grid[4][6] = new TubeI(0);
        this.grid[5][2] = new TubeL(1);
        this.grid[5][3] = new TubeI(1);
        this.grid[5][4] = new TubeI(0);
        this.grid[5][5] = new TubeI(1);
        this.grid[5][6] = new TubeL(0);

    }
}





