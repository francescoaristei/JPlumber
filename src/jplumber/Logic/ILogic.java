package jplumber.Logic;

import javafx.stage.Stage;




// Interface to decouple the Logic from his actual implementation
public interface ILogic {

    public void openMainGUI(Stage primaryStage);

    public Grid setLevel(int level);

    public int[][] setTube(int i, int j);

    public void setRotate(int i, int j);

    public int[][] onesGrid();

    public boolean win();

    public int getDim();
}
