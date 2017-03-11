/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *
 * @author sabinaadamska
 */
public class Stone extends DynamicBody{
    
    public Stone(World w){
    super(w);
    Shape stoneShape = new CircleShape(2);
    SolidFixture fix = new SolidFixture(this,stoneShape);
    }
    
}
