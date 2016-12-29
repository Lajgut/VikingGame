package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kir on 29.12.2016.
 */

public class Pers {

    public static final int GRAVITY = -15;
    Vector3 position;
    Vector3 velocity;
    Texture pers;

    public Pers(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        pers = new Texture("pers.png");
    }

    public void update(float dt){
        if (position.y > 0) velocity.add(0, GRAVITY , 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        if (position.y <= 0){
            position.y = 0;
        }
        velocity.scl(1 / dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getPers() {
        return pers;
    }
}
