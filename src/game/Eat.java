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
 *Thanks to this class Walker can "eat" elements. When he touches them, they are destroyed
 * @author sabinaadamska
 * 
 */
public class Eat implements CollisionListener {

    private final Pepe pepe;
    private SoundClip gameSound;

    /**
     * Constructor for objects of class Eat.
     * @param pepe  object that is destroying other objects
     * 
     */
    public Eat(Pepe pepe) {
        this.pepe = pepe;
    }

    @Override
    public void collide(CollisionEvent ce) {

        if (ce.getOtherBody() == pepe) {
            pepe.incrementFlyCount();
            ce.getReportingBody().destroy();

            try {
                gameSound = new SoundClip("data/cartoon.wav");  
                gameSound.play();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }

    }

}
