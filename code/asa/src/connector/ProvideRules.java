package connector;

import core.Rule;
import rules.RulesInterface;

import java.util.List;

/**
 * Represents Provide Rules, a specialization of Rules Interface.
 */
public class ProvideRules extends RulesInterface {
    public ProvideRules(List<Rule> rules) {
        super(rules);
    }
}
