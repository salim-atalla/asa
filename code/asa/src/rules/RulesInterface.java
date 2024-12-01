package rules;

import core.Rule;
import java.util.List;

/**
 * Abstract class representing an interface for rules.
 */
public abstract class RulesInterface {
    private List<Rule> rules;

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
