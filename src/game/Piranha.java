/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author sabinaadamska
 */
public class Piranha extends DynamicBody {

    public Piranha(World w) {
        super(w);
        Shape fishShape = new PolygonShape(-1.58f, 0.3f, -0.64f, 1.88f, 2.6f, -0.35f, 2.61f, -0.91f, -1.06f, -1.84f);
        Fixture flyFixture = new SolidFixture(this, fishShape);
        addImage(new BodyImage("data/piranha.png", 4));
        this.setLinearVelocity(new Vec2(10, 0));

    }

}
/*        
        if(this.getPosition().x>-20){
            this.setLinearVelocity(new Vec2(10,0));
        }else if(this.getPosition().x<15){
            this.setLinearVelocity(new Vec2(-10,0));
*/
