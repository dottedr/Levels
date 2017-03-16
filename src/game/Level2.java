/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import java.awt.Color;
import static java.awt.Color.BLUE;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska
 */
public class Level2 extends GameLevel {
    //private Pepe pepe;
    public Color khaki,magic;
    public Vec2 g= new Vec2(22, 0);

    
     

    @Override
    public void populate(Game game){
        super.populate(game);
        khaki= new Color(105,94,24);
        /******************HOW TO MOVE***********************/
        System.out.println("Use keys A ans S to walk, click left mouse button to jump");
        System.out.println("Storks are your enemies, flies are your food.");
        System.out.println("Collect all the flies and go to black ball");
        
        // make the ground
        Shape groundShape = new BoxShape(5, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fix= new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(30, -11.5f));
        ground.setFillColor(khaki);
        fix.setFriction(1);
        
        Body piranha = new Piranha(this);
        piranha.setPosition(new Vec2(0,-8));
        piranha.addCollisionListener(new PiranhaHit(getPlayer()));
        
        Body piranha2 = new Piranha(this);
        piranha2.setPosition(new Vec2(-33,-8));
        piranha2.addCollisionListener(new PiranhaHit(getPlayer()));
        
        
        
        
        Shape waterBottom = new BoxShape(30,1);
        Body water = new StaticBody(this, waterBottom);
        water.setPosition(new Vec2(0,-12));
        water.setFillColor(BLUE);
        

        // make a platform
        Shape platformShape = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(15, -5.5f));
        
        Shape platformShape2 = new BoxShape(2, 0.5f);
        Body platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(-25, 0));
        
        for (int i = 0; i < 3; i++) {
            Body platform= new Platform(this);
            platform.setPosition(new Vec2(i*8-10,i*-1.1f));
            
        } 
        
   
        //fly
        for (int i = 1; i < 4; i++) {
            Body fly= new Fly(this);
            fly.setPosition(new Vec2(i*8-15,-i*2f+5.2f));
            fly.addCollisionListener(new Eat(getPlayer()));
        }
        
        //stork
        Body stork = new Stork(this);
        stork.setPosition(new Vec2(-9,12));
        stork.addCollisionListener(new EnemyCollision(getPlayer()));
        
        Body stork2 = new Stork(this);
        stork2.setPosition(new Vec2(5,7));
        stork2.addCollisionListener(new EnemyCollision(getPlayer()));
        
        


    }
    @Override
    public Vec2 startPosition() {
        return new Vec2(27,-2);
    }
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-25,12);
    }
    @Override
    public boolean isCompleted() {
        return getPlayer().getFlyCount() == 3;
    }
}
