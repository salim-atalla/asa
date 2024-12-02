package observer;

/**
 * Represents an observer in the Observer design pattern.
 * Observers are notified when the subject's state changes.
 */
public interface Observer {
    /**
     * Updates the observer based on changes in the subject.
     */
    void update();

    /**
     * Updates the observer based on changes in the subject with a message.
     */
    void update(String message);
}
