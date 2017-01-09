package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.OnStartState;

public class MyGdxGame extends ApplicationAdapter {

	private GameStateManager gsm;
	private SpriteBatch batch;
	private Music music;

	public final static int WIDTH = 1024;
	public final static int HEIGHT = 800;
	public final static String NAME = "VikingDemo";
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		gsm.push(new OnStartState(gsm));
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setVolume(0.3f);
		music.setLooping(true);
		music.play();
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}

	@Override
	public void pause() {
		super.pause();

	}

	@Override
	public void resume() {
		super.resume();
	}

}
