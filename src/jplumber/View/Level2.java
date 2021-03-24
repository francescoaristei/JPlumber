package jplumber.View;

import javafx.animation.FillTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Level2 extends Level{

    public Level2(){
        super();

        this.moves=35;
        this.movesRemaining.setWrappingWidth(220);
        this.movesRemaining.setText("Moves remaining: "+this.moves);

        View.getInstance().setLevel(this.getLevel());

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        reset.setOnAction(e ->MainGUI.primaryStage.setScene(new Level2().getScene()));
    }

    public Level2(int moves){
        super();

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        this.moves = moves;
        movesRemaining.setText("Moves remaining: "+ this.moves);

        reset.setOnAction(e -> MainGUI.primaryStage.setScene(new Level2().getScene()));
    }

    @Override
    public int getLevel(){
        return 2;
    }

    @Override
    public  void flowWater(){
        FillTransition[] mainFlow;
        TubeView[] tubeMainSequence= new TubeView[18];
        int mainDim=0;
        int mainCount=0;
        tubeMainSequence[0]=this.pipes[2][0];
        tubeMainSequence[1]=this.pipes[2][1];
        tubeMainSequence[2]=this.pipes[3][1];
        tubeMainSequence[3]=this.pipes[3][2];
        tubeMainSequence[4]=this.pipes[2][2];
        tubeMainSequence[5]=this.pipes[1][2];
        tubeMainSequence[6]=this.pipes[0][2];
        tubeMainSequence[7]=this.pipes[0][3];
        tubeMainSequence[8]=this.pipes[0][4];
        tubeMainSequence[9]=this.pipes[0][5];
        tubeMainSequence[10]=this.pipes[1][5];
        tubeMainSequence[11]=this.pipes[1][6];
        tubeMainSequence[12]=this.pipes[2][6];
        tubeMainSequence[13]=this.pipes[2][7];
        tubeMainSequence[14]=this.pipes[2][8];
        tubeMainSequence[15]=this.pipes[2][9];
        tubeMainSequence[16]=this.pipes[1][9];
        tubeMainSequence[17]=this.pipes[1][10];

        for(int i=0; i<18; i++)
            mainDim+=tubeMainSequence[i].singleTube("up").length;
        mainFlow= new FillTransition[mainDim];

        for(int i=0; i<18;i++)
            for(int j=0; j<tubeMainSequence[i].singleTube("up").length; j++){
                if(i==3 || i==4 || i==5 || i==6 || i==15  || i==16)
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("down")[j];
                else
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("up")[j];
                mainCount++;
            }

        // Secondary sequence
        FillTransition[] secondaryFlow;
        TubeView[] tubeSecSequence=new TubeView[11];
        int secDim=0;
        int secCount=0;
        tubeSecSequence[0]=this.pipes[2][3];
        tubeSecSequence[1]=this.pipes[2][4];
        tubeSecSequence[2]=this.pipes[2][5];
        tubeSecSequence[3]=this.pipes[3][5];
        tubeSecSequence[4]=this.pipes[3][6];
        tubeSecSequence[5]=this.pipes[4][6];
        tubeSecSequence[6]=this.pipes[4][7];
        tubeSecSequence[7]=this.pipes[4][8];
        tubeSecSequence[8]=this.pipes[3][8];
        tubeSecSequence[9]=this.pipes[3][3];
        tubeSecSequence[10]=this.pipes[3][4];

        for(int i=0; i<11; i++)
            secDim+=tubeSecSequence[i].singleTube("up").length;
        secondaryFlow= new FillTransition[secDim];

        for(int i=0; i<11;i++)
            for(int j=0; j<tubeSecSequence[i].singleTube("up").length; j++){
                if(i>=7)
                    secondaryFlow[secCount]=tubeSecSequence[i].singleTube("down")[j];
                else
                    secondaryFlow[secCount]=tubeSecSequence[i].singleTube("up")[j];
                secCount++;
            }



        for(int i=0; i<mainDim; i++){
            mainFlow[i].setFromValue(Color.ALICEBLUE);
            mainFlow[i].setToValue(Color.AQUA);
            mainFlow[i].setDelay(Duration.seconds(i*DELAY_DURATION));
            mainFlow[i].play();
        }

        for(int j=0; j<secDim; j++){
            secondaryFlow[j].setFromValue(Color.ALICEBLUE);
            secondaryFlow[j].setToValue(Color.AQUA);
            if(j>=secDim-6 && j<secDim-3)
                secondaryFlow[j].setDelay(Duration.seconds(13*DELAY_DURATION+(j%3)*DELAY_DURATION));
            else if(j>=secDim-3)
                secondaryFlow[j].setDelay(Duration.seconds(24*DELAY_DURATION+(j%3)*DELAY_DURATION));
            else
                secondaryFlow[j].setDelay(Duration.seconds(16*DELAY_DURATION+j*DELAY_DURATION));

            secondaryFlow[j].play();
        }

        this.delay(4000);

    }

    @Override
    public void setLostButtons(){
        backLost.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        replay.setOnAction(e -> MainGUI.primaryStage.setScene(new Level2().getScene()));
    }


    @Override
    public  void setWinButtons(){
        backWin.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        nLevel.setOnAction(e -> MainGUI.primaryStage.setScene(new Level3().getScene()));
    }


    @Override
    public  Scene getScene(){
        return scene;
    }



}