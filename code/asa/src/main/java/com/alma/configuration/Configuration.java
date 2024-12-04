package com.alma.configuration;

import com.alma.component.Component;
import com.alma.connector.Connector;
import java.util.List;

/**
 * Represents a configuration in the system.
 * Contains components and connectors.
 */
public class Configuration {
    private List<Component> components;
    private List<Connector> connectors;

    public Configuration(List<Component> components, List<Connector> connectors) {
        this.components = components;
        this.connectors = connectors;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
