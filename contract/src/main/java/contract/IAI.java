package contract;

/**
 * The Interface IAI
 *
 * @author Baptiste
 */
public interface IAI extends IEntity {
    AIType getAiType();
    /**
     * Setter for the AI
     * @param aiType
     * Set a type of AI
     */
    void setAiType(AIType aiType);
}
