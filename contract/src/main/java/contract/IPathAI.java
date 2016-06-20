package contract;

/**
 * The Interface IPathAI
 *
 * @author Baptiste
 */
public interface IPathAI {
    /**
     * A method executed on each tick
     * @param level
     * The level
     */
    void onTick(ILevel level);

    /**
     * A method for the ai
     * @param ai
     * get the AI
     */

    void setAi(IAI ai);
    /**
     * A method to get the AI
     * @return
     * The Ai
     */

    IAI getAi();
}
