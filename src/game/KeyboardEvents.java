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
 *
 * @author sabinaadamska
 */
public class KeyboardEvents extends KeyAdapter {

    private static final float WALKING_SPEED = 8;
    private static final float JUMPING_SPEED = 12;

    private Walker body;
   

    public KeyboardEvents(Walker body) {
        this.body = body;
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED);
            // body.addImage(new BodyImage("data/frogJump.png",6));

        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED);
            //body.addImage(new BodyImage("data/frogJump.png",6));
        } else if (code == KeyEvent.VK_W) {
            //body.getShape();
            body.jump(JUMPING_SPEED);
        } 


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_S) {
            body.stopWalking();
            // body.addImage(new BodyImage("data/frogSit.png",6));
        } else if (code == KeyEvent.VK_A) {
            body.stopWalking();
            //body.addImage(new BodyImage("data/frogSit.png",6));
        }
    }

    public void setBody(Walker body) {
        this.body = body;
    }

}
