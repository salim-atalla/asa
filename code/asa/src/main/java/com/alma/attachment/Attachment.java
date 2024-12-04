package com.alma.attachment;

import com.alma.core.Port;
import com.alma.rules.RulesInterface;

/**
 * Represents an attachment between a port and a rules interface.
 */
public abstract class Attachment {
    private Port port;
    private RulesInterface rules;

    public Attachment(Port port, RulesInterface rules) {
        this.port = port;
        this.rules = rules;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public RulesInterface getRules() {
        return rules;
    }

    public void setRules(RulesInterface rules) {
        this.rules = rules;
    }
}
