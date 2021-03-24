package jplumber.View;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;



public abstract class Level {

    // Matrix of tubes
    protected TubeView[][] pipes;

    // Grid in which the tubes will be inserted
    protected GridPane grid= new GridPane();

    // Matrix with value 1 or 0, 1 indicate the presence of the tube
    protected int [][] isTube;

    // Dimension of the matrix of the tube
    public static final int DIMENSION = View.getInstance().getDim();

    protected Text movesRemaining=new Text();

    // Indicate the number of remaining moves
    protected int moves;


    // Main components of the window of a level
    protected StackPane root= new StackPane();
    protected HBox hBox= new HBox(50);
    protected Scene scene= new Scene(root, 1000, 700);
    protected Button back= new Button("Back");
    protected Button reset= new Button("Reset");
    protected Button exit = new Button("Exit");
    protected Text level= new Text();
    protected VBox vBox= new VBox(140);

    // Buttons of the win and loose window
    protected Button backLost= new Button("Back");
    protected Button replay= new Button("Replay");
    protected Button backWin= new Button("Back");
    protected Button nLevel= new Button("Next Level");

    // Indicates if the style of the window is dark o light
    public static int style;


    // Needed to let water flow inside the tubes
    public static final double FILLING_DURATION=1.0;
    public static final double DELAY_DURATION=FILLING_DURATION-0.95;


    public Level(){
        this.pipes= new TubeView[DIMENSION][DIMENSION];


        // To add tubes to the grid, for each tube a event listener is added
        for(int i=0; i<DIMENSION; i++)
            for(int j=0; j<DIMENSION; j++){
                this.pipes[i][j]=new TubeView();
                this.grid.add(pipes[i][j].grid, j, i);
                this.grid.setGridLinesVisible(false);
                int finalI = i;
                int finalJ = j;
                this.pipes[finalI][finalJ].grid.setOnMouseClicked(e -> {
                    this.pipes[finalI][finalJ].rotate();
                    View.getInstance().setRotate(finalI, finalJ);
                    this.decreaseMoves(finalI, finalJ);
                    this.victory();

                });
            }


        level.setText("Level "+ this.getLevel());
        level.setId("textLevel");
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);
        level.setEffect(bloom);


        // To set the CSS styles
        backLost.setId("specialButton");
        replay.setId("specialButton");
        backWin.setId("specialButton");
        nLevel.setId("specialButton");
        grid.setId("grid");
        movesRemaining.setId("textMoves");

        back.setOnAction(e -> {
            MainGUI.primaryStage.setScene(LevelsWindow.scene);
            MainGUI.checkpoint.setDisable(true);
        });
        exit.setOnAction(e -> this.saveGame());


        // To configure the layout
        grid.setPadding(new Insets(45, 25, 25, 25));
        vBox.getChildren().addAll(movesRemaining, reset,level, back, exit);
        VBox.setMargin(back,new Insets(10, 10, 10, 10));
        VBox.setMargin(reset,new Insets(10,10,10,10));
        VBox.setMargin(movesRemaining,new Insets(10,10,10,10));
        VBox.setMargin(level, new Insets(10,10,10,10));
        VBox.setMargin(exit, new Insets(10,10,10,10));
        vBox.setSpacing(80);
        hBox.getChildren().addAll(grid, vBox);
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(50);
        root.getChildren().add(hBox);
        StackPane.setMargin(hBox, new Insets(50, 50, 50, 50));
        StackPane.setAlignment(hBox, Pos.CENTER);


        // To impose the style chosen by the user
        if (style == 0) {
            scene.getStylesheets().add(Level.class.getResource("LevelLight.css").toExternalForm());
        }
        else{
            scene.getStylesheets().add(Level.class.getResource("LevelDark.css").toExternalForm());
        }
    }


    // To color the tubes, where there is 1 a tube needs to be added
    public void drawGrid(int [][] onesCatching){
        for(int i=0; i<onesCatching.length; i++)
            for(int j=0; j<onesCatching.length; j++)
                if(onesCatching[i][j]==1){
                    if(j==0 || j==DIMENSION-1)
                        // To color source and destination tubes
                        pipes[i][j].paintSpecialTube(View.getInstance().getTube(i, j));
                    else
                        pipes[i][j].paintTube(View.getInstance().getTube(i, j));
                    this.pipes[i][j].grid.setId("pipe");
                }
    }


    // To show the loose window
    public void lost(){
        GaussianBlur blur= new GaussianBlur();
        hBox.setEffect(blur);
        hBox.setDisable(true);
        StackPane pane= new StackPane();
        pane.setMaxSize(400, 300);
        pane.setId("paneOver");

        this.setLostButtons();

        StackPane.setMargin(backLost, new Insets(25, 25, 25, 25));
        StackPane.setAlignment(backLost, Pos.BOTTOM_RIGHT);
        pane.getChildren().add(backLost);

        StackPane.setMargin(replay, new Insets(25, 25, 25, 25));
        StackPane.setAlignment(replay, Pos.BOTTOM_LEFT);
        pane.getChildren().add(replay);

        root.getChildren().add(pane);

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/jplumber/Media/Looser2.mp3").toExternalForm()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setVolume(1);
        root.getChildren().add(mediaView);
        mediaPlayer.play();

    }

    public abstract void setLostButtons();

    public abstract void setWinButtons();


    // To handle the delay of the win window
    public void delay(int millisec){
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                win();
            }
        }, millisec);
    }


    // To reduce the number of moves and check if the player has lost
    public void decreaseMoves(int i, int j){
        if(this.isTube[i][j]==1){
            moves--;
            if(moves==0 && !View.getInstance().win())
                this.lost();
            this.movesRemaining.setText("Moves remaining: "+ moves);
        }
    }



    // To show the win panel
    public void win(){
        Platform.runLater(() -> {
            GaussianBlur blur = new GaussianBlur();
            hBox.setEffect(blur);
            hBox.setDisable(true);

            StackPane pane = new StackPane();
            pane.setMaxSize(400, 300);
            pane.setId("paneWin");

            this.setWinButtons();

            StackPane.setMargin(backWin, new Insets(30, 30, 10, 30));
            StackPane.setAlignment(backWin, Pos.BOTTOM_LEFT);
            pane.getChildren().add(backWin);

            StackPane.setMargin(nLevel, new Insets(30, 30, 10, 30));
            StackPane.setAlignment(nLevel, Pos.BOTTOM_RIGHT);
            pane.getChildren().add(nLevel);

            root.getChildren().add(pane);


            MediaPlayer mediaPlayer2 = new MediaPlayer(new Media(this.getClass().getResource("/jplumber/Media/jingleWin.wav").toExternalForm()));
            MediaView mediaView2 = new MediaView(mediaPlayer2);
            mediaPlayer2.setVolume(0.2);
            root.getChildren().add(mediaView2);
            mediaPlayer2.play();
        });
    }

    // To show the saving window
    public void saveGame(){
        hBox.setBlendMode(BlendMode.LIGHTEN);
        GaussianBlur blur = new GaussianBlur();
        hBox.setEffect(blur);
        hBox.setDisable(true);

        StackPane pane = new StackPane();
        pane.setMaxSize(500, 500);

        Text wannaSave = new Text("Do you want to save");
        wannaSave.setId("textSave");

        Button yesSave= new Button("Yes");
        yesSave.setOnAction(e -> {
            MainGUI.setCheckpoint(this.moves, this.getLevel());
            MainGUI.primaryStage.setScene(MainGUI.scene);
            MainGUI.checkpoint.setDisable(false);
        });

        Button noSave= new Button("No");
        noSave.setOnAction(e -> {
            MainGUI.setCheckpoint(-1, 0);
            MainGUI.primaryStage.setScene(MainGUI.scene);
            MainGUI.checkpoint.setDisable(true);
        });

        StackPane.setMargin(wannaSave, new Insets(30, 30, 30, 30));
        StackPane.setAlignment(wannaSave, Pos.CENTER);
        pane.getChildren().add(wannaSave);

        StackPane.setMargin(yesSave, new Insets(30, 30, 30, 30));
        StackPane.setAlignment(yesSave, Pos.BOTTOM_LEFT);
        pane.getChildren().add(yesSave);

        StackPane.setMargin(noSave, new Insets(30, 30, 30, 30));
        StackPane.setAlignment(noSave, Pos.BOTTOM_RIGHT);
        pane.getChildren().add(noSave);

        root.getChildren().add(pane);
    }

    public abstract void flowWater();


    // Check if the path is correct
    public  void victory(){
        if(View.getInstance().win()){
            this.flowWater();
        }
    }

    public abstract int getLevel();

    public abstract Scene getScene();


}