/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 * A keyboard listener.
 * @author sabinaadamska
 */
public class KeyboardEvents extends KeyAdapter {

    private static final float WALKING_SPEED = 8;
    private static final float JUMPING_SPEED = 12;

    private Walker body;
   
/**
     * Initialize the listener.
     * @param body the component that will react to keyPressed() and keyReleased().
     */
    public KeyboardEvents(Walker body) {
        this.body = body;
     
    }
    /**
     * Called when the key is pressed.
     * @param e description of key pressed event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED);

        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED);
            
        } else if (code == KeyEvent.VK_W) {
            body.jump(JUMPING_SPEED);
        } 


    }
    /**
     * Called when the key is released.
     * @param e description of key released event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_S) {
            body.stopWalking();       
        } else if (code == KeyEvent.VK_A) {
            body.stopWalking();
        }
    }

    public void setBody(Walker body) {
        this.body = body;
    }

}
