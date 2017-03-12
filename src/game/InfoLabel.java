/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author sabinaadamska
 */
public class InfoLabel extends JLabel implements ChangeListener {
        private Game game;
    public InfoLabel(Game game){
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        
    }
    
}
