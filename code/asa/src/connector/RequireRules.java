package connector;

import core.Rule;
import rules.RulesInterface;

import java.util.List;

/**
 * Represents Require Rules, a specialization of Rules Interface.
 */
public class RequireRules extends RulesInterface {
    public RequireRules(List<Rule> rules) {
        super(rules);
    }
}
