package jplumber.Logic;

public class Grid1 extends Grid {


    // Level 1 of the game
    public Grid1(){

        super();
        this.grid = new Tube[DIMENSION][DIMENSION];
        for(int i = 0; i< DIMENSION; i++){
            for(int j = 0; j< DIMENSION; j++){
                this.grid[i][j] = new EmptyCell();
            }
        }


        this.win = 21;
        this.nOfBranches = 3;


        this.grid[3][0] = new Source(0);
        this.grid[3][1] = new TubeL(0);
        this.grid[2][1] = new TubeL(2);
        this.grid[1][1] = new TubeL(1);
        this.grid[0][1] = new TubeL(0);
        this.grid[0][2] = new TubeI(0);
        this.grid[1][2] = new TubeL(0);
        this.grid[2][2] = new TubeL(3);
        this.grid[3][2] = new TubeL(2);
        this.grid[0][3] = new TubeI(1);
        this.grid[3][3] = new TubeI(0);
        this.grid[0][4] = new TubeL(3);
        this.grid[1][4] = new TubeL(1);
        this.grid[3][4] = new TubeI(1);
        this.grid[0][5] = new TubeL(2);
        this.grid[1][5] = new TubeL(3);
        this.grid[2][5] = new TubeI(0);
        this.grid[3][5] = new TubeL(0);
        this.grid[0][6] = new TubeI(1);
        this.grid[3][6] = new TubeI(1);
        this.grid[0][7] = new TubeL(3);
        this.grid[1][7] = new TubeI(1);
        this.grid[2][7] = new TubeL(1);
        this.grid[2][8] = new TubeL(1);
        this.grid[3][8] = new TubeL(2);
        this.grid[3][9] = new TubeI(0);
        this.grid[3][10] = new Destination(0);
    }
}
