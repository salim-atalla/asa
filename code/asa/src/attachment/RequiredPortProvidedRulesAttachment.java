package attachment;

import component.RequiredPort;
import connector.ProvideRules;

/**
 * Represents an attachment between a Required Port and Provided Rules.
 */
public class RequiredPortProvidedRulesAttachment {
    private RequiredPort requiredPort; // The Required Port in the attachment.
    private ProvideRules providedRules; // The Provided Rules in the attachment.

    /**
     * Constructor for the RequiredPortProvidedRulesAttachment.
     *
     * @param requiredPort The Required Port.
     * @param providedRules The Provided Rules.
     */
    public RequiredPortProvidedRulesAttachment(RequiredPort requiredPort, ProvideRules providedRules) {
        this.requiredPort = requiredPort;
        this.providedRules = providedRules;
    }

    public RequiredPort getRequiredPort() {
        return requiredPort;
    }

    public void setRequiredPort(RequiredPort requiredPort) {
        this.requiredPort = requiredPort;
    }

    public ProvideRules getProvidedRules() {
        return providedRules;
    }

    public void setProvidedRules(ProvideRules providedRules) {
        this.providedRules = providedRules;
    }
}
