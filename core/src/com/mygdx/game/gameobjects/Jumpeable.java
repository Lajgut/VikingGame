package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kir on 29.12.2016.
 */

public interface Jumpeable {

    int gravity = -15;

    void update(float dt);
    Vector3 getPosition();
    Texture getTexture();
    void jump();


}
