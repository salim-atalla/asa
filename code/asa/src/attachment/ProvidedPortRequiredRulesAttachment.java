package attachment;

import component.ProvidedPort;
import connector.RequireRules;

/**
 * Represents an attachment between a provided port and required rules.
 */
public class ProvidedPortRequiredRulesAttachment extends Attachment {
    public ProvidedPortRequiredRulesAttachment(ProvidedPort port, RequireRules rules) {
        super(port, rules);
    }
}
