/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Class designed as collision between Pepe and fork
 * @author sabinaadamska
 */
public class ForkHit implements CollisionListener{
    private Pepe pepe;
    public ForkHit(Pepe pepe){
        this.pepe=pepe;
    }
    @Override
    public void collide(CollisionEvent ce) {

        if (ce.getOtherBody() == pepe) {
            pepe.decrementHP();
            //ce.getReportingBody().destroy();
        }
    }
}
