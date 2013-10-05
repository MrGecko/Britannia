package fr.gecko.level;

import com.badlogic.gdx.maps.tiled.TiledMap;


public class LevelLoader {
	
	public static GameLevel load(LevelController levelCtrl, TiledMap map) {
		levelCtrl.getMapController().loadTiledMap(map);
		
		GameLevel newLevel = new GameLevel(levelCtrl);
		
		return newLevel;
	}

}
