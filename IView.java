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
public interface IView {
    public void openStartWindow();

    public void closeStartWindow();	

    public void openNewGameWindow();

    public void closeNewGameWindow();

    public void openMainGUI();
	
    public void gameOverDialog();

}
