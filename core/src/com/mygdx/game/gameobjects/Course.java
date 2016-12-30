package com.mygdx.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Kir on 30.12.2016.
 */

public class Course {

    public static final int COURSE_HEIGHT = 150;
    public static final int RANDOM_HEIGHT = 100;
    public static final int COURSE_WIDTH = 100;

    Texture course;
    Vector2 posCourse;
    Random random;

    public Texture getCourse() {
        return course;
    }

    public Vector2 getPosCourse() {
        return posCourse;
    }

    public Course(float x){
        course = new Texture("course.png");
        random = new Random();
        posCourse = new Vector2(x, random.nextInt(RANDOM_HEIGHT) + COURSE_HEIGHT);

    }
}
