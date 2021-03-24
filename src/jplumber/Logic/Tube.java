package jplumber.Logic;

public abstract class Tube {


    // 3x3 matrix of integer values, cells with value 1 indicate the presence of a tube
    protected int[][] tubeMatrix = new int[3][3];


    // Tube type
    protected String tubeName;


    // Tube state, changed when the tube is rotated
    protected int state;

    public Tube(){
    }


    // Method with whom the tube is rotated
    public abstract void rotate();


    // Return true if the tube represented by Tube object is connected with the tube calling this method, false otherwise
    public abstract boolean tubeMatch(Tube tube, int i, int j, int x, int y);


    // Return an array containing the rows of the grid where to search the match with tube in position (i,j)
    public abstract int[] tubeRow(int i, int j);


    // Return an array containing the cols of the grid where to search the match with tube in position (i,j)
    public abstract int[] tubeCols(int i, int j);


    // Return the tube's name
    public String getTubeName(){
        return this.tubeName;
    }


    // Return the state of the tube
    public int getState(){
        return this.state;
    }

    // Return the matrix which represent the tube
    public abstract int[][] getTubeMatrix();

}
