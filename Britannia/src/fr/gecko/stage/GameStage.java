package fr.gecko.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.IntIntMap;

import fr.gecko.britannia.Britannia;
import fr.gecko.britannia.resource.BritanniaAssetManager;
import fr.gecko.camera.CameraController;

public class GameStage extends Stage {
	
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
		
		CameraController cameraCtrl = new CameraController(getCamera());
		cameraCtrl.setName("cameraController");
		addActor(cameraCtrl);

		Gdx.input.setInputProcessor(this);
		setKeyboardFocus(this.getRoot());
		

		BritanniaAssetManager assetManager = Britannia.getAssetManager();
		Label nameLabel = new Label("Name:", assetManager.getUiSkin());
		TextField nameText = new TextField("text", assetManager.getUiSkin());
		Label addressLabel = new Label("Address:", assetManager.getUiSkin());
		TextField addressText = new TextField("text", assetManager.getUiSkin());

		Table table = new Table();
		table.add(nameLabel);
		table.add(nameText).width(100);
		table.row();
		table.add(addressLabel);
		table.add(addressText).width(100);
		
		table.debug();
		table.setFillParent(true);

		cameraCtrl.addActor(table);
	}

}
