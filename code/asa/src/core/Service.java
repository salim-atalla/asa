package core;

import connector.Glue;

/**
 * Represents a service provided or required by a component.
 * Each service is linked to a Glue object to establish rules.
 */
public class Service {
    private String serviceName;
    private Glue glue;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }
}
