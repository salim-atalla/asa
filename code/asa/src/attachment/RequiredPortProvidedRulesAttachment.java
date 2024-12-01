package attachment;

import component.RequiredPort;
import connector.ProvideRules;

/**
 * Represents an attachment between a required port and provided rules.
 */
public class RequiredPortProvidedRulesAttachment extends Attachment {
    public RequiredPortProvidedRulesAttachment(RequiredPort port, ProvideRules rules) {
        super(port, rules);
    }
}
