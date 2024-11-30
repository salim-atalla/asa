package server_client;

import component.Component;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a server component in the architecture.
 * Implements the Subject interface to manage observers (clients).
 */
public class Server extends Component implements Subject {
    private final List<Observer> observers; // List of observers (clients)

    public Server(Component providedInterface, Component requiredInterface) {
        super(providedInterface.getProvidedInterface(), requiredInterface.getRequiredInterface());
        this.observers = new ArrayList<>();
    }

    /**
     * Adds an observer (Client) to the observer list.
     *
     * @param observer the observer to be added
     */
    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * Removes an observer (Client) from the observer list.
     *
     * @param observer the observer to be removed
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers (Clients) of a state change.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Simulates a state change and notifies observers.
     */
    public void changeState() {
        System.out.println("Server: State changed, notifying observers...");
        notifyObservers();
    }
}
