package com.alma.connector;

import com.alma.rules.RulesInterface;
import com.alma.core.Rule;
import java.util.List;

/**
 * Represents required rules.
 */
public class RequireRules extends RulesInterface {
    public RequireRules(List<Rule> rules) {
        super(rules);
    }
}
