package contract;

import java.awt.*;

/**
 * Created by baptiste on 15/06/16.
 */
public interface IElement {

    void onCollision(IElement other, ILevel level);

    Behavior getBehavior();

    ILocation getLocation();

    void setLocation(ILocation location);

    void setLocation(int x, int y);

    ISprite getSprite();

    void setSprite(ISprite sprite);

    boolean isPermeable();

    Image getImage();
}
