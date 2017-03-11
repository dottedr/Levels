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
 */
public class Eat implements CollisionListener{

    private final Pepe pepe;
    
    public Eat(Pepe pepe){
        this.pepe=pepe;
    }

    @Override
    public void collide(CollisionEvent ce) {
        
        if (ce.getOtherBody() == pepe) {
            pepe.incrementFlyCount();
            ce.getReportingBody().destroy();
        }
    }
    
}
