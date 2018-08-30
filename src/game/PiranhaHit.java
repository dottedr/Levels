/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * Class designed for collision between Piranha and Pepe
 * @author sabinaadamska
 */
public class PiranhaHit implements CollisionListener {

    private Pepe pepe;

    public PiranhaHit(Pepe pepe) {
        this.pepe = pepe;
    }

    @Override
    public void collide(CollisionEvent ce) {

        if (ce.getOtherBody() == pepe) {
            pepe.decrementHP();
            
        }
    }

}
