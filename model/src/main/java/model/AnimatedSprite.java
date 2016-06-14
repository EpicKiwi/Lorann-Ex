package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Marie on 14/06/2016.
 * 
 * switch sprites to make an animation
 */
public class AnimatedSprite extends Sprite
{
	/**
	 * make a list of sprite for an object that will appear on screen
	 */
    private Image images[];

    
    /**
     * define the the current animation status
     */
    private int step;
    
    
    /**
     * the constructor of this class
     */
    public AnimatedSprite(String defaultImage, String[] images) {
        super(defaultImage);
    }

    /**
     * initiate the next step of the animation sequence
     */
    public void nextStep()
    {
    }
}
