package com.alma.connector;

import com.alma.component.Component;
import com.alma.core.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a connector used to connect two components.
 * It holds references to provided and required rules and also has a glue
 * that connects the services and rules.
 */
public class Connector {
    private Glue glue;
    private ProvideRules provideRules;
    private RequireRules requireRules;

    public Connector(Glue glue, ProvideRules provideRules, RequireRules requireRules) {
        this.glue = glue;
        this.provideRules = provideRules;
        this.requireRules = requireRules;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }

    public ProvideRules getProvidedRules() {
        return provideRules;
    }

    public void setProvidedRules(ProvideRules provideRules) {
        this.provideRules = provideRules;
    }

    public RequireRules getRequiredRules() {
        return requireRules;
    }

    public void setRequiredRules(RequireRules requireRules) {
        this.requireRules = requireRules;
    }

    /**
     * Connects two components by associating the provided and required rules,
     * and applies glue to bind services with rules.
     */
    public void connectComponents(Component component1, Component component2) {
        // Collect all provided services from the first component
        List<Service> providedServices = component1.getProvidedInterface().getPorts()
                .stream()
                .flatMap(port -> port.getServices().stream())
                .collect(Collectors.toList());

        // Collect all required services from the second component
        List<Service> requiredServices = component2.getRequiredInterface().getPorts()
                .stream()
                .flatMap(port -> port.getServices().stream())
                .collect(Collectors.toList());

        // Match and bind services
        for (Service providedService : providedServices) {
            for (Service requiredService : requiredServices) {
                if (providedService.applyRules(requiredService)) {
                    System.out.println("Connected service: "
                            + providedService.getServiceName()
                            + " to "
                            + requiredService.getServiceName());
                }
            }
        }
    }
}
