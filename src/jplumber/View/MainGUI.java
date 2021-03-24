package jplumber.View;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MainGUI {
    // To handle the window
    public static Stage primaryStage;
    public static Scene scene;


    // Counter to count the numbers of clicks on the "Music" button
    public static int numClicks=0;


    // Counter to count the numbers of clicks on the "Style" button
    public static int styleClicks = 0;

    // To store the info about a previously saved level
    public static int movesRem = 0;
    public static int levelNumber=0;

    public static Button checkpoint;


    public MainGUI(Stage stage){

        primaryStage=stage;
        BorderPane root= new BorderPane();
        root.setPadding(new Insets(5, 20, 5, 20));

        // To handle the "Play" button
        Button play= new Button();
        Image image = new Image("/jplumber/Media/Play.png");
        ImageView viewPlay= new ImageView(image);
        viewPlay.setFitHeight(45);
        viewPlay.setFitWidth(45);
        play.setGraphic(viewPlay);
        play.setMinHeight(50);
        play.setMinWidth(70);
        play.setOnAction(e -> {
            primaryStage.setScene(new LevelsWindow().getScene());
            checkpoint.setDisable(true);
        });


        // To handle the music
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/jplumber/Media/GTA.mp3").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.setCycleCount(2000000);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().add(mediaView);

        // To handle the button "Music"
        Button music= new Button();
        Image imageMusic = new Image("/jplumber/Media/Music.png");
        ImageView viewMusic= new ImageView(imageMusic);
        Image imageNoMusic = new Image("/jplumber/Media/NoMusic.png");
        ImageView viewNoMusic= new ImageView(imageNoMusic);
        music.setGraphic(viewMusic);
        music.setMinHeight(30);
        music.setMinWidth(40);
        root.setRight(music);
        BorderPane.setAlignment(music, Pos.TOP_CENTER);
        music.setOnAction(e -> {
            numClicks++;
            if(numClicks%2==1){
                music.setGraphic(viewNoMusic);
                mediaPlayer.pause();
            }
            else{
                music.setGraphic(viewMusic);
                mediaPlayer.play();
            }
        });

        // To handle the button "Restart"
        checkpoint = new Button("Restart");
        checkpoint.setMinHeight(50);
        checkpoint.setMinWidth(70);
        checkpoint.setId("buttonRestart");
        checkpoint.setOnAction(e -> {
            if(movesRem > 0) {
                Level level;
                if(levelNumber==1){
                    level=new Level1(movesRem);
                    primaryStage.setScene(level.getScene());
                }
                else if(levelNumber==2){
                    level= new Level2(movesRem);
                    primaryStage.setScene(level.getScene());
                }
                else if(levelNumber==3){
                    level= new Level3(movesRem);
                    primaryStage.setScene(level.getScene());
                }
                else if(levelNumber==4){
                    level= new Level4(movesRem);
                    primaryStage.setScene(level.getScene());
                }

            }
        });

        //To handle the button "style"
        Button style = new Button("Light Theme");
        style.setTextFill(Color.WHITE);
        style.setMinHeight(50);
        style.setMinWidth(70);
        style.setId("buttonRestart");
        style.setOnAction(e -> {
            styleClicks++;
            if(styleClicks%2 == 1) {
                LevelsWindow.style = 1;
                Level.style = 1;
                TubeView.style = 1;
                style.setText("Dark Theme");
            }
            else {
                LevelsWindow.style = 0;
                Level.style = 0;
                TubeView.style = 0;
                style.setText("Light Theme");
            }
        });

        // Vertical positioning of the three buttons "Play", "Style" and "Checkpoint
        VBox vBox2= new VBox(50);
        root.setCenter(vBox2);
        BorderPane.setMargin(vBox2, new Insets(5, 5, 100, 5));
        vBox2.getChildren().addAll(play, checkpoint, style);
        vBox2.setAlignment(Pos.CENTER);

        // To handle the logo
        Image imageLogo = new Image("/jplumber/Media/Logo.png");
        ImageView viewLogo= new ImageView(imageLogo);
        viewLogo.setFitHeight(200);
        viewLogo.setFitWidth(200);
        root.setTop(viewLogo);

        // To handle the title
        Text title=new Text("𝓙𝓟𝓛𝓤𝓜𝓑𝓔𝓡");
        title.setId("title");
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);
        title.setEffect(bloom);

        //Vertical positioning of the title and the logo
        VBox vBox= new VBox(5);
        BorderPane.setAlignment(vBox, Pos.CENTER);
        vBox.getChildren().addAll(viewLogo, title);
        vBox.setAlignment(Pos.CENTER);
        root.setTop(vBox);

        // To handle the style and dimension of the initial window
        scene = new Scene(root, 1000, 700);
        scene.getStylesheets().add(MainGUI.class.getResource("MainGUI.css").toExternalForm());
        primaryStage.setTitle("JPlumber");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    // Store the info about the saved level
    public static void setCheckpoint(int lev, int numLev) {
        movesRem = lev;
        levelNumber=numLev;
    }
}