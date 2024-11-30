package connector;

import core.Rule;
import java.util.List;

/**
 * Represents the required rules of a connector.
 * A connector may have a set of rules that need to be satisfied
 * for the connection to be valid.
 */
public class RequireRules {
    private List<Rule> rules;

    public RequireRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
