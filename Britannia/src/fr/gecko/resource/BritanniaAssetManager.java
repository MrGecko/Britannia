package fr.gecko.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class BritanniaAssetManager extends AssetManager {
	
	private Skin uiSkin;
	private TextureAtlas uiAtlas;

	
	public Skin getUiSkin() {
		return uiSkin;
	}
	
	public BritanniaAssetManager() {		
		Settings settings = new Settings();
		settings.maxWidth = 512;
		settings.maxHeight = 512;
		settings.paddingX = 0;
		settings.paddingY = 0;
		settings.useIndexes = true;
		
		//TexturePacker2.process(settings, "../Britannia-android/assets/atlas", "../Britannia-android/assets/atlas/packed", "resource");
	}

	public void startLoading() {
		setLoader(TiledMap.class, new TmxMapLoader());
		
		load("../Britannia-android/assets/ui/uiskin.atlas", TextureAtlas.class);
		
		uiAtlas = new TextureAtlas("../Britannia-android/assets/ui/uiskin.atlas");
		
		uiSkin = new Skin(Gdx.files.internal("../Britannia-android/assets/ui/uiskin.json"));
		uiSkin.addRegions(uiAtlas);
		
		load("../Britannia-android/assets/small-level.tmx", TiledMap.class);
	}

	public TextureAtlas getUiAtlas() {
		return uiAtlas;
	}

	

}
