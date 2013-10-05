package fr.gecko.level.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorCell extends Actor {

	private TiledMapTileLayer layer;
	private int cellX;
	private int cellY;

	public ActorCell(TiledMapTileLayer layer, int x, int y) {
		this.layer = layer;
		setCellX(x);
		setCellY(y);
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
		this.setY(cellY * layer.getTileHeight());
	}



	public int getCellX() {
		return cellX;
	}



	public void setCellX(int cellX) {
		this.cellX = cellX;
		this.setX(cellX * layer.getTileWidth());

	}
	
}
