package connector;

import rules.RulesInterface;
import core.Rule;
import java.util.List;

/**
 * Represents provided rules.
 */
public class ProvideRules extends RulesInterface {
    public ProvideRules(List<Rule> rules) {
        super(rules);
    }

    @Override
    public void applyRules() {
        // Implementation of rule application logic for provided rules
    }
}
