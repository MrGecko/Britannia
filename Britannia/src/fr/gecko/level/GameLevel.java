package fr.gecko.level;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.scenes.scene2d.Group;

import fr.gecko.level.actor.ActorCell;


public class GameLevel {

	LevelController levelCtrl;
	
	Group actorGroup;
	
	public GameLevel(LevelController ctrl) {
		this.levelCtrl = ctrl;
		
		actorGroup = levelCtrl.getMapController().getActorGroup();

		for (MapLayer layer: levelCtrl.getMapController().getTiledMap().getLayers()) {
			
			MapProperties layerProps = layer.getProperties();
	
			if ("actor".equals(layerProps.get("subtype"))) {
				Gdx.app.log("info", "Actor layer named " + layer.getName());
				
				TiledMapTileLayer actorLayer = (TiledMapTileLayer) layer;
				Group newActorLayerGroup = new Group();
				newActorLayerGroup.setName(layer.getName());

				for (int x = 0; x < actorLayer.getWidth();  x++) {
					for (int y = 0; y < actorLayer.getHeight();  y++) {
						Cell oldCell = actorLayer.getCell(x, y);
						if (oldCell != null){
							ActorCell actorCell = new ActorCell(actorLayer, x, y);
							newActorLayerGroup.addActor(actorCell);
						}
					}
				}
				
				actorGroup.addActor(newActorLayerGroup);
			}

		}
	}

	public void render() {
		// TODO Auto-generated method stub
		levelCtrl.getMapController().render();
	}
	
	

}
