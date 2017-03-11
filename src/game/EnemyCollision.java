/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author sabinaadamska
 */
public class EnemyCollision implements CollisionListener {
    private Pepe pepe;

    public EnemyCollision(Pepe pepe){
        this.pepe=pepe;
    }


    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == pepe){
            pepe.decrementHP();
            e.getReportingBody().setAngleDegrees(-18);
        }

    }
}
