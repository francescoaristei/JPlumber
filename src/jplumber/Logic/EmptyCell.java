package jplumber.Logic;

// It represents the empty cell where there isn't any tube and where water can't flow
public class EmptyCell extends Tube {

    protected int[][] tubeMatrix = new int[3][3];
    protected String tubeName;

    EmptyCell(){
        this.tubeName = "EmptyCell";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tubeMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public int[][] getTubeMatrix(){
        return this.tubeMatrix;
    }

    @Override
    public void rotate(){
    }

    @Override
    public  boolean tubeMatch(Tube tube, int i, int j, int x, int y){
        return false;
    }

    @Override
    public int[] tubeRow(int i, int j){
        return new int[0];
    }

    @Override
    public int[] tubeCols(int i, int j){
        return new int[0];
    }
}
