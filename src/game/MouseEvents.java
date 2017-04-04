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
 *
 * @author sabinaadamska
 */
public class MouseEvents extends MouseAdapter {

    private Bullet bullet;
    //private static final float JUMPING_SPEED = 12;

    public MouseEvents(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(bullet);
        //bullet.setPosition(new Vec2(26,5));
        bullet.setLinearVelocity(new Vec2(-10, 0));
        

    }

    public void setBody(Bullet bullet) {
        this.bullet = bullet;
    }
}
