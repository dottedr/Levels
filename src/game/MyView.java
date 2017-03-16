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
    private Image over;
    private Game game;
    private World world;
    
    

    public MyView(World world, Game game, int width, int height) {
        super(world, width, height);
        background = new ImageIcon("data/background.jpg").getImage();
        over = new ImageIcon("data/gameover.jpg").getImage();
        this.game = game;
        int hp = game.getPlayer().getHP();
        
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        int hp = game.getPlayer().getHP();
        if(hp>0){
        g.drawString("Score: " + game.getPlayer().getFlyCount(), 10, 20);
        g.drawString("HP:" + hp, 10, 40);}
        else{
        g.drawString("Score: " + game.getPlayer().getFlyCount(), 10, 20);
        g.drawString("Sorry Mate, you have lost" , 10, 40);
        g.drawString("Score" + hp, 10, 60);
        //world.stop();
        g.drawImage(over, 0, 0, this);        }
        
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
}
