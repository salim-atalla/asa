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

    /**
     * Applies the rules in the glue to check if the service can be connected
     * to another service.
     *
     * @param otherService The service to which this service might be connected.
     * @return True if the connection is valid according to the rules, false otherwise.
     */
    public boolean applyRules(Service otherService) {
        // Apply each rule from the glue to check if the services can be connected
        for (Rule rule : glue.getRules()) {
            if (!rule.apply(this, otherService)) {
                System.out.println("Connection failed: " +
                        this.getServiceName() + " -> " + otherService.getServiceName() +
                        " (due to rule: " + rule.getRuleName() + ")");
                return false;
            }
        }
        System.out.println("Connection successful: " +
                this.getServiceName() + " -> " + otherService.getServiceName());
        return true;
    }
}
