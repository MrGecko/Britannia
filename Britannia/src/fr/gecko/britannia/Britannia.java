package fr.gecko.britannia;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import fr.gecko.resource.BritanniaAssetManager;
import fr.gecko.stage.GameStage;


public class Britannia implements ApplicationListener {

	private static BritanniaAssetManager assetManager;
	private GameStage stage;
	
	public static BritanniaAssetManager getAssetManager() {
		return assetManager;
	}
	

	@Override
	public void create () {	
				
		assetManager = new BritanniaAssetManager();
		assetManager.startLoading();
		assetManager.finishLoading();
		
		stage = new GameStage();
	}

	@Override
	public void resize (int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.render(Gdx.graphics.getDeltaTime());	        
		
		Table.drawDebug(stage); 
	}

	@Override
	public void dispose() {
		//levelCtrl.dispose();
		stage.dispose();
	}


	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
