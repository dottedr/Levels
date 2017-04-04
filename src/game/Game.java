package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * The platform game
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    private Pepe pepe;
    public Bullet bullet;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;
    private int level;
    private KeyboardEvents controller;
    private MouseEvents mouseController;

    private SoundClip gameMusic;

    JFrame frame;

    /**
     * Initialise a new Demo.
     */
    public Game() {

        // make the world
        //world = new GameWorld();
        level = 1;
        world = new Level1();
        world.populate(this);
        bullet = world.getBullet();

        try {
            gameMusic = new SoundClip("data/Mortal Kombat Soundtrack.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        //this.music();
        //whole window
        frame = new JFrame("Pepe game");
        view = new MyView(world, this, 650, 500);

        //add side panel       
        Container sidePanel = new ControlPanel(world, pepe, this);
        frame.add(sidePanel, BorderLayout.EAST);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(true);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        frame.requestFocus();

        //JFrame debugView = new DebugViewer(world, 1100, 500);
        world.addStepListener(new Tracker(view, world.getPlayer()));
        //instatiate event to switch the keyboard control to the new player
        controller = new KeyboardEvents(world.getPlayer());
        frame.addKeyListener(controller);

        mouseController = new MouseEvents(bullet);
        frame.addMouseListener(mouseController);

        // start!
        world.start();

    }

    public Pepe getPlayer() {
        return world.getPlayer();
    }

    public Bullet getBullet() {
        return world.getBullet();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public void goNextLevel() {
        world.stop();
        if (level == 4) {
            System.exit(0);

        } else if (level == 1) {
            level++;
           
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
             bullet = world.getBullet();

            // switch the keyboard control to the new player
            frame.addKeyListener(controller);
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            frame.requestFocus();
            
            mouseController = new MouseEvents(bullet);
            frame.addMouseListener(mouseController);
            world.start();

        } else  if (level == 2) {
            level++;
            bullet = world.getBullet();
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            bullet = world.getBullet();

            frame.addMouseListener(mouseController);
            mouseController.setBody(bullet);
            frame.addKeyListener(controller);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            // show the new world in the view
            view.setWorld(world);
            world.addStepListener(new Tracker(view, world.getPlayer()));
            frame.requestFocus();
            world.start();
        }
         else  if (level == 3) {
            //level++;

            System.exit(0);
        }
        else  if ((level == 3)&& pepe.getFlyCount()!=0) {
            //level++;

            System.out.println("GG mate");
        }

    }

    public int getLevel() {
        return level;
    }

    /**
     * Run the demo.
     */
    public static void main(String[] args) {
        new Game();
    }

    public World getWorld() {
        return world;
    }

    public void nomusic() {
        gameMusic.stop();
    }
}
