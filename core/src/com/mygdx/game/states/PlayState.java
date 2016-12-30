package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gameobjects.Course;
import com.mygdx.game.gameobjects.Pers;

/**
 * Created by Kir on 29.12.2016.
 */

public class PlayState extends State {

    private static final int groundEnd = Gdx.graphics.getHeight() / 4;
    private Texture ground;
    private Pers pers;
    private Course course;

    public static int getGroundEnd() {
        return groundEnd;
    }

    public PlayState(GameStateManager gsm) {
        super(gsm);
        pers = new Pers(50, getGroundEnd());
        ground = new Texture("ground.png");
        course = new Course(200);
        camera.setToOrtho(false, Gdx.graphics.getWidth() / 2 , Gdx.graphics.getHeight() / 2);
    }

    @Override
    void handleInput() {
        if (Gdx.input.justTouched()) pers.jump();
    }

    @Override
    void update(float dt) {
        pers.update(dt);
        if (pers.getPosition().y == getGroundEnd()) handleInput();
    }

    @Override
    void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(ground, 0, 0, Gdx.graphics.getWidth(), getGroundEnd());
        sb.draw(course.getCourse(), course.getPosCourse().x, course.getPosCourse().y);
        sb.draw(pers.getTexture(), pers.getPosition().x, pers.getPosition().y);
        sb.end();
    }

    @Override
    void dispose() {
        ground.dispose();
    }
}
