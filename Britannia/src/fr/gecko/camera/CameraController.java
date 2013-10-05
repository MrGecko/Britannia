package fr.gecko.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.IntIntMap;

import fr.gecko.stage.GameStage;

public class CameraController extends Group {

	private Camera camera;
	private float speedFactor = 600f;
	
	public CameraController(Camera cam)
	{
		super();
		this.camera = cam;
	}
	
	@Override
	public void act(float dt){	

		GameStage stage =  (GameStage) getStage();
		
		if (stage != null) {
			IntIntMap keyMap = stage.getKeyMap();
			
			if (keyMap.containsKey(Input.Keys.ESCAPE)) {
				Gdx.app.exit();
			}	
			
			if (keyMap.containsKey(Input.Keys.Q) || keyMap.containsKey(Input.Keys.A)) {
				camera.translate(-speedFactor * dt, 0, 0);
				this.translate(-speedFactor * dt, 0);
			}

			if (keyMap.containsKey(Input.Keys.D)) {
				camera.translate(speedFactor * dt, 0, 0);
				this.translate(speedFactor * dt, 0);
			}	

			if (keyMap.containsKey(Input.Keys.Z) ||keyMap.containsKey(Input.Keys.W)) {
				camera.translate(0, speedFactor * dt, 0);
				this.translate(0, speedFactor * dt);
			}

			if (keyMap.containsKey(Input.Keys.S)) {
				camera.translate(0, -speedFactor * dt, 0);
				this.translate(0, -speedFactor * dt);
			}
			
			camera.update();
		}
		
	}
	

}

