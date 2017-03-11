/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Walker;
import city.cs.engine.World;
import city.cs.engine.WorldView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska
 */
public class MouseEvents extends MouseAdapter {

    
   
    private Walker body;
    private static final float JUMPING_SPEED = 12;

    public MouseEvents(Walker body) {

        this.body = body;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        //System.out.print("DSDSDDS"+p);
        body.jump(JUMPING_SPEED);

    }

    public void setBody(Walker body) {
        this.body = body;
    }
}
