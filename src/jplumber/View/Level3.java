package jplumber.View;

import javafx.animation.FillTransition;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;



public class Level3 extends Level {

    public Level3(){
        super();

        this.moves=25;
        this.movesRemaining.setWrappingWidth(220);
        this.movesRemaining.setText("Moves remaining: "+this.moves);

        View.getInstance().setLevel(this.getLevel());

        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        reset.setOnAction(e ->MainGUI.primaryStage.setScene(new Level3().getScene()));
    }

    public Level3(int moves){
        super();
        this.isTube= new int[View.getInstance().getGrid().length][View.getInstance().getGrid().length];
        for(int i=0; i<isTube.length; i++)
            for(int j=0; j<isTube.length; j++)
                this.isTube[i][j]=View.getInstance().getGrid()[i][j];
        this.drawGrid(this.isTube);

        this.moves = moves;
        movesRemaining.setText("Moves remaining: "+ this.moves);

        reset.setOnAction(e -> MainGUI.primaryStage.setScene(new Level3().getScene()));
    }

    @Override
    public int getLevel(){
        return 3;
    }

    @Override
    public void flowWater(){
        FillTransition[] mainFlow;
        TubeView[] tubeMainSequence= new TubeView[10];
        int mainDim=0;
        int mainCount=0;
        tubeMainSequence[0]=this.pipes[1][1];
        tubeMainSequence[1]=this.pipes[0][1];
        tubeMainSequence[2]=this.pipes[0][2];
        tubeMainSequence[3]=this.pipes[0][3];
        tubeMainSequence[4]=this.pipes[0][4];
        tubeMainSequence[5]=this.pipes[0][5];
        tubeMainSequence[6]=this.pipes[0][6];
        tubeMainSequence[7]=this.pipes[0][7];
        tubeMainSequence[8]=this.pipes[0][8];
        tubeMainSequence[9]=this.pipes[0][9];


        for(int i=0; i<10; i++)
            mainDim+=tubeMainSequence[i].singleTube("up").length;
        mainFlow= new FillTransition[mainDim];

        for(int i=0; i<10;i++)
            for(int j=0; j<tubeMainSequence[i].singleTube("up").length; j++){
                if(i<=1)
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("down")[j];
                else
                    mainFlow[mainCount]=tubeMainSequence[i].singleTube("up")[j];
                mainCount++;
            }



        FillTransition[] secondaryFlow;
        TubeView[] tubeSecSequence=new TubeView[9];
        int secDim=0;
        int secCount=0;
        tubeSecSequence[0]=this.pipes[1][4];
        tubeSecSequence[1]=this.pipes[2][4];
        tubeSecSequence[2]=this.pipes[2][3];
        tubeSecSequence[3]=this.pipes[2][2];
        tubeSecSequence[4]=this.pipes[3][2];
        tubeSecSequence[5]=this.pipes[4][2];
        tubeSecSequence[6]=this.pipes[5][2];
        tubeSecSequence[7]=this.pipes[5][3];
        tubeSecSequence[8]=this.pipes[5][4];

        for(int i=0; i<9; i++)
            secDim+=tubeSecSequence[i].singleTube("up").length;
        secondaryFlow= new FillTransition[secDim];

        for(int i=0; i<9;i++)
            for(int j=0; j<tubeSecSequence[i].singleTube("up").length; j++){
                secondaryFlow[secCount]=tubeSecSequence[i].singleTube("up")[j];
                secCount++;
            }


        FillTransition[] thirdFlow;
        TubeView[] tubeThirdSequence= new TubeView[6];
        int thirdDim=0;
        int thirdCount=0;
        tubeThirdSequence[0]=this.pipes[2][5];
        tubeThirdSequence[1]=this.pipes[2][6];
        tubeThirdSequence[2]=this.pipes[3][6];
        tubeThirdSequence[3]=this.pipes[4][6];
        tubeThirdSequence[4]=this.pipes[5][6];
        tubeThirdSequence[5]=this.pipes[5][5];

        for(int i=0; i<6; i++)
            thirdDim+=tubeThirdSequence[i].singleTube("up").length;
        thirdFlow= new FillTransition[thirdDim];

        for(int i=0; i<6;i++)
            for(int j=0; j<tubeThirdSequence[i].singleTube("up").length; j++){
                thirdFlow[thirdCount]=tubeThirdSequence[i].singleTube("up")[j];
                thirdCount++;
            }



        //esecuzione delle 3 sequenze
        for(int i=0; i<mainDim; i++){
            mainFlow[i].setFromValue(Color.ALICEBLUE);
            mainFlow[i].setToValue(Color.AQUA);
            mainFlow[i].setDelay(Duration.seconds(i*DELAY_DURATION));
            mainFlow[i].play();
        }

        for(int j=0; j<secDim; j++){
            secondaryFlow[j].setFromValue(Color.ALICEBLUE);
            secondaryFlow[j].setToValue(Color.AQUA);
            secondaryFlow[j].setDelay(Duration.seconds(16*DELAY_DURATION+j*DELAY_DURATION));
            secondaryFlow[j].play();
        }

        for(int i=0; i<thirdDim; i++){
            thirdFlow[i].setFromValue(Color.ALICEBLUE);
            thirdFlow[i].setToValue(Color.AQUA);
            thirdFlow[i].setDelay(Duration.seconds(23*DELAY_DURATION+i*DELAY_DURATION));
            thirdFlow[i].play();
        }


        this.delay(4000);
    }


    @Override
    public void setLostButtons(){
        backLost.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        replay.setOnAction(e -> MainGUI.primaryStage.setScene(new Level3().getScene()));
    }

    @Override
    public  void setWinButtons(){
        backWin.setOnAction(e -> MainGUI.primaryStage.setScene(new LevelsWindow().getScene()));
        nLevel.setOnAction(e -> MainGUI.primaryStage.setScene(new Level4().getScene()));
    }

    @Override
    public  Scene getScene(){
        return scene;
    }
}