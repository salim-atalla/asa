package com.alma.observer;

import java.util.List;

/**
 * Represents a subject in the Observer design pattern.
 * A subject manages a list of observers and notifies them of state changes.
 */
public interface Subject {
    /**
     * Adds an observer to the subject.
     *
     * @param observer the observer to be added
     */
    void addObserver(Observer observer);

    /**
     * Removes an observer from the subject.
     *
     * @param observer the observer to be removed
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all registered observers of a state change with a message.
     */
    void notifyObservers(String message);
}
