package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Pers;

/**
 * Created by Kir on 29.12.2016.
 */

public class PlayState extends State {

    private Texture ground;
    private Pers pers;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        pers = new Pers(50,50);
        ground = new Texture("ground.png");
        camera.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT );
    }

    @Override
    void handleInput() {

    }

    @Override
    void update(float dt) {
        pers.update(dt);
    }

    @Override
    void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(ground, 0, 0);
        sb.draw(pers.getPers(), pers.getPosition().x, pers.getPosition().y);
        sb.end();
    }

    @Override
    void dispose() {

    }
}
