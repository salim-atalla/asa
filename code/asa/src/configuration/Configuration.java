package configuration;

import component.Component;
import connector.Connector;

import java.util.List;

/**
 * Represents a Configuration in the system.
 */
public class Configuration {
    private List<Component> components; // List of components in the configuration.
    private List<Connector> connectors; // List of connectors in the configuration.

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
