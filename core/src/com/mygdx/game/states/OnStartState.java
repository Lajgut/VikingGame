package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

import java.util.Map;

/**
 * Created by Kir on 29.12.2016.
 */

public class OnStartState extends State{

    Texture startBtn;

    public OnStartState(GameStateManager gsm) {
        super(gsm);
        startBtn = new Texture("start.png");
    }

    @Override
    void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    void update(float dt) {
        handleInput();
    }

    @Override
    void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(startBtn, (Gdx.graphics.getWidth() / 2) - (startBtn.getWidth() / 2), (Gdx.graphics.getHeight() / 2) - (startBtn.getHeight() / 2));
        sb.end();
    }

    @Override
    void dispose() {

    }
}
