package jplumber.Logic;


// Level 4 of the game
public class Grid4 extends Grid {
    public Grid4(){
        super();
        this.grid = new Tube[DIMENSION][DIMENSION];
        for(int i = 0; i< DIMENSION; i++){
            for(int j = 0; j< DIMENSION; j++){
                this.grid[i][j] = new EmptyCell();
            }
        }
        this.win=23;
        this.nOfBranches=20;

        this.grid[0][0] = new Source(0);
        this.grid[0][1] = new TubeL(3);
        this.grid[0][2] = new TubeL(3);
        this.grid[0][3] = new TubeL(1);
        this.grid[0][5] = new TubeL(3);
        this.grid[0][6] = new TubeT(3);
        this.grid[0][8] = new TubeL(0);
        this.grid[1][1] = new TubeL(1);
        this.grid[1][2] = new TubeL(0);
        this.grid[1][3] = new TubeL(2);
        this.grid[1][5] = new TubeL(2);
        this.grid[1][6] = new TubeL(3);
        this.grid[1][7] = new TubeL(0);
        this.grid[1][8] = new TubeT(2);
        this.grid[1][9] = new TubeL(0);
        this.grid[2][1] = new TubeL(3);
        this.grid[2][2] = new TubeL(1);
        this.grid[2][3] = new TubeL(0);
        this.grid[2][4] = new TubeL(0);
        this.grid[2][5] = new TubeT(2);
        this.grid[2][6] = new TubeL(1);
        this.grid[2][7] = new TubeL(1);
        this.grid[2][8] = new TubeL(1);
        this.grid[2][9] = new TubeI(1);
        this.grid[3][1] = new TubeI(0);
        this.grid[3][3] = new TubeL(2);
        this.grid[3][4] = new TubeT(0);
        this.grid[3][5] = new TubeL(1);
        this.grid[3][6] = new TubeI(0);
        this.grid[3][7] = new TubeL(0);
        this.grid[3][8] = new TubeL(3);
        this.grid[3][9] = new TubeL(0);
        this.grid[4][1] = new TubeL(2);
        this.grid[4][2] = new TubeT(1);
        this.grid[4][3] = new TubeL(1);
        this.grid[4][4] = new TubeI(1);
        this.grid[4][6] = new TubeL(0);
        this.grid[4][8] = new TubeL(0);
        this.grid[4][9] = new TubeL(0);
        this.grid[5][1] = new TubeL(3);
        this.grid[5][2] = new TubeI(1);
        this.grid[5][3] = new TubeI(1);
        this.grid[5][4] = new TubeT(1);
        this.grid[5][5] = new TubeT(1);
        this.grid[5][6] = new TubeL(1);
        this.grid[5][8] = new TubeL(3);
        this.grid[5][9] = new TubeI(0);
        this.grid[5][10] = new Destination(0);

    }
}


