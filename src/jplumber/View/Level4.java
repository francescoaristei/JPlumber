package jplumber.View;

import javafx.animation.FillTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Level4 extends Level{


    public Level4(){
        super();

        this.moves = 45;
        this.movesRemaining.setWrappingWidth(220);
        this.movesRemaining.setText("Moves remaining: "+ this.moves);

        View.getInstance().setLevel(this.getLevel());

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        reset.setOnAction(e -> {
            MainGUI.primaryStage.setScene(new Level4().getScene());
        });
    }

    public Level4(int moves){
        super();

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        this.moves = moves;
        movesRemaining.setText("Moves remaining: "+ this.moves);

        reset.setOnAction(e -> {
            MainGUI.primaryStage.setScene(new Level4().getScene());
        });

    }

    @Override
    public int getLevel(){
        return 4;
    }


    @Override
    public void flowWater(){
        FillTransition[] mainFlow;
        TubeView[] tubeMainSequence= new TubeView[21];
        int mainDim=0;
        int mainCount=0;
        tubeMainSequence[0]=this.pipes[0][1];
        tubeMainSequence[1]=this.pipes[1][1];
        tubeMainSequence[2]=this.pipes[1][2];
        tubeMainSequence[3]=this.pipes[2][2];
        tubeMainSequence[4]=this.pipes[2][3];
        tubeMainSequence[5]=this.pipes[3][3];
        tubeMainSequence[6]=this.pipes[3][4];
        tubeMainSequence[7]=this.pipes[3][5];
        tubeMainSequence[8]=this.pipes[2][5];
        tubeMainSequence[9]=this.pipes[2][6];
        tubeMainSequence[10]=this.pipes[1][6];
        tubeMainSequence[11]=this.pipes[1][7];
        tubeMainSequence[12]=this.pipes[2][7];
        tubeMainSequence[13]=this.pipes[2][8];
        tubeMainSequence[14]=this.pipes[3][8];
        tubeMainSequence[15]=this.pipes[3][9];
        tubeMainSequence[16]=this.pipes[4][9];
        tubeMainSequence[17]=this.pipes[4][8];
        tubeMainSequence[18]=this.pipes[5][8];
        tubeMainSequence[19]=this.pipes[5][9];
        tubeMainSequence[20]=this.pipes[2][4]; //tubo fuori sequenza, posto qui per comodità

        for(int i=0; i<21; i++)
            mainDim+=tubeMainSequence[i].singleTube("up").length;
        mainFlow= new FillTransition[mainDim];

        for(int i=0; i<21; i++)
            for(int j=0; j<tubeMainSequence[i].singleTube("up").length; j++){
                if((i>5 && i<11) || i==20)
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("down")[j];
                else
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("up")[j];
                mainCount++;
            }

        for(int i=0; i<mainDim; i++){
            mainFlow[i].setFromValue(Color.ALICEBLUE);
            mainFlow[i].setToValue(Color.AQUA);
            if(i>=mainDim-3)
                mainFlow[i].setDelay(Duration.seconds(22*DELAY_DURATION+(i%3)*DELAY_DURATION));
            else
                mainFlow[i].setDelay(Duration.seconds(i*DELAY_DURATION));
            mainFlow[i].play();
        }

        this.delay(4500);


    }

    @Override
    public void setLostButtons(){
        backLost.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        replay.setOnAction(e -> MainGUI.primaryStage.setScene(new Level4().getScene()));
    }

    @Override
    public void setWinButtons(){
        backWin.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        nLevel.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
    }


    @Override
    public  Scene getScene(){
        return scene;
    }
}