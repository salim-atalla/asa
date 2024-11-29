package component;

import core.Port;
import core.Service;

import java.util.List;

/**
 * Represents a generic Component Interface.
 */
public abstract class ComponentInterface {
    private List<Port> ports; // List of associated ports.
    private List<Service> services; // List of associated services.

    public ComponentInterface(List<Port> ports, List<Service> services) {
        this.ports = ports;
        this.services = services;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
