package com.mygdx.game.gameobjects;

/**
 * Created by Kir on 31.12.2016.
 */

interface Moveable {
    static int movement = 100;

    void update(float dt);
    void dispose();
}
