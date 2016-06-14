package model;

import javax.swing.*;
import java.awt.*;

/**
 * A sprite representing an element in the level
 * @author Marie
 */
public class Sprite {

    /** The image of the sprite */
    private Image image;

    /**
     * Instanciate the sprite
     * @param image
     * A path to the image
     */
    public Sprite(String image) {
        this.image = new ImageIcon(image).getImage();
    }

    /**
     * Instanciate the sprite
     * @param image
     * The image
     */
    public Sprite(Image image) {
        this.image = image;
    }

    /**
     * Get the current image of the sprite
     * @return
     */
    public Image getImage() {
        return image;
    }
}
