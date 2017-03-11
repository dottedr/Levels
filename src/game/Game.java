

package game;

import city.cs.engine.*;
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The platform game
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    
    private int level;
    private KeyboardEvents controller;
    private MouseEvents mouseController;
    
    private SoundClip gameMusic;
        

    /** Initialise a new Demo. */
    public Game() {
       
        // make the world
        //world = new GameWorld();
        level = 1;
        world = new Level1();
        world.populate(this);
        /*
        try {
            gameMusic = new SoundClip("data/Pan Volf - Holding U.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }  */


        // make a view, TODO:later change to MyView
        view = new MyView(world, 500, 500);
        
        //mini view
        UserView wideView = new UserView(world, 500, 100);
        wideView.setZoom(4);
     
        
        //view.addKeyListener(new KeyboardEvents(world.getPlayer())); 

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseEvents(world.getPlayer()));

        // display the view in a frame
        final JFrame frame = new JFrame("Encapsulation Demo");
        frame.add(wideView, BorderLayout.SOUTH);

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
        //frame.addKeyListener(new KeyboardEvents(world.getPlayer()));
        //frame.addMouseListener(new MouseEvents(world.getPlayer()));
        //uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1100, 500);
        world.addStepListener(new Tracker(view,world.getPlayer()));
        
        controller = new KeyboardEvents(world.getPlayer());
        frame.addKeyListener(controller);
        
        mouseController = new MouseEvents(world.getPlayer());
        frame.addMouseListener(mouseController);

        // start!
        world.start();
    }

 

    public Pepe getPlayer() {
        return world.getPlayer();
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    public void goNextLevel() {
        world.stop();
        if (level == 2) {
            System.exit(0);
        } else {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            mouseController.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }
      /** Run the demo. */
    public static void main(String[] args) {
        new Game();
    }
    

}

