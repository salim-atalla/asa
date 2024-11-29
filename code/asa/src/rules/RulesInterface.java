package rules;

import core.Rule;

import java.util.List;

/**
 * Represents a generic Rules Interface.
 */
public abstract class RulesInterface {
    private List<Rule> rules; // List of associated rules.

    public RulesInterface(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
