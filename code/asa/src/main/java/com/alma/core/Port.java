package com.alma.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a port in the system, used for communication between components.
 * A port is associated with one or more services.
 */
public class Port {
    private String name;
    private List<Service> services;

    public Port(String name) {
        this.name = name;
        this.services = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        this.services.add(service);
    }
}
