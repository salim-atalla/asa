package com.alma.attachment;

import com.alma.component.RequiredPort;
import com.alma.connector.ProvideRules;

/**
 * Represents an attachment between a required port and provided rules.
 */
public class RequiredPortProvidedRulesAttachment extends Attachment {
    public RequiredPortProvidedRulesAttachment(RequiredPort port, ProvideRules rules) {
        super(port, rules);
    }
}
