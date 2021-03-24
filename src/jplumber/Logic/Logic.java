package jplumber.Logic;

import javafx.stage.Stage;
import jplumber.View.View;



public class Logic implements ILogic {

    private static Logic instance = null;


    // Represent the grid of the level in which the player will play
    protected Grid level;


    public static ILogic getInstance() {
        if (instance == null)
            instance = new Logic();
        return instance;
    }

    //resituisce la dimensione della griglia
    // Return the dimension of the grid
    @Override
    public int getDim(){
        return Grid.DIMENSION;
    }

    @Override
    public void openMainGUI(Stage primaryStage) {

        View.getInstance().openMainGUI(primaryStage);
    }


    // Return true if the correct path to source to destination is found
    public boolean win() {
        return this.level.correctFlow();
    }



    // Needed to set the level in which the player wish to play
    @Override
    public Grid setLevel(int level) {
        if (level == 1)
            this.level = new Grid1();
        else if (level == 2)
            this.level = new Grid2();
        else if (level == 3)
            this.level = new Grid3();
        else
            this.level = new Grid4();
        return this.level;
    }

    @Override
    public int[][] setTube(int i, int j) {
        return this.level.grid[i][j].getTubeMatrix();
    }

    public int[][] onesGrid() {
        return this.level.oneGrid();
    }



    // Needed to rotate the tube in position (i,j) in the grid
    @Override
    public void setRotate(int i, int j) {

        this.level.grid[i][j].rotate();
    }

}
