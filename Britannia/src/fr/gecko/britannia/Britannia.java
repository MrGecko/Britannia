package fr.gecko.britannia;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import fr.gecko.britannia.resource.BritanniaAssetManager;
import fr.gecko.level.LevelController;
import fr.gecko.stage.GameStage;


public class Britannia implements ApplicationListener {

	private static BritanniaAssetManager assetManager;
	private LevelController levelCtrl;
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

		levelCtrl = new LevelController(stage.getCamera(), stage.getRoot());		
		levelCtrl.loadLevel(assetManager.get("../Britannia-android/assets/small-level.tmx", TiledMap.class));

		
	}

	@Override
	public void resize (int width, int height) {
		stage.setViewport(width, height, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());	        

		//render tiles and game objects 
		levelCtrl.render();
		
		stage.draw();
		
		Table.drawDebug(stage); 
	}

	@Override
	public void dispose() {
		levelCtrl.dispose();
		stage.dispose();
	}


	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
