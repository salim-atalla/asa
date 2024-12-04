package com.alma.attachment;

import com.alma.component.ProvidedPort;
import com.alma.connector.RequireRules;

/**
 * Represents an attachment between a provided port and required rules.
 */
public class ProvidedPortRequiredRulesAttachment extends Attachment {
    public ProvidedPortRequiredRulesAttachment(ProvidedPort port, RequireRules rules) {
        super(port, rules);
    }
}
