package contract;

/**
 * Created by baptiste on 15/06/16.
 */
public interface IAI extends IEntity {
    AIType getAiType();
    void setAiType(AIType aiType);
}
