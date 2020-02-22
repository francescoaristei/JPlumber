package jplumberfinal;

public abstract class Tube {
    protected int[][] tubeMatrix = new int[3][3];
    protected String tubeName;
    protected int state;
    protected int indexI;
    protected int indexJ;

    protected Tube(){
    }

    protected abstract void rotate();

    protected abstract boolean isMatchable(Tube tube);

    protected abstract int[] pathResearchRow(int i, int j);

    protected abstract int[] pathResearchCols(int i, int j);

    protected int getIndexI(){
        return this.indexI;
    }

    protected int getIndexJ() {
        return this.indexJ;
    }

    protected String getTubeName(){
        return this.tubeName;
    }

    protected int getState(){
        return this.state;
    }

}
