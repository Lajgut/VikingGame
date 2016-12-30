package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.states.PlayState;

/**
 * Created by Kir on 29.12.2016.
 */

public class Pers implements Jumpeable {


    private Vector3 position;
    private Vector3 velocity;
    private Texture pers;

    public Pers(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        pers = new Texture("pers_m.png");
    }


    @Override
    public void update(float dt) {
        if (position.y > 0) velocity.add(0, gravity, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        if (position.y <= PlayState.getGroundEnd()){
            position.y = PlayState.getGroundEnd();
        }
        velocity.scl(1 / dt);
    }

    @Override
    public Vector3 getPosition() {
        return position;
    }

    @Override
    public Texture getTexture() {
        return pers;
    }

    @Override
    public void jump() {
        velocity.y = 550;
    }


}
