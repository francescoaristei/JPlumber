package jplumber.View;

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class TubeView{
    // 3X3 matrix of rectangles
    protected Rectangle[][] rect= new Rectangle[3][3];

    // Rectangles will be inserted in the grid
    protected GridPane grid= new GridPane();

    // Counter to count the number of clicks done on the tube
    protected int numClicks=0;

    public static int style;

    public TubeView(){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                rect[i][j]= new Rectangle(16, 16);
                rect[i][j].setFill(Color.TRANSPARENT);
                grid.add(rect[i][j], j, i);
            }
    }


    // To color the tube, where is 1 the rectangle is coloured with green or black, depending of the style chosen
    public void paintTube(int [][] fillingOnes){
        for(int i=0; i<fillingOnes.length; i++)
            for(int j=0; j<fillingOnes.length; j++)
                if(fillingOnes[i][j]==1){
                    if(style==0)
                        rect[i][j].setFill(Color.GREEN);
                    else
                        rect[i][j].setFill(Color.BLACK);
                }
    }


    // To paint the source and the destination
    public void paintSpecialTube(int [][] fillingOnes){
        for(int i=0; i<fillingOnes.length; i++)
            for(int j=0; j<fillingOnes.length; j++)
                if(fillingOnes[i][j]==1){
                    if(style==0)
                        rect[i][j].setFill(Color.GREY);
                    else
                        rect[i][j].setFill(Color.DARKGRAY);
                }
    }

    // Insert every painted rectangles in the FillTransition object
    public FillTransition[] singleTube(String pos){
        FillTransition[] fill;
        int count=0;
        int dim=0;

        //Computes the dimension of the array, 4 for a T tube, 3 for a I or L tube
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(this.rect[i][j].getFill().equals(Color.GREEN)|| this.rect[i][j].getFill().equals(Color.BLACK))
                    dim++;
        fill=new FillTransition[dim];

        // Scans the 3X3 matrix from the bottom to the top, sorting the rectangles in the FillTransition's array
        if(pos.equals("down")){
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    if(this.rect[2-i][j].getFill().equals(Color.GREEN)|| this.rect[2-i][j].getFill().equals(Color.BLACK)){
                        fill[count]=new FillTransition(Duration.seconds(Level.FILLING_DURATION), rect[2-i][j]);
                        count++;
                    }
        }
        // Scans the 3X3 matrix from the top to the bottom
        else{
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    if(this.rect[i][j].getFill().equals(Color.GREEN)||this.rect[i][j].getFill().equals(Color.BLACK)){
                        fill[count]=new FillTransition(Duration.seconds(Level.FILLING_DURATION), rect[i][j]);
                        count++;
                    }
        }
        return fill;
    }


    // Handle the rotation of the tube
    public void rotate(){
        RotateTransition rotate= new RotateTransition(Duration.seconds(0.3), grid);
        rotate.setFromAngle((numClicks%4)*90);
        rotate.setByAngle(90);
        rotate.play();
        numClicks++;

        // Needed to change the index of the matrix of rectangles "rect" after a rotation
        Rectangle[][] mat2= new Rectangle[3][3];
        mat2[0][0]=rect[2][0];
        mat2[0][1]=rect[1][0];
        mat2[0][2]=rect[0][0];
        mat2[1][0]=rect[2][1];
        mat2[1][2]=rect[0][1];
        mat2[2][0]=rect[2][2];
        mat2[2][1]=rect[1][2];
        mat2[2][2]=rect[0][2];
        mat2[1][1]=rect[1][1];
        this.rect=mat2;

    }

}