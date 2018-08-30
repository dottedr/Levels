/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * Walker, player, eats flies, looses points when is hit by an enemy
 * @author sabinaadamska
 */
public class Pepe extends Walker {

    private Shape shape;
    private int flyCount;
    private int hp;

    private String lost;

    /**
     * Constructor of the Pepe class
     *
     * @param world inherited world
     */
    public Pepe(World world) {
        super(world);
        /**
         *Pepe's properties
         */
        flyCount = 0;
        hp = 100;

        lost = "You have lost!";

        shape = new PolygonShape(-0.45f, -0.32f, -1.66f, -0.39f, -2.21f, -0.63f, -2.23f, -0.87f, -1.3f, -1.23f);
        SolidFixture fixture = new SolidFixture(this, shape);

        Shape shape2 = new PolygonShape(-1.3f, -1.23f, -1.48f, -2.08f, 0.8f, -2.15f, 1.35f, 1.06f);
        SolidFixture fixture2 = new SolidFixture(this, shape2);

        Shape shape3 = new PolygonShape(1.35f, 1.06f, 0.93f, 1.8f, -0.07f, 1.84f, -0.67f, 0.42f, -0.38f, -0.37f);
        Fixture fixture3 = new SolidFixture(this, shape3);

        fixture2.setFriction(1);

        addImage(new BodyImage("data/frogSit.png", 6));

    }
/**
 * 
 * @return getHP Pepe's health points
 */
    public int getHP() {
        return hp;
    }
/**
 * increments number of eaten flies, increased score
 */
    public void incrementFlyCount() {
        flyCount++;

    }
/**
 * decrements Pepe's health points 
 */
    public void decrementHP() {
        hp = hp - 20;

    }
/**
 * 
 * @return flyCount return number of eaten flies
 */
    public int getFlyCount() {
        return flyCount;
    }

}
