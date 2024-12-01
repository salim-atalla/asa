package connector;

import core.Rule;
import core.Service;

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

    /**
     * Binds a provided service to a required service using the rules.
     *
     * @param providedService The provided service.
     * @param requiredService The required service.
     * @return True if the services were successfully bound, false otherwise.
     */
    public boolean bindServices(Service providedService, Service requiredService) {
        // Iterate over each rule to check if the services can be connected
        for (Rule rule : rules) {
            if (rule.apply(providedService, requiredService)) {
                // The rule is applied successfully, the services are connected
                System.out.println("Services connected: " +
                        providedService.getServiceName() + " -> " + requiredService.getServiceName());
                return true;
            }
        }
        // If no rule applies, the services are not connected
        System.out.println("Services could not be connected: " +
                providedService.getServiceName() + " -> " + requiredService.getServiceName());
        return false;
    }
}
