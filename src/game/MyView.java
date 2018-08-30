/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * User view of the game, contains paintForeground and paintBackground
 * @author sabinaadamska
 */
public class MyView extends UserView {

    private Image background;
    private Image background2;
    private Image background3;
    private Image over;
    private Game game;

    /**
     * 
     * @param world inherited world
     * @param game inherited game
     * @param width with of the frame inherited from game 
     * @param height height of the frame inherited from game 
     */

    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.jpg").getImage();
        background2 = new ImageIcon("data/oczko.jpg").getImage();
        background3 = new ImageIcon("data/o41.jpg").getImage();

        this.game = game;

    }
/**
 * 
 * @param g graphics that is being drawn on the foreground
 */
    @Override
    protected void paintForeground(Graphics2D g) {
        Font comicSans = new Font("Verdana", Font.BOLD, 20);
        g.setFont(comicSans);
        g.setColor(Color.white);

        int hp = game.getPlayer().getHP();
        over = new ImageIcon("data/over.jpg").getImage();

        if (hp > 0) {
            g.drawString("Score: " + game.getPlayer().getFlyCount() , 10, 20);
            g.drawString("HP:" + hp, 10, 40);
        } else {
            g.drawImage(over, 0, 0, this);
            g.drawString("Score: " + game.getPlayer().getFlyCount(), 10, 20);
            g.drawString("Healh: " + hp, 10, 60);

        }

    }
/**
 * 
 * @param g graphics that is being drawn in the background
 */
    @Override
    protected void paintBackground(Graphics2D g) {
        int level = game.getLevel();
/**
 * background image depends on the level
 */
        if (level == 1) {
            g.drawImage(background, 0, 0, this);
        } else if (level == 2) {
            g.drawImage(background2, 0, 0, this);
        } else if (level == 3) {
            g.drawImage(background3, 0, 0, this);
        }

    }

}
