package ua.od.rest;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import ua.od.rest.config.AppConfig;

public class Main {

    public static void main(String[] args) throws Exception {
        Server jettyServer;
        Server server = new Server(8080);
        server.setHandler(new AppConfig().getHandlersConfig());
        server.start();
        server.join();
    }
}