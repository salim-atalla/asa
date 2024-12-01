package core;

import rules.RuleType;

/**
 * Represents a rule that can be applied to services during the binding process.
 */
public class Rule {
    private RuleType ruleType; // The type of rule (e.g., NAME_MATCH, COMPATIBILITY_CHECK)
    private String ruleName;   // A name for the rule (can be a description)

    public Rule(RuleType ruleType, String ruleName) {
        this.ruleType = ruleType;
        this.ruleName = ruleName;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    /**
     * Executes the rule on the provided service and required service.
     *
     * @param providedService The provided service.
     * @param requiredService The required service.
     * @return True if the rule can be applied, false otherwise.
     */
    public boolean apply(Service providedService, Service requiredService) {
        switch (ruleType) {
            case NAME_MATCH:
                return applyNameMatch(providedService, requiredService);
            case COMPATIBILITY_CHECK:
                return applyCompatibilityCheck(providedService, requiredService);
            default:
                return false;
        }
    }

    // Logic for the NAME_MATCH rule
    private boolean applyNameMatch(Service providedService, Service requiredService) {
        return providedService.getServiceName().equalsIgnoreCase(requiredService.getServiceName());
    }

    // Logic for the COMPATIBILITY_CHECK rule
    private boolean applyCompatibilityCheck(Service providedService, Service requiredService) {
        // Example compatibility check logic,
        // TODO : it can be customized.
        return providedService.getGlue().equals(requiredService.getGlue());
    }
}
