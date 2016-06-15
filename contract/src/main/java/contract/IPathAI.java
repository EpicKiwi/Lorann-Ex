package contract;

/**
 * Created by baptiste on 15/06/16.
 */
public interface IPathAI {
    /**
     * A method executed on each tick
     * @param level
     * The level
     */
    void onTick(ILevel level);

    void setAi(IAI ai);

    IAI getAi();
}
