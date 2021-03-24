package jplumber.Logic;

// Level 2 of the game
public class Grid2 extends Grid {
    public Grid2(){
        super();
        this.grid = new Tube[DIMENSION][DIMENSION];
        for(int i = 0; i< DIMENSION; i++){
            for(int j = 0; j< DIMENSION; j++){
                this.grid[i][j] = new EmptyCell();
            }
        }
        this.win=29;
        this.nOfBranches=7;

        this.grid[2][0] = new Source(0);
        this.grid[2][1] = new TubeL(1);
        this.grid[3][1] = new TubeL(1);
        this.grid[0][2] = new TubeL(2);
        this.grid[1][2] = new TubeI(1);
        this.grid[2][2] = new TubeT(1);
        this.grid[3][2] = new TubeT(1);
        this.grid[4][2] = new TubeI(0);
        this.grid[5][2] = new TubeL(2);
        this.grid[0][3] = new TubeI(1);
        this.grid[2][3] = new TubeT(1);
        this.grid[3][3] = new TubeL(2);
        this.grid[4][3] = new TubeL(2);
        this.grid[5][3] = new TubeT(1);
        this.grid[0][4] = new TubeI(1);
        this.grid[2][4] = new TubeT(0);
        this.grid[3][4] = new TubeL(2);
        this.grid[4][4] = new TubeI(0);
        this.grid[5][4] = new TubeI(1);
        this.grid[0][5] = new TubeL(3);
        this.grid[1][5] = new TubeL(1);
        this.grid[2][5] = new TubeL(0);
        this.grid[3][5] = new TubeT(0);
        this.grid[4][5] = new TubeL(0);
        this.grid[5][5] = new TubeL(0);
        this.grid[0][6] = new TubeL(2);
        this.grid[1][6] = new TubeL(2);
        this.grid[2][6] = new TubeT(1);
        this.grid[3][6] = new TubeT(1);
        this.grid[4][6] = new TubeL(2);
        this.grid[0][7] = new TubeI(0);
        this.grid[2][7] = new TubeI(0);
        this.grid[4][7] = new TubeI(0);
        this.grid[0][8] = new TubeI(0);
        this.grid[2][8] = new TubeT(3);
        this.grid[3][8] = new TubeI(1);
        this.grid[4][8] = new TubeL(0);
        this.grid[0][9] = new TubeL(2);
        this.grid[1][9] = new TubeL(2);
        this.grid[2][9] = new TubeL(0);
        this.grid[1][10] = new Destination(0);

    }
}
