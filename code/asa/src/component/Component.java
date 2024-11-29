package component;

/**
 * Represents a Component in the system.
 */
public class Component {
    private ProvideInterface provideInterface; // Provide Interface of the Component.
    private RequireInterface requireInterface; // Require Interface of the Component.

    public Component(ProvideInterface provideInterface, RequireInterface requireInterface) {
        this.provideInterface = provideInterface;
        this.requireInterface = requireInterface;
    }

    public ProvideInterface getProvideInterface() {
        return provideInterface;
    }

    public void setProvideInterface(ProvideInterface provideInterface) {
        this.provideInterface = provideInterface;
    }

    public RequireInterface getRequireInterface() {
        return requireInterface;
    }

    public void setRequireInterface(RequireInterface requireInterface) {
        this.requireInterface = requireInterface;
    }
}
