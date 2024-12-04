package com.alma.connector;

import com.alma.rules.RulesInterface;
import com.alma.core.Rule;
import java.util.List;

/**
 * Represents provided rules.
 */
public class ProvideRules extends RulesInterface {
    public ProvideRules(List<Rule> rules) {
        super(rules);
    }
}
