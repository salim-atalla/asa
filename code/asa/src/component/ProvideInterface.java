package component;

import core.Port;
import core.Service;

import java.util.List;

/**
 * Represents a Provide Interface, a specialization of Component Interface.
 */
public class ProvideInterface extends ComponentInterface {
    public ProvideInterface(List<Port> ports, List<Service> services) {
        super(ports, services);
    }
}
