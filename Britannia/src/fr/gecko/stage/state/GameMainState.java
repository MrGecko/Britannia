package fr.gecko.stage.state;

import com.badlogic.gdx.Gdx;

import fr.gecko.camera.CameraController;
import fr.gecko.stage.GameStage;
import fr.gecko.stage.ui.InfoTable;

public class GameMainState extends GameStageState {

	public GameMainState(GameStage stage) {
		super(stage);
	}
	
	@Override
	public void init(){
		Gdx.app.log("info", "game stage starting...");
		
		CameraController cameraCtrl = new CameraController(stage.getCamera());
		cameraCtrl.setName("cameraController");
		
		stage.addActor(cameraCtrl);
		InfoTable infoTable = new InfoTable(cameraCtrl);

		cameraCtrl.addActor(infoTable);
		
		Gdx.app.log("info", "game stage: ok");
	}

}
