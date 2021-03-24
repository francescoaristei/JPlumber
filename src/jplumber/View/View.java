package jplumber.View;


import javafx.stage.Stage;
import jplumber.Logic.Logic;

public class View implements IView {

    private static View instance = null;
    private MainGUI mainGUI= null;


    // Open MainGUI
    @Override
    public void openMainGUI(Stage primaryStage){
        if(mainGUI == null){
            mainGUI = new MainGUI( primaryStage);
        }
    }


    // Sets the level
    @Override
    public void setLevel(int level){
        Logic.getInstance().setLevel(level);
    }

    public static IView getInstance(){
        if(instance == null)
            instance = new View();
        return instance;

    }


    // Asks to the Logic the integers matrix associated with the tube with index (i,j)
    @Override
    public int [][] getTube(int i, int j){
        return Logic.getInstance().setTube(i, j);
    }


    // Asks to the Logic the integers matrix of the grid, where value 1 indicates the presence of a tube, 0 otherwise
    @Override
    public int[][] getGrid(){
        return Logic.getInstance().onesGrid();
    }


    // Asks to the Logic if the path is correct
    @Override
    public boolean win(){
        boolean win = false;
        if(Logic.getInstance().win())
            win = true;
        return win;
    }


    // Rotate in the Logic the tube in position (i,j)
    @Override
    public void setRotate(int i, int j){
        Logic.getInstance().setRotate(i, j);
    }



    // Return the dimension of the grid
    @Override
    public int getDim(){
        return Logic.getInstance().getDim();
    }
}