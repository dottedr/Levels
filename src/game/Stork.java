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
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author sabinaadamska
 */
public class Stork extends StaticBody {

    public Stork(World world) {
        super(world);
        
        Shape storkShape = new PolygonShape (2.58f,1.42f, 2.56f,1.78f, 0.94f,1.68f, -4.72f,-1.7f, -4.62f,-2.06f, 1.88f,0.14f);
        Fixture storkFixture = new SolidFixture(this,storkShape);
        
        Shape storkShape2 = new PolygonShape (-1.64f,-0.94f, 3.4f,-1.44f, 2.72f,-1.08f, 0.78f,-0.22f);
        Fixture storkFixture2 = new SolidFixture(this,storkShape2);
        
        Shape storkShape3 = new PolygonShape (2.8f,-1.24f, 4.84f,-2.06f, 3.14f,-0.98f, 2.8f,-1.06f);
        Fixture storkFixture3 = new SolidFixture(this,storkShape3);
        
        addImage(new BodyImage("data/stork.png",4));
    }
    
}
