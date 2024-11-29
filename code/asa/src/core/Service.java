package core;

/**
 * Represents a generic Service in the system.
 */
public abstract class Service {
    private String serviceId; // Unique identifier for the service.

    public Service(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
