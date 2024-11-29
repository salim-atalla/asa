package connector;

/**
 * Represents a Connector in the system.
 */
public class Connector {
    private ProvideRules provideRules; // Provide Rules of the Connector.
    private RequireRules requireRules; // Require Rules of the Connector.

    public Connector(ProvideRules provideRules, RequireRules requireRules) {
        this.provideRules = provideRules;
        this.requireRules = requireRules;
    }

    public ProvideRules getProvideRules() {
        return provideRules;
    }

    public void setProvideRules(ProvideRules provideRules) {
        this.provideRules = provideRules;
    }

    public RequireRules getRequireRules() {
        return requireRules;
    }

    public void setRequireRules(RequireRules requireRules) {
        this.requireRules = requireRules;
    }
}
