package core;

/**
 * Represents a port in the system, used for communication between components.
 */
public class Port {
    private String name;

    public Port(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
