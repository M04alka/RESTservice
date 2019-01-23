package ua.od.rest.config;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import ua.od.rest.controller.AccountController;
import ua.od.rest.controller.impl.AccountControllerImpl;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

public class AppConfig {

    public HandlerList getHandlersConfig() {
        HandlerList handlers = new HandlerList();
        handlers.addHandler(getWebResourceHandler());
        handlers.addHandler(getServletHandler());
        return handlers;
    }

    private Handler getServletHandler() {
        ServletContextHandler servletsHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletsHandler.setContextPath("/");
        servletsHandler.addServlet(new ServletHolder(new ServletContainer(getResourceConfig())), "/rest/*");
        FilterHolder holder = new FilterHolder(new CrossOriginFilter());
        holder.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD,OPTIONS");
        servletsHandler.addFilter(holder, "/rest/*", EnumSet.of(DispatcherType.REQUEST));
        return servletsHandler;
    }

    private Handler getWebResourceHandler() {

        ResourceHandler resourceHandler = new ResourceHandler() {
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {

                RequestDispatcher view = request.getRequestDispatcher("login.html");
            }
        };
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        resourceHandler.setBaseResource(Resource.newClassPathResource("/webapp"));
        return resourceHandler;
    }

    private ResourceConfig getResourceConfig() {
        return new ResourceConfig() {{
            packages("ua/od/rest");
            register(new AbstractBinder() {
                protected void configure () {
                    bindAsContract(AccountControllerImpl.class).to(AccountController.class);


                }
            });
        }};
    }

}
