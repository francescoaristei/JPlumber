/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplumber.View;

import javafx.scene.layout.GridPane;

/**
 *
 * @author Ledio
 */
public class Table { //questa sarà la matrice dei vari livelli, forse farò in modo che cambia questa matrice ma non la schermata ogni volta
    //è un'idea, invece di cambiare ogni volta scena
    public static Tube[][] pipes;
    public static GridPane grid= new GridPane();
    
    
    public static void setLevel1(){
        pipes=new Tube[5][5]; //da concordare le dimensioni
        //to do prendi dati dal logic
        
    }
    
    public static void setLevel2(){
        pipes=new Tube[10][10];
        //to do
    }
}
