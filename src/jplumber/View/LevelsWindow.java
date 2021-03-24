package jplumber.View;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class LevelsWindow {

    protected BorderPane root= new BorderPane();
    protected GridPane grid= new GridPane();
    public static Scene scene;
    protected Stage primaryStage= new Stage();

    protected Button level1=new Button("Level 1");
    protected Button level2=new Button("Level 2");
    protected Button level3=new Button("Level 3");
    protected Button level4=new Button("Level 4");
    protected Button back= new Button("Back");

    public static int style;


    public LevelsWindow(){

        scene = new Scene(root, 1000, 700);
        this.root.setCenter(grid);


        // To determine which of the two styles to handle
        if (style == 0) {
            this.root.getStylesheets().add(LevelsWindow.class.getResource("LevelsWindowLight.css").toExternalForm());
        }
        else{
            this.root.getStylesheets().add(LevelsWindow.class.getResource("LevelsWindowDark.css").toExternalForm());
        }


        // To handle the layouts
        this.level1.setMinSize(100, 70);
        this.level2.setMinSize(100, 70);
        this.level3.setMinSize(100, 70);
        this.level4.setMinSize(100, 70);
        this.back.setMinSize(70, 40);

        this.grid.add(level1, 0, 0);
        this.grid.add(level2, 2, 0);
        this.grid.add(level3, 0, 1);
        this.grid.add(level4, 2, 1);
        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(100);
        this.grid.setVgap(120);
        this.grid.add(back, 1, 2);

        // To assign the functions to the buttons
        this.back.setOnAction(e -> MainGUI.primaryStage.setScene(MainGUI.scene));
        this.level1.setOnAction(e -> {this.setLevel(1);});
        this.level2.setOnAction(e -> {this.setLevel(2);});
        this.level3.setOnAction(e -> {this.setLevel(3);});
        this.level4.setOnAction(e -> {this.setLevel(4);});
    }

    public Scene getScene(){
        return  scene;
    }


    // To set the level
    public void setLevel(int l){
        Level level;
        if(l==1){
            level= new Level1();
        }
        else if(l==2){
            level=new Level2();
        }
        else if(l==3){
            level=new Level3();
        }
        else {
            level=new Level4();
        }
        MainGUI.primaryStage.setScene(level.getScene());
    }

}