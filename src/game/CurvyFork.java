
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *One of the enemies. Appears only in Level3.
 * @author sabinaadamska
 * 
 */
public class CurvyFork extends DynamicBody{


    public CurvyFork(World w3) {
        super(w3);
         
        Shape headForkShape = new PolygonShape(0.47f,0.034f, 0.761f,0.214f, 1.786f,0.479f, 1.923f,0.137f, 1.0f,-0.265f, 0.658f,-0.154f);
        SolidFixture headFixture = new SolidFixture(this, headForkShape);
        headFixture.setRestitution(0.05f);
        
        Shape handleShape = new PolygonShape(0.658f,0.103f, -1.932f,-0.12f, -1.906f,-0.393f, -0.111f,-0.094f);
        SolidFixture handleFixture = new SolidFixture(this, handleShape);
        addImage(new BodyImage("data/fork2.png", 2));
    }
    
}
