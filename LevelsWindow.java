/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplumber.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Ledio
 */
public class LevelsWindow {
    BorderPane root= new BorderPane();
    GridPane grid= new GridPane();
    Button level1=new Button("Level 1");
    Button level2=new Button("Level 2");
    Button level3=new Button("Level 3");
    Button level4=new Button("Level 4");
   
    public LevelsWindow(){
        this.root.setCenter(grid);
        grid.add(level1, 0, 0);
        grid.add(level2, 0, 1);
        grid.add(level3, 1, 0);
        grid.add(level4, 1, 1);
    }
    
    
    
    
    
    //Scene scene = new Scene(root, 850, 600);
}
