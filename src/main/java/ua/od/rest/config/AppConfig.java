package ua.od.rest.config;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import org.glassfish.jersey.servlet.ServletContainer;


public class AppConfig {

    public HandlerList getHandlersConfig() {
        HandlerList handlers = new HandlerList();
        handlers.addHandler(getWebResourceHandler());
        handlers.addHandler(getServletHandler());
        return handlers;
    }

    private Handler getServletHandler() {
        ServletContextHandler servletsContextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletsContextHandler.setContextPath("/");
        ServletHolder servletHolder = servletsContextHandler.addServlet(ServletContainer.class, "/rest/*");
        servletsContextHandler.addServlet(servletHolder,"/rest/*");
        return  servletsContextHandler;
    }

    private Handler getWebResourceHandler() {

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        resourceHandler.setResourceBase("./src/main/resources/webapp");
        return resourceHandler;
    }

}
