package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Kir on 29.12.2016.
 */

interface Jumpeable {

    int gravity = -15;

    Vector3 getPosition();
    Texture getTexture();

    void jump();
    void update(float dt);
    void dispose();
}
