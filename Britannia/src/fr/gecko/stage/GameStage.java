package fr.gecko.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.IntIntMap;

import fr.gecko.britannia.Britannia;
import fr.gecko.resource.BritanniaAssetManager;
import fr.gecko.fsm.StateManager;
import fr.gecko.level.LevelController;
import fr.gecko.stage.state.GameMainState;

public class GameStage extends Stage {
	
	private LevelController levelCtrl;
	private StateManager fsm;
	
	public StateManager getStateManager() {
		return fsm;
	}
	
	public LevelController getLevelController() {
		return levelCtrl;
	}
	
	protected final IntIntMap keyMap = new IntIntMap();

	@Override
	public boolean keyDown (int keycode) {
		keyMap.put(keycode, keycode);
		return super.keyDown(keycode);
	}
	
	@Override
	public boolean keyUp (int keycode) {
		keyMap.remove(keycode, 0);
		return super.keyUp(keycode);
	}

	public IntIntMap getKeyMap() {
		return keyMap;
	}

	public GameStage() {
		super();
		fsm = new StateManager();

		Gdx.input.setInputProcessor(this);
		setKeyboardFocus(this.getRoot());
		
		BritanniaAssetManager assetManager = Britannia.getAssetManager();
		
		levelCtrl = new LevelController(getCamera(), getRoot());		
		levelCtrl.loadLevel(assetManager.get("../Britannia-android/assets/small-level.tmx", TiledMap.class));
				
		fsm.push(new GameMainState(this));
	}

	
	public void render(float dt) {
		fsm.update(dt);
		fsm.draw();
	}
	
	@Override
	public void dispose() {
		while (!fsm.isEmpty()) {
			fsm.pop();
		}
		super.dispose();
	}

}
