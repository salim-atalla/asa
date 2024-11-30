package core;

/**
 * Represents a rule used by a connector or a glue.
 */
public class Rule {
    private String ruleName;

    public Rule(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
}
