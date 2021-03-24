package jplumber.View;

import javafx.stage.Stage;


// Interface of the View needed to decouple view to the actual representation
public interface IView {

    public void openMainGUI(Stage primaryStage);

    public void setLevel(int level);

    public void setRotate(int i, int j);

    public int[][] getGrid();

    public int[][] getTube(int i, int j);

    public boolean win();

    public int getDim();
}