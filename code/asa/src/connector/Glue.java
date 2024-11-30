package connector;

import core.Rule;
import java.util.List;

/**
 * Represents a glue that connects rules and services.
 * It holds a list of rules that connect services with components.
 */
public class Glue {
    private List<Rule> rules;

    public Glue(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
