package com.alma;

import com.alma.server_client.Client;
import com.alma.server_client.Server;
import com.alma.component.ProvideInterface;
import com.alma.component.ProvidedPort;
import com.alma.component.RequiredPort;
import com.alma.component.RequireInterface;
import com.alma.core.Service;
import com.alma.core.Rule;
import com.alma.core.Port;
import com.alma.rules.RuleType;
import com.alma.connector.Connector;
import com.alma.connector.Glue;
import com.alma.connector.ProvideRules;
import com.alma.connector.RequireRules;
import com.alma.attachment.ProvidedPortRequiredRulesAttachment;
import com.alma.attachment.RequiredPortProvidedRulesAttachment;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale de l'application pour tester le système bancaire.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Application lancée avec succès !");

        // Créer les Services
        Service clientService = new Service("ClientService");
        Service serverService = new Service("ServerService");

        // Créer les Ports
        ProvidedPort clientProvidedPort = new ProvidedPort("ClientProvidedPort");
        RequiredPort clientRequiredPort = new RequiredPort("ClientRequiredPort");
        ProvidedPort serverProvidedPort = new ProvidedPort("ServerProvidedPort");
        RequiredPort serverRequiredPort = new RequiredPort("ServerRequiredPort");

        // Créer ProvideInterfaces et RequireInterfaces pour le Client
        List<Port> clientProvidedPorts = new ArrayList<>();
        clientProvidedPorts.add(clientProvidedPort);
        List<Service> clientProvidedServices = new ArrayList<>();
        clientProvidedServices.add(clientService);
        ProvideInterface clientProvideInterface = new ProvideInterface(clientProvidedPorts, clientProvidedServices);

        List<Port> clientRequiredPorts = new ArrayList<>();
        clientRequiredPorts.add(clientRequiredPort);
        List<Service> clientRequiredServices = new ArrayList<>();
        RequireInterface clientRequireInterface = new RequireInterface(clientRequiredPorts, clientRequiredServices);

        // Créer ProvideInterfaces et RequireInterfaces pour le Serveur
        List<Port> serverProvidedPorts = new ArrayList<>();
        serverProvidedPorts.add(serverProvidedPort);
        List<Service> serverProvidedServices = new ArrayList<>();
        serverProvidedServices.add(serverService);
        ProvideInterface serverProvideInterface = new ProvideInterface(serverProvidedPorts, serverProvidedServices);

        List<Port> serverRequiredPorts = new ArrayList<>();
        serverRequiredPorts.add(serverRequiredPort);
        List<Service> serverRequiredServices = new ArrayList<>();
        RequireInterface serverRequireInterface = new RequireInterface(serverRequiredPorts, serverRequiredServices);

        // Créer les composants Client et Serveur
        Client client = new Client(clientProvideInterface, clientRequireInterface);
        Server server = new Server(serverProvideInterface, serverRequireInterface);
        client.setBankingService(server);

        // Enregistrer le client comme observateur du serveur
        server.addObserver(client);

        // Créer les Règles
        Rule clientToServerRule = new Rule(RuleType.NAME_MATCH, "ClientToServerRule");
        Rule serverToClientRule = new Rule(RuleType.NAME_MATCH, "ServerToClientRule");

        // Créer ProvideRules et RequireRules
        List<Rule> provideRulesList = new ArrayList<>();
        provideRulesList.add(serverToClientRule);
        ProvideRules provideRules = new ProvideRules(provideRulesList);

        List<Rule> requireRulesList = new ArrayList<>();
        requireRulesList.add(clientToServerRule);
        RequireRules requireRules = new RequireRules(requireRulesList);

        // Créer Glue
        List<Rule> glueRules = new ArrayList<>();
        glueRules.add(clientToServerRule);
        glueRules.add(serverToClientRule);
        Glue glue = new Glue(glueRules);

        // Créer le Connecteur
        Connector connector = new Connector(glue, provideRules, requireRules);

        // Créer les Attachements
        ProvidedPortRequiredRulesAttachment clientAttachment = new ProvidedPortRequiredRulesAttachment(
                clientProvidedPort, requireRules);
        RequiredPortProvidedRulesAttachment serverAttachment = new RequiredPortProvidedRulesAttachment(
                serverRequiredPort, provideRules);

        // Simuler l'interaction entre le Client et le Serveur
        System.out.println("Simulating interaction between Client and Server...");

        // Le Serveur change d'état et notifie les observateurs
        server.changeState();

        // Configurer les informations d'identification du Client
        client.setCredentials("user2", "password2"); // Exemple de credentials

        // Authentifier le Client via le Serveur en utilisant la méthode du Client
        client.authenticate(server);

        // Vérifier si l'authentification a réussi en utilisant le token du Client
        if (server.isSessionValid(client.getUsername(), client.getSessionToken())) {
            System.out.println("Client authenticated successfully.");

            // Utiliser les services bancaires via le client
            client.createAccount("ACC123", 1000.0);
            client.createAccount("ACC456", 500.0);
            client.performTransaction("TXN001", "ACC123", "ACC456", 200.0);
        } else {
            System.out.println("Client authentication failed. Cannot perform banking operations.");
        }

        System.out.println("Simulation completed successfully!");
    }
}
