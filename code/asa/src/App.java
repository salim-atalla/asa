import server_client.Client;
import server_client.Server;
import server_client.ConnectionManager;
import server_client.Database;
import server_client.SecurityManager;
import component.Component;
import component.ProvideInterface;
import component.ProvidedPort;
import component.RequiredPort;
import component.RequireInterface;
import core.Service;
import core.Port;
import core.Rule;
import rules.RuleType;
import connector.Connector;
import connector.Glue;
import connector.ProvideRules;
import connector.RequireRules;
import attachment.ProvidedPortRequiredRulesAttachment;
import attachment.RequiredPortProvidedRulesAttachment;

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

        // Créer la base de données et le gestionnaire de sécurité
        Database database = new Database(clientProvideInterface, clientRequireInterface);
        SecurityManager securityManager = new SecurityManager(database, clientProvideInterface, clientRequireInterface);

        // Créer le gestionnaire de connexion
        ConnectionManager connectionManager = new ConnectionManager(database, securityManager, clientProvideInterface, clientRequireInterface);

        // Simuler l'interaction entre le Client et le Serveur
        System.out.println("Simulating interaction between Client and Server...");

        // Créer les règles
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
        ProvidedPortRequiredRulesAttachment clientAttachment = new ProvidedPortRequiredRulesAttachment(clientProvidedPort, requireRules);
        RequiredPortProvidedRulesAttachment serverAttachment = new RequiredPortProvidedRulesAttachment(serverRequiredPort, provideRules);

        // Configurer les informations d'identification du Client
        client.setCredentials("user1", "password1"); // Exemple de credentials

        // Authentifier le Client via le ConnectionManager
        if (connectionManager.authenticateUser(client.getUsername(), client.getPassword())) {
            System.out.println("Client authenticated successfully.");

            // Authentifier le Client auprès du Serveur
            String sessionToken = connectionManager.login(client.getUsername(), client.getPassword());

            // Vérifier si l'authentification a réussi
            if (((Server) client.getBankingService()).isSessionValid(client.getUsername(), sessionToken)) {
                // Associer le BankingService du serveur au client
                client.setBankingService(server); // Associer le service bancaire du serveur au client

                // Utiliser les services bancaires via le client
                client.createAccount("ACC123", 1000.0);
                client.createAccount("ACC456", 500.0);
                client.performTransaction("TXN001", "ACC123", "ACC456", 200.0);
            } else {
                System.out.println("Client authentication failed. Cannot perform banking operations.");
            }
        } else {
            System.out.println("Authentication failed. Invalid credentials.");
        }

        System.out.println("Simulation completed successfully!");
    }
}
