package fr.gecko.level.map.renderer;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.Group;

public class OrthogonalActorTiledMapRenderer extends OrthogonalTiledMapRenderer {

	private Group actorGroup;
	
	public OrthogonalActorTiledMapRenderer(Group actorGroup, TiledMap map, float unitScale) {
		super(map, unitScale);
		this.actorGroup = actorGroup;
	}
		
	public Group getActorGroup() {
		return actorGroup;
	}

	@Override
	public void render () {
		AnimatedTiledMapTile.updateAnimationBaseTime();
		spriteBatch.begin();
		for (MapLayer layer : map.getLayers()) {
			if (layer.isVisible()) {
				if (layer instanceof TiledMapTileLayer) {
					
					MapProperties props = layer.getProperties();
					//draw actor group
					if ("actor".equals(props.get("subtype"))) {
						Group actorLayer = (Group) actorGroup.findActor(layer.getName());
						if (actorLayer != null) {
							if (actorLayer.isVisible()) 
								actorLayer.draw(spriteBatch, layer.getOpacity());
						}
					}
					else {
						//else draw the tile layer
						renderTileLayer((TiledMapTileLayer) layer);
					}
				} else {
					for (MapObject object : layer.getObjects()) {
						renderObject(object);
					}
				}					
			}				
		}
		spriteBatch.end();
	}



}
