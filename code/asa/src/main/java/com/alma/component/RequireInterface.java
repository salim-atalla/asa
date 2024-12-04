package com.alma.component;

import com.alma.core.Port;
import com.alma.core.Service;
import java.util.List;

/**
 * Represents the required interface of a component.
 */
public class RequireInterface {
    private List<Port> ports;
    private List<Service> services;

    public RequireInterface(List<Port> ports, List<Service> services) {
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
