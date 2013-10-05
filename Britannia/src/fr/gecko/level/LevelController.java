package fr.gecko.level;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Group;

import fr.gecko.level.map.MapController;

public class LevelController {

	private GameLevel currentLevel;
	private MapController mapCtrl;
	//private Stage stage;
	private Group actorGroup;

	public LevelController(Camera camera, Group rootGroup) {
		//this.stage = stage;
		actorGroup = new Group();
		actorGroup.setName("game objects");
		rootGroup.addActor(actorGroup);
		
		this.mapCtrl = new MapController(camera, actorGroup);
	}

	public MapController getMapController() {
		return mapCtrl;
	}
	
	public GameLevel getCurrentLevel() {
		return currentLevel;
	}
	
	public void loadLevel(TiledMap map) {		
		actorGroup.clear();
		currentLevel = LevelLoader.load(this, map);
	}

	public void render() {
		if (currentLevel != null)
			currentLevel.render();
	}

	public void dispose() {
		mapCtrl.dispose();
	}
}
	