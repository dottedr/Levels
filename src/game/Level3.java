/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import java.awt.Color;
import static java.awt.Color.BLUE;
import org.jbox2d.common.Vec2;

/**
 * Third level
 * @author sabinaadamska
 */
public class Level3 extends GameLevel {

    public Color khaki;

    /**
     *
     * @param game game being populated by level3 objects
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        khaki = new Color(105, 94, 24);
        /**
         * @param khaki color of the platform
         */
        //fork curvy
        Body curvyfork = new CurvyFork(this);
        curvyfork.setPosition(new Vec2(6, 300));
        curvyfork.addCollisionListener(new PiranhaHit(getPlayer()));
        curvyfork.addCollisionListener(new PiranhaFight(bullet));

        //fork curvy
        Body curvyfork2 = new CurvyFork(this);
        curvyfork2.setPosition(new Vec2(-6, 1000));
        curvyfork2.addCollisionListener(new PiranhaHit(getPlayer()));
        curvyfork2.addCollisionListener(new PiranhaFight(bullet));

        //fork curvy
        Body curvyfork3 = new CurvyFork(this);
        curvyfork3.setPosition(new Vec2(25, 100));
        curvyfork3.addCollisionListener(new PiranhaHit(getPlayer()));
        curvyfork3.addCollisionListener(new PiranhaFight(bullet));
//        
        Body piranha = new Piranha(this);
        piranha.setPosition(new Vec2(0, -8));
        piranha.addCollisionListener(new PiranhaFight(bullet));
        piranha.addCollisionListener(new PiranhaHit(getPlayer()));

        //fly
        for (int i = 1; i < 4; i++) {
            Body fly = new Fly(this);
            fly.setPosition(new Vec2(i * 8 - 15, -i * 2f + 5.2f));
            fly.addCollisionListener(new Eat(getPlayer()));
        }

        Shape waterBottom = new BoxShape(30, 1);
        Body water = new StaticBody(this, waterBottom);
        water.setPosition(new Vec2(0, -12));
        water.setFillColor(BLUE);

        // make a platform
        Shape platformShape = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-17, -4f));

        Shape platformShape2 = new BoxShape(2, 0.5f);
        Body platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(22, -4));

        Body platform3 = new StaticBody(this, platformShape2);
        platform3.setPosition(new Vec2(-25, 3.5f));

        for (int i = 0; i < 2; i++) {
            Body platform = new Platform(this);
            platform.setPosition(new Vec2(i * 10 - 2, i * 6f - 2.1f));
        }

        // make the ground
        Shape groundShape = new BoxShape(5, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fix = new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(30, -11.5f));
        ground.setFillColor(khaki);
        fix.setFriction(1);
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(27, -2);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-25, 12);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getFlyCount() == 3;
    }

    public int score() {
        return 3;
    }
}
