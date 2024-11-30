package server_client;

import component.Component;
import observer.Observer;

/**
 * Represents a client component in the architecture.
 * Implements the Observer interface to respond to state changes in the Server.
 */
public class Client extends Component implements Observer {

    public Client(Component providedInterface, Component requiredInterface) {
        super(providedInterface.getProvidedInterface(), requiredInterface.getRequiredInterface());
    }

    /**
     * Updates the client based on changes in the server.
     * This method is called when the server notifies its observers.
     */
    @Override
    public void update() {
        System.out.println("Client: Notified of state change in the server!");
        // Add specific update logic here.
    }
}
