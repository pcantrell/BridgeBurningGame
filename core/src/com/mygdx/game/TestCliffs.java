package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Eloise on 2/28/16.
 */

public class TestCliffs {

    Body bodyLeft;
    Body bodyRight;
    Texture img;
    Sprite spriteLeft;
    Sprite spriteRight;

    public void CreateCliffs(Texture texture, World world) {
        // Sets image to one in Texture folder
        img = texture;

        //Creates two Sprites with this image
        spriteLeft = new Sprite(img);
        spriteRight = new Sprite(img);

        //Places the cliffs on either end of the screen
        spriteLeft.setPosition(0, 0);
        spriteRight.setPosition(800 - spriteRight.getWidth(), 0);



        //Defines the body to be able to have physics applied to it
        BodyDef bodyDef1 = new BodyDef();
        bodyDef1.type = BodyDef.BodyType.StaticBody;
        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type = BodyDef.BodyType.StaticBody;

        //puts the body in a specific spot over the sprite
        bodyDef1.position.set(spriteLeft.getX(), spriteLeft.getY());
        bodyDef2.position.set(spriteRight.getX(), spriteRight.getY());


        bodyLeft = world.createBody(bodyDef1);
        bodyRight = world.createBody(bodyDef2);


        //Makes a shape for the body, Sets the shape to a box
        PolygonShape shape1 = new PolygonShape();
        shape1.setAsBox(spriteLeft.getWidth()/4, spriteLeft.getHeight()/4);
        PolygonShape shape2 = new PolygonShape();
        shape2.setAsBox(spriteLeft.getWidth()/4, spriteLeft.getHeight()/4);

        //Describes the properties of the fixture
        FixtureDef fixtureDef1 = new FixtureDef();
        fixtureDef1.shape = shape1;
        fixtureDef1.density = 1f;

        FixtureDef fixtureDef2 = new FixtureDef();
        fixtureDef2.shape = shape2;
        fixtureDef2.density = 1f;


        Fixture fixture1 = bodyLeft.createFixture(fixtureDef1);
        Fixture fixture2 = bodyRight.createFixture(fixtureDef2);


        shape1.dispose();
        shape2.dispose();


    }

    public Body getBodyLeft(){return this.bodyLeft;}
    public Body getBodyRight(){return this.bodyRight;}

}
