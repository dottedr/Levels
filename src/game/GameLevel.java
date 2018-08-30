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
 * An abstract model for a game level. This class is intended to be extended
 * with a class containing actual data.
 *
 * @author sabinaadamska
 */
public abstract class GameLevel extends World {
    /**
     * @param magic color of the portal to the next level
     */
    private Pepe player;
    public Color magic;
    public Bullet bullet;
    /**
     * 
     * @return player
     */

    public Pepe getPlayer() {
        return player;
    }
     /**
      * 
      * @return 
      */
    public Bullet getBullet() {
        return bullet;
    }

    public void populate(Game game) {
        magic = new Color(11, 0, 12);
        player = new Pepe(this);
        player.setPosition(startPosition());
        Stone portal = new Stone(this);
        portal.setPosition(doorPosition());
        portal.addCollisionListener(new PortalListener(game));
        portal.setFillColor(magic);
        bullet = new Bullet(this);
        bullet.setPosition(new Vec2(25, -5));
    }
     /**
     * Set the starting position of a player.
     */
    public abstract Vec2 startPosition();
     /**
     * Set the  position of a portal to the next level.
     */
    public abstract Vec2 doorPosition();
     /**
     * Set the condition to finish the level.
     */
    public abstract boolean isCompleted();

}
