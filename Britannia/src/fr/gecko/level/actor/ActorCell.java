package fr.gecko.level.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import fr.gecko.stage.ui.InfoTable;

public class ActorCell extends Actor {

	private TiledMapTileLayer layer;
	private int cellX;
	private int cellY;

	public ActorCell(final TiledMapTileLayer layer, int x, int y) {
		this.layer = layer;
		setWidth(layer.getTileWidth());
		setHeight(layer.getTileHeight());
		
		setCellX(x);
		setCellY(y);
				
		addListener(new InputListener(){
			
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				InfoTable infoTable = (InfoTable) event.getStage().getRoot().findActor("infoTable");
				
				ActorCell cell = (ActorCell) event.getTarget();
				
				if (infoTable != null) {
					infoTable.setCellImage(cell.getRegion());
					infoTable.setCellName(cell.getName());
				}
				
				return true;
			}

		});
	}

    public void draw (SpriteBatch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(getRegion(), getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
    }
    
    private TextureRegion getRegion() {
    	return layer.getCell(getCellX(), getCellY()).getTile().getTextureRegion();
    }

	public int getCellY() {
		return cellY;
	}
	

	public void setCellY(int cellY) {
		this.cellY = cellY;
		this.setY(cellY * getHeight());
	}

	public int getCellX() {
		return cellX;
	}


	public void setCellX(int cellX) {
		this.cellX = cellX;
		this.setX(cellX * getWidth());
	}
	
}
