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
 *This class describes what happens when Pepe hits an enemy.
 * @author sabinaadamska
 * 
 */
public class EnemyCollision implements CollisionListener {
    private Pepe pepe;
    /**
     * Constructor for objects of class EnemyCollision.
     * @param pepe  object that is colliding with other objects
     * 
     */
    public EnemyCollision(Pepe pepe){
        this.pepe=pepe;
    }
    
    /**
     * Decrement pepe's HP and rotate enemy.
     * @param e 
     * 
     * */
    @Override
    public void collide(CollisionEvent e){
        if(e.getOtherBody() == pepe){
            pepe.decrementHP();
            e.getReportingBody().rotateDegrees(-18);
        }

    }
}
