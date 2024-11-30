package component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a component in the system.
 * Implements the Composition design pattern by maintaining child components.
 */
public class Component {
    private ProvideInterface providedInterface; // Provided interface of the component
    private RequireInterface requiredInterface; // Required interface of the component
    private List<Component> childComponents; // Child components for the composition design pattern

    /**
     * Constructor for the Component class.
     *
     * @param providedInterface the provided interface of the component
     * @param requiredInterface the required interface of the component
     */
    public Component(ProvideInterface providedInterface, RequireInterface requiredInterface) {
        this.providedInterface = providedInterface;
        this.requiredInterface = requiredInterface;
        this.childComponents = new ArrayList<>();
    }

    /**
     * Adds a child component to this component (composition design pattern).
     *
     * @param child the child component to add
     */
    public void addChildComponent(Component child) {
        if (!childComponents.contains(child)) {
            childComponents.add(child);
        }
    }

    /**
     * Removes a child component from this component (composition design pattern).
     *
     * @param child the child component to remove
     */
    public void removeChildComponent(Component child) {
        childComponents.remove(child);
    }

    /**
     * Retrieves the list of child components.
     *
     * @return the list of child components
     */
    public List<Component> getChildComponents() {
        return childComponents;
    }

    /**
     * Retrieves the provided interface of this component.
     *
     * @return the provided interface
     */
    public ProvideInterface getProvidedInterface() {
        return providedInterface;
    }

    /**
     * Sets the provided interface of this component.
     *
     * @param providedInterface the provided interface to set
     */
    public void setProvidedInterface(ProvideInterface providedInterface) {
        this.providedInterface = providedInterface;
    }

    /**
     * Retrieves the required interface of this component.
     *
     * @return the required interface
     */
    public RequireInterface getRequiredInterface() {
        return requiredInterface;
    }

    /**
     * Sets the required interface of this component.
     *
     * @param requiredInterface the required interface to set
     */
    public void setRequiredInterface(RequireInterface requiredInterface) {
        this.requiredInterface = requiredInterface;
    }

    /**
     * Displays the structure of this component and its children (for debugging).
     */
    public void displayStructure() {
        System.out.println("Component: " + this);
        for (Component child : childComponents) {
            child.displayStructure();
        }
    }
}
