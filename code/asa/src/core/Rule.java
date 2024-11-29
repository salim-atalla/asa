package core;

/**
 * Represents a Rule in the system.
 */
public class Rule {
    private String ruleId; // Unique identifier for the rule.

    public Rule(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
