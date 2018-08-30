/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import city.cs.engine.SolidFixture;
/**
 *Simple platform 
 * @author sabinaadamska
 */
public class Platform extends StaticBody {
    

    public Platform(World w) {
        super(w);

        Shape platformShape = new BoxShape(2, 0.5f);
        Fixture platformFixture = new SolidFixture(this, platformShape);

    }
}
