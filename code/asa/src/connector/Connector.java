package connector;

import component.Component;

/**
 * Represents a connector used to connect two components.
 * It holds references to provided and required rules and also has a glue
 * that connects the services and rules.
 */
public class Connector {
    private Glue glue;
    private ProvideRules provideRules;
    private RequireRules requireRules;

    public Connector(Glue glue, ProvideRules provideRules, RequireRules requireRules) {
        this.glue = glue;
        this.provideRules = provideRules;
        this.requireRules = requireRules;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }

    public ProvideRules getProvidedRules() {
        return provideRules;
    }

    public void setProvidedRules(ProvideRules provideRules) {
        this.provideRules = provideRules;
    }

    public RequireRules getRequiredRules() {
        return requireRules;
    }

    public void setRequiredRules(RequireRules requireRules) {
        this.requireRules = requireRules;
    }

    /**
     * Connects two components by associating the provided and required rules,
     * and applies glue to bind services with rules.
     */
    public void connectComponents(Component component1, Component component2) {
        // Logic for connecting two components
        // This could involve setting up ports and services, etc.
    }
}
