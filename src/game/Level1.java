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
import city.cs.engine.World;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska
 */
public class Level1 extends GameLevel{
    public Color khaki,magic;
   // private Pepe pepe;
   // public Bullet bullet;
    
    
    @Override
    public void populate(Game game){
        super.populate(game);
        khaki= new Color(105,94,24);

        //fly
        for (int i = 0; i < 10; i++) {
            Body fly= new Fly(this);
            fly.setPosition(new Vec2(i*6-25,i*-1.1f));
            fly.addCollisionListener(new Eat(getPlayer()));
        }
        //bullet= new Bullet(this);
        
       
        
        //stork
        Body stork = new Stork(this);
        stork.setPosition(new Vec2(-9,0));
        stork.addCollisionListener(new EnemyCollision(getPlayer()));
        stork.addCollisionListener(new PiranhaFight(bullet));
        
        Body stork2 = new Stork(this);
        stork2.setPosition(new Vec2(5,0));
        stork2.addCollisionListener(new EnemyCollision(getPlayer()));
        stork2.addCollisionListener(new PiranhaFight(bullet));
        
        //wall
        Shape obstacleWallShape = new BoxShape(0.5f, 5);
        Body obstacleWall = new StaticBody(this, obstacleWallShape);
        obstacleWall.setPosition(new Vec2(-21, -6.5f));
        obstacleWall.setFillColor(khaki);
        
        // make the ground
        Shape groundShape = new BoxShape(35, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fix= new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        ground.setFillColor(khaki);
        fix.setFriction(1);
        

        // make a platform
        Shape platformShape = new BoxShape(6, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, 5.5f));
        
        Shape platformShape2 = new BoxShape(2, 0.5f);
        Body platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(10, 0));
        
        


    }
    @Override
        public Vec2 startPosition() {
        return new Vec2(30, -7);
    }
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-25,-2);
    }
    @Override
    public boolean isCompleted() {
        return getPlayer().getFlyCount() > 5;
    }
    
    
}
