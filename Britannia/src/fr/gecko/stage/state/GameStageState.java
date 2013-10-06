package fr.gecko.stage.state;

import fr.gecko.fsm.GameState;
import fr.gecko.level.LevelController;
import fr.gecko.stage.GameStage;

public class GameStageState extends GameState {
	
	protected GameStage stage;
	
	public GameStageState(GameStage stage) {
		this.stage = stage;
	}
	
	@Override
	public void update(float dt) {
		stage.act(dt);
	}
	
	@Override
	public void draw() {
		LevelController lvlCtrl = stage.getLevelController();
		if (lvlCtrl != null) {
			lvlCtrl.render();
		}
		stage.draw();
	}
	
	public void dispose() {
		LevelController lvlCtrl = stage.getLevelController();
		if (lvlCtrl != null) {
			lvlCtrl.dispose();
		}
	}
	

}
