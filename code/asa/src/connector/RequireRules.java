package connector;

import rules.RulesInterface;
import core.Rule;
import java.util.List;

/**
 * Represents required rules.
 */
public class RequireRules extends RulesInterface {
    public RequireRules(List<Rule> rules) {
        super(rules);
    }
}
