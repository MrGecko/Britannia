package fr.gecko.stage.state;

import fr.gecko.fsm.GameState;
import fr.gecko.level.LevelController;
import fr.gecko.stage.GameStage;

public class GameStageState extends GameState {
	
	protected GameStage stage;
	protected LevelController levelCtrl;
	
	public GameStageState(GameStage stage) {
		this.stage = stage;
		this.levelCtrl = stage.getLevelController();
	}
	
	@Override
	public void update(float dt) {
		stage.act(dt);
	}
	
	@Override
	public void draw() {
		levelCtrl.render();
		stage.draw();
	}
	

}
