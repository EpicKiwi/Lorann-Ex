package model;


import contract.ISprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A sprite representing an element in the level
 * @author Marie
 */
public class Sprite implements ISprite {


    /** The image of the sprite */
    protected Image image;

    /**
     * Instanciate the sprite
     * @param image
     * A path to the image
     */
    public Sprite(String image) {
        try {
            this.image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(image));
        } catch (IOException e) {
            System.err.println("Impossible to load the image"+image);
            e.printStackTrace();
        }
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
     * @return The image of the sprite
     */
    public Image getImage() {
        return image;
    }
}
