/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Pepe's food, when he "eats" Fly he gets points
 * @author sabinaadamska
 * 
 */
public class Fly extends StaticBody {
   
    public Fly(World w) {
        super(w);
        
        Shape flyShape = new PolygonShape (0.967f,-0.053f, 1.353f,-0.6f, 1.2f,-0.867f, 0.42f,-0.833f, -0.233f,-0.713f, -1.113f,-0.487f, -1.3f,-0.127f);
        Fixture flyFixture = new SolidFixture(this,flyShape);
        
        Shape flyShape2 = new PolygonShape (-1.3f,-0.127f, -1.093f,0.293f, -0.133f,0.593f, 0.893f,0.893f, 1.307f,0.873f, 1.373f,0.72f, 0.933f,-0.047f);
        Fixture flyFixture2 = new SolidFixture(this,flyShape2);

        addImage(new BodyImage("data/fly.png",2));
    }

}
