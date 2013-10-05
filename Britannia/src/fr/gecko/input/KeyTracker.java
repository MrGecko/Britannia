package fr.gecko.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.IntIntMap;

public class KeyTracker extends InputAdapter {
	protected final IntIntMap keyMap = new IntIntMap();

	@Override
	public boolean keyDown (int keycode) {
		keyMap.put(keycode, keycode);
		return false;
	}
	
	@Override
	public boolean keyUp (int keycode) {
		keyMap.remove(keycode, 0);
		return false;
	}


}
