/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplumber.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Ledio
 */
public class MainGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root= new BorderPane();
        
        Button play= new Button("Play");
        play.setMinHeight(50);
        root.setCenter(play);
        Button music= new Button("Music");
        root.setBottom(music);
        Scene scene = new Scene(root, 850, 600);
        
        primaryStage.setTitle("JPlumber");
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
