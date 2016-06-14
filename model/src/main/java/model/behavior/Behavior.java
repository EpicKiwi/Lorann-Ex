package model.behavior;

import javax.lang.model.element.Element;

/**
 * Created by Marie on 14/06/2016.
 */
public interface Behavior {
    public void onCollision(Element other);
}
