/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author sabinaadamska
 */
public class MyView extends UserView {

    private Image background;
    private Game game;

    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.jpg").getImage();
        this.game = game;
    }



    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + game.getPlayer().getFlyCount(), 10, 20);
    }
    
        @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
}
