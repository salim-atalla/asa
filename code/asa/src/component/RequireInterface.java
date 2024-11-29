package component;

import core.Port;
import core.Service;

import java.util.List;

/**
 * Represents a Require Interface, a specialization of Component Interface.
 */
public class RequireInterface extends ComponentInterface {
    public RequireInterface(List<Port> ports, List<Service> services) {
        super(ports, services);
    }
}
