package attachment;

import core.Port;
import core.Rule;

/**
 * Represents an attachment between a port and a rule.
 */
public abstract class Attachment {
    private Port port;
    private Rule rule;

    public Attachment(Port port, Rule rule) {
        this.port = port;
        this.rule = rule;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
