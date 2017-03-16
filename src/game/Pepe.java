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
import city.cs.engine.WorldView;

/**
 *
 * @author sabinaadamska
 */
public class Pepe extends Walker {

    private Shape shape;
    private int flyCount;
    private int hp;
    private String win;
    private String lost;
    private World world;

    public Pepe(World world) {
        super(world);
        flyCount = 0;
        hp = 100;
        win = "GG mate, you came to the holy grail for froggies.";
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

    public int getHP() {
        return hp;
    }

    public String getWin() {
        return win;
        
    }
    
    
    public void incrementFlyCount() {
        flyCount++;
        //System.out.println("You collected: " + flyCount + " flies");
    }

    public void decrementHP() {
        hp = hp - 20;
        if (hp == 40) {
            System.out.println("Outch! HP left " + hp + "/60");
        } else if (hp == 20) {
            System.out.println("Be careful! One more time and stork is gonna eat you HP left " + hp + "/60");
        } else if (hp == 0) {
            this.printLost();
            //world.stop();
        }
    }

    public void printWin() {
        System.out.println(win);
    }
    
    public String printLost(){
       return lost;
    }
    

    public int getFlyCount() {
        return flyCount;
    }

    public Shape getShape() {
        return shape;
    }
}
