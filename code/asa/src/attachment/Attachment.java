package attachment;

import component.ProvidedPort;
import component.RequiredPort;

/**
 * Represents an Attachment in the system.
 */
public class Attachment {
    private RequiredPort requiredPort;
    private ProvidedPort providedPort;

    public Attachment(RequiredPort requiredPort, ProvidedPort providedPort) {
        this.requiredPort = requiredPort;
        this.providedPort = providedPort;
    }

    public RequiredPort getRequiredPort() {
        return requiredPort;
    }

    public void setRequiredPort(RequiredPort requiredPort) {
        this.requiredPort = requiredPort;
    }

    public ProvidedPort getProvidedPort() {
        return providedPort;
    }

    public void setProvidedPort(ProvidedPort providedPort) {
        this.providedPort = providedPort;
    }
}
