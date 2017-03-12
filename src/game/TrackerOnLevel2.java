/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska

public class TrackerOnLevel2 implements StepListener{
    
       private WorldView view;   
    private Body body;
    
    public TrackerOnLevel2(Body body, WorldView view){
        
        this.view= view;
        this.body = body;
    }
    
        @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        float x = body.getPosition().x;
        float y = view.getCentre().y;
        view.setCentre(new Vec2(x, y));
    }
}
 */