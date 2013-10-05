package fr.gecko.stage.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import fr.gecko.britannia.Britannia;
import fr.gecko.britannia.resource.BritanniaAssetManager;
import fr.gecko.camera.CameraController;
import fr.gecko.stage.GameStage;

public class GameLaunchState extends GameStageState {

	public GameLaunchState(GameStage stage) {
		super(stage);
	}
	
	@Override
	public void init(){
		Gdx.app.log("info", "game stage starting...");
		
		CameraController cameraCtrl = new CameraController(stage.getCamera());
		cameraCtrl.setName("cameraController");
		
		stage.addActor(cameraCtrl);
		
		BritanniaAssetManager assetManager = Britannia.getAssetManager();
		Label nameLabel = new Label("Name:", assetManager.getUiSkin());
		TextField nameText = new TextField("text", assetManager.getUiSkin());
		Label addressLabel = new Label("Address:", assetManager.getUiSkin());
		TextField addressText = new TextField("text", assetManager.getUiSkin());

		Table table = new Table();
		table.add(nameLabel);
		table.add(nameText).width(180);
		table.row();
		table.add(addressLabel).pad(6f);
		table.add(addressText).width(180);
		
		table.pad(4f);
		table.right().top();
		
		table.debug();
		table.debugTable();
		table.setFillParent(true);
		
		cameraCtrl.addActor(table);
		
		Gdx.app.log("info", "game stage: ok");
	}

}
