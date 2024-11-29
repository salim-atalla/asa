package core;

/**
 * Represents a generic Port in the system.
 */
public abstract class Port {
    private String portId; // Unique identifier for the port.

    public Port(String portId) {
        this.portId = portId;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }
}
