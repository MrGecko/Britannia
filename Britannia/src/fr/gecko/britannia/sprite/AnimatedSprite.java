package fr.gecko.britannia.sprite;

import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import fr.gecko.britannia.resource.SpriteResource;


public class AnimatedSprite extends Actor {

	private Map<String, Animation> animations;
	private String currentAnimation ;
	private float stateTime;
	private boolean looping;
	
	public AnimatedSprite(SpriteResource resource) {
		stateTime = 0f;
		currentAnimation = null;
		
		animations = resource.getAnimations();
	}
	
    public void draw (SpriteBatch batch, float parentAlpha) {
    	if (isVisible()) {
	        Color color = getColor();
	        Animation anim = animations.get(currentAnimation);
	        if (anim != null) {
		        TextureRegion region = anim.getKeyFrame(stateTime, looping);
		        
		        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
		        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
		                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	        }

    	}
    }
    
 

}
