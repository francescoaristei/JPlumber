package jplumber.View;


import javafx.animation.FillTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Level1 extends Level{


    public Level1(){
        super();

        this.moves=20;
        this.movesRemaining.setWrappingWidth(220);
        this.movesRemaining.setText("Moves remaining: "+this.moves);

        // Sets the level
        View.getInstance().setLevel(this.getLevel());


        // Calls the logic to understand in which positions of the 11 X 11 matrix the tubes should be inserted
        // 1 -> tube, 0 -> no tube
        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        reset.setOnAction(e ->MainGUI.primaryStage.setScene(new Level1().getScene()));
    }


    // Second constructor to call when a level is saved and the player would like to restart from the checkpoint
    public Level1(int moves){
        super();

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        this.moves = moves;
        movesRemaining.setText("Moves remaining: "+ this.moves);

        reset.setOnAction(e -> MainGUI.primaryStage.setScene(new Level1().getScene()));


    }


    // Return the number of the level
    @Override
    public int getLevel(){
        return 1;
    }


    // Handles the flow of the water
    @Override
    public  void flowWater(){

        FillTransition[] mainFlow;
        TubeView[] tubeMainSequence= new TubeView[19];
        int mainDim=0;
        int mainCount=0;
        tubeMainSequence[0]=this.pipes[3][1];
        tubeMainSequence[1]=this.pipes[2][1];
        tubeMainSequence[2]=this.pipes[2][2];
        tubeMainSequence[3]=this.pipes[1][2];
        tubeMainSequence[4]=this.pipes[1][1];
        tubeMainSequence[5]=this.pipes[0][1];
        tubeMainSequence[6]=this.pipes[0][2];
        tubeMainSequence[7]=this.pipes[0][3];
        tubeMainSequence[8]=this.pipes[0][4];
        tubeMainSequence[9]=this.pipes[1][4];
        tubeMainSequence[10]=this.pipes[1][5];
        tubeMainSequence[11]=this.pipes[0][5];
        tubeMainSequence[12]=this.pipes[0][6];
        tubeMainSequence[13]=this.pipes[0][7];
        tubeMainSequence[14]=this.pipes[1][7];
        tubeMainSequence[15]=this.pipes[2][7];
        tubeMainSequence[16]=this.pipes[2][8];
        tubeMainSequence[17]=this.pipes[3][8];
        tubeMainSequence[18]=this.pipes[3][9];


        // To find the number of rectangles to paint
        for(int i=0; i<19; i++)
            mainDim+=tubeMainSequence[i].singleTube("up").length;
        mainFlow= new FillTransition[mainDim];


        // To populate the array of FillTransition
        for(int i=0; i<19;i++)
            for(int j=0; j<tubeMainSequence[i].singleTube("up").length; j++){
                if(i<=5 || i==10 || i==11)
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("down")[j];
                else
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("up")[j];
                mainCount++;
            }

        // To start the animation of the flow of the water
        for(int i=0; i<mainDim; i++){
            mainFlow[i].setFromValue(Color.ALICEBLUE);
            mainFlow[i].setToValue(Color.AQUA);
            mainFlow[i].setDelay(Duration.seconds(i*DELAY_DURATION));
            mainFlow[i].play();
        }

        // Wait 4 seconds before the win window
        this.delay(4000);

    }

    // Set the function of the buttons
    @Override
    public void setLostButtons(){
        backLost.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        replay.setOnAction(e -> MainGUI.primaryStage.setScene(new Level1().getScene()));
    }


    @Override
    public void setWinButtons(){
        backWin.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        nLevel.setOnAction(e -> MainGUI.primaryStage.setScene(new Level2().getScene()));
    }

    // Return the scene
    @Override
    public  Scene getScene(){
        return scene;
    }
}