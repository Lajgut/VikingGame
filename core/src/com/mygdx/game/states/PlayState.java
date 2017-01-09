package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gameobjects.Course;
import com.mygdx.game.gameobjects.Pers;

/**
 * Created by Kir on 29.12.2016.
 */

public class PlayState extends State {

    private static final int groundEnd = Gdx.graphics.getHeight() / 6;
    public static final int COURSE_SPACING = 125;
    public static final int COURSE_COUNT = 4;

    private Vector2 groundPos1, groundPos2;
    private Texture ground;
    private Pers pers;
    private Array<Course> courses;

    public static int getGroundEnd() {
        return groundEnd;
    }

    PlayState(GameStateManager gsm) {
        super(gsm);
        pers = new Pers(50, getGroundEnd());
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, 0);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), 0);

        camera.setToOrtho(false, Gdx.graphics.getWidth() / 2 , Gdx.graphics.getHeight() / 2);

        courses = new Array<Course>();
        for (int i = 0; i < COURSE_COUNT; i++){
            courses.add(new Course(i * (COURSE_SPACING + Course.COURSE_WIDTH)));
        }
    }

    @Override
    void handleInput() {
        if (Gdx.input.justTouched()) pers.jump();
    }

    @Override
    void update(float dt) {
        pers.update(dt);
        updateGround();
        if (pers.getPosition().y == getGroundEnd())
            handleInput();

        camera.position.x = pers.getPosition().x + 80;

        for (int i = 0; i < courses.size; i++){

            Course course = courses.get(i);

            if ((camera.position.x - camera.viewportWidth / 2) > (course.getPosCourse().x + course.getCourseWidth())){
                course.reposition(course.getPosCourse().x + (Course.COURSE_WIDTH + COURSE_SPACING) * COURSE_COUNT);
            }
            if (course.collides(pers.getBounds())){
                gsm.set(new OnStartState(gsm));
            }
        }
        camera.update();
    }

    @Override
    void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        for (Course course : courses) {
            sb.draw(course.getCourse(), course.getPosCourse().x, course.getPosCourse().y, course.getCourseWidth(), course.getCourseHeight());
        }
        //sb.draw(ground, 0, 0, Gdx.graphics.getWidth(), getGroundEnd());
        sb.draw(ground, groundPos1.x, groundPos1.y, Gdx.graphics.getWidth(), getGroundEnd());
        sb.draw(ground, groundPos2.x, groundPos2.y, Gdx.graphics.getWidth(), getGroundEnd());
        sb.draw(pers.getTexture(), pers.getPosition().x, pers.getPosition().y);
        sb.end();
    }

    private void updateGround() {
        if (camera.position.x - camera.viewportWidth / 2 > groundPos1.x + ground.getWidth()) {
            groundPos1.add(ground.getWidth() * 2, 0);
        }
        if (camera.position.x - camera.viewportWidth / 2 > groundPos2.x + ground.getWidth()) {
            groundPos2.add(ground.getWidth() * 2, 0);
        }
    }

    @Override
    void dispose() {
        ground.dispose();
        pers.dispose();
        for (Course course : courses){
            course.dispose();
        }
    }
}
