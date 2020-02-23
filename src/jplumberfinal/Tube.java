package jplumberfinal;

public abstract class Tube {
    protected int[][] tubeMatrix = new int[3][3];
    protected String tubeName;
    protected int state;

    protected Tube(){
    }

    protected abstract void rotate();

    protected abstract boolean isMatchable(Tube tube);

    protected abstract int[] pathResearchRow(int i, int j);

    protected abstract int[] pathResearchCols(int i, int j);

    protected String getTubeName(){
        return this.tubeName;
    }

    protected int getState(){
        return this.state;
    }

}
