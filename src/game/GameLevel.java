/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska
 */
public abstract class GameLevel extends World{
    private Pepe player;
    public Color magic; 
   public Bullet bullet;
    public Pepe getPlayer(){
        return player;
    }
      Bullet getBullet() {
        return bullet;
    }
    public void populate(Game game){
        magic= new Color(11,0,12);
        player = new Pepe(this);
        player.setPosition(startPosition());
        Stone portal = new Stone(this);
        portal.setPosition(doorPosition());
        portal.addCollisionListener(new PortalListener(game));
        portal.setFillColor(magic);
        bullet = new Bullet(this);
        bullet.setPosition(new Vec2(25,-5));
    }
    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract boolean isCompleted();

  
}
