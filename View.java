/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jplumber.View;

/**
 *
 * @author Ledio
 */
public class View implements IView {
    private static View instance = null;
    
    @Override
    public void openStartWindow(){
        
    }
    @Override
    public void closeStartWindow(){
        
    }
    @Override
    public void openNewGameWindow(){
        
    }
    @Override
    public void closeNewGameWindow(){
        
    }
    @Override
    public void openMainGUI(){
        
    }
    @Override
    public void gameOverDialog(){
        
    }
    
    
    
    public static IView getInstance(){

        if(instance == null)
            instance = new View();
        return instance;

    }
    
    
}
