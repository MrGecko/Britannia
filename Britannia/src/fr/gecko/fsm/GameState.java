package fr.gecko.fsm;

public class GameState {
	
	private boolean locked = false;
	private boolean pause = false;

	public boolean isLocked() {
		return locked;
	}
	
	public boolean isPaused() {
		return pause;
	}
	
	public void lock() {
		locked = true;
	}
	public void unlock() {
		locked = false;
	}
	public void toggleLock() {
		locked = !locked;
	}
	

	public void clean() {
		
	}

	public void pause() {
		pause = true;
	}

	public void resume() {
		pause = false;
	}

	public void init() {
		
	}

	public void draw() {
		
	}

	public void update(float dt) {
		
	}

}
