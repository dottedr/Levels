/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author sabinaadamska
 */
public class Bullet extends DynamicBody {
   

    public Bullet(World w) {
        super(w);
        Shape bulletShape = new PolygonShape(-1.33f, -0.67f, -1.47f, -0.22f, 0.03f, 1.46f, 1.45f, 0.79f, 1.42f, 0.35f, 0.13f, -1.46f);
        Fixture bulletFixture = new SolidFixture(this, bulletShape);
        addImage(new BodyImage("data/bullet.png", 3));
 
    }

    

}
