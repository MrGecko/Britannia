package fr.gecko.fsm;

import java.util.LinkedList;
import java.util.Queue;

public class StateManager {

	private Queue<GameState> states;
	
	
	public StateManager() {
		states = new LinkedList<GameState>();
	}
	
	public GameState getCurrentState() {
		return states.peek();
	}
	
	public boolean isEmpty() {
		return states.isEmpty();
	}
	
	public boolean push(GameState newState) {
		GameState oldState = getCurrentState();
		if (oldState != null) {
			if (oldState.isLocked()) {
				return false;
			}
			else {
				if(!oldState.isPaused()) {
					oldState.pause();
				}
			}
		}
		boolean pushIsOk = states.add(newState);
		if (pushIsOk) {
			newState.init();
		}
		return pushIsOk;
	}
	
	public boolean pop() {
		GameState oldState = getCurrentState();
		if (oldState != null) {
			if (oldState.isLocked()) {
				return false;
			}
			else {
				if (states.poll() != null) {
					oldState.clean();
					GameState newState = getCurrentState();
					if (newState != null) {
						if (newState.isPaused()) {
							newState.resume();
						}
					}
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean set(GameState newState) {
		boolean ok = pop();
		return ok && push(newState);
	}
	
	public void pause() {
		GameState currentState = getCurrentState();
		if (currentState != null) {
			currentState.pause();
		}
	}
	
	public void resume() {
		GameState currentState = getCurrentState();
		if (currentState != null) {
			currentState.resume();
		}
	}
	
	public void update(float dt) {
		GameState currentState = getCurrentState();
		if (currentState != null) {
			if (!currentState.isPaused()) {
				currentState.update(dt);
			}
		}
	}
	
	public void draw() {
		GameState currentState = getCurrentState();
		if (currentState != null) {
			currentState.draw();
		}
	}

}
