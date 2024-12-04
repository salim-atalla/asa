package com.alma.component;

import com.alma.core.Port;
import com.alma.core.Service;

import java.util.List;

/**
 * Abstract class representing a generic interface for components.
 */
public abstract class ComponentInterface {
    private List<Port> ports;
    private List<Service> services;

    public ComponentInterface(List<Port> ports, List<Service> services) {
        this.ports = ports;
        this.services = services;
    }

    public List<Port> getPorts() {
        return ports;
    }

    public List<Service> getServices() {
        return services;
    }
}
