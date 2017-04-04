/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author sabinaadamska
 */
public class PiranhaFight implements CollisionListener {

    Bullet bullet;

    public PiranhaFight(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void collide(CollisionEvent ce) {

        if (ce.getOtherBody() == bullet) {
//            bullet.decrementHP();
           // System.out.println(getReportingBody());
            ce.getReportingBody().destroy();

        }
    }

}
