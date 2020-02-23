/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplumber.View;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Ledio
 */
public class Tube extends Node{
    Rectangle[][] rect= new Rectangle[3][3];
    GridPane grid= new GridPane();
    public Tube(){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                rect[i][j]= new Rectangle(50, 50);
                rect[i][j].setStroke(Color.GRAY);
                rect[i][j].setFill(Color.WHITE);
                grid.add(rect[i][j], i, j);
            }
    }
    
    public void paintTube(){ //verrà richiamato ogni volta che viene aggiunto un tubo nel logic, attraverso un parametro che sarà una matrice di 1 e 0 
        
    }
   
    public void rotate(){// utilizzare rotate transition, dovrà richiamare la rotazione nel logico
       
    }
          
}
