package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.states.PlayState;

import java.util.Random;

/**
 * Created by Kir on 30.12.2016.
 */

public class Course {

    public static final int COURSE_HEIGHT = 25;
    public static final int RANDOM_HEIGHT = 15;
    public static final int COURSE_WIDTH = 20;
    public static final int RANDOM_WIDTH = 10;

    private Texture course;
    private Vector2 posCourse;
    private float courseHeight, courseWidth;
    private Rectangle bounds;

    public Course(float x){
        course = new Texture("course.png");
        Random random = new Random();
        posCourse = new Vector2(x, PlayState.getGroundEnd());
        courseHeight = random.nextInt(RANDOM_HEIGHT) + COURSE_HEIGHT;
        courseWidth = random.nextInt(RANDOM_WIDTH) + COURSE_WIDTH;
        bounds = new Rectangle(posCourse.x, posCourse.y, courseWidth, courseHeight);
    }

    public void reposition(float x){
        posCourse.set(x, PlayState.getGroundEnd());
        bounds.setPosition(x, posCourse.y);
    }

    public boolean collides(Rectangle pers){
        return pers.overlaps(bounds);
    }

    public Texture getCourse() {
        return course;
    }

    public Vector2 getPosCourse() {
        return posCourse;
    }

    public float getCourseWidth() {
        return courseWidth;
    }

    public float getCourseHeight() {
        return courseHeight;
    }

    public void dispose() {
        course.dispose();
    }
}
