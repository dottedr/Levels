/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;

/**
 * This class waits for mouse to be clicked to perform actions listed below
 * @author sabinaadamska
 */
public class MouseEvents extends MouseAdapter {
/**
 * @param bullet bullet that is being moved when the mouse is clicked
 */
    private Bullet bullet;
    

    public MouseEvents(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(bullet);
        bullet.setLinearVelocity(new Vec2(-10, 10));
        

    }

    public void setBody(Bullet bullet) {
        this.bullet = bullet;
    }
}
