package connector;

import core.Rule;
import java.util.List;

/**
 * Represents the provided rules of a connector.
 * A connector can provide a set of rules that will be applied to connect
 * components and services.
 */
public class ProvideRules {
    private List<Rule> rules;

    public ProvideRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
