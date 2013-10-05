package fr.gecko.britannia.client;

import fr.gecko.britannia.Britannia;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(960, 640);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new Britannia();
	}
}