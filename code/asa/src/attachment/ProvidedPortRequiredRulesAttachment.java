package attachment;

import component.ProvidedPort;
import connector.RequireRules;

/**
 * Represents an attachment between a Provided Port and Required Rules.
 */
public class ProvidedPortRequiredRulesAttachment {
    private ProvidedPort providedPort; // The Provided Port in the attachment.
    private RequireRules requiredRules; // The Required Rules in the attachment.

    /**
     * Constructor for the ProvidedPortRequiredRulesAttachment.
     *
     * @param providedPort The Provided Port.
     * @param requiredRules The Required Rules.
     */
    public ProvidedPortRequiredRulesAttachment(ProvidedPort providedPort, RequireRules requiredRules) {
        this.providedPort = providedPort;
        this.requiredRules = requiredRules;
    }

    public ProvidedPort getProvidedPort() {
        return providedPort;
    }

    public void setProvidedPort(ProvidedPort providedPort) {
        this.providedPort = providedPort;
    }

    public RequireRules getRequiredRules() {
        return requiredRules;
    }

    public void setRequiredRules(RequireRules requiredRules) {
        this.requiredRules = requiredRules;
    }
}
