package ua.od.rest;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import ua.od.rest.config.AppConfig;

public class Main {

    public static void main(String[] args) throws Exception {


       /* Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/hello");
        context.addServlet(HelloServlet.class, "/");
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);
        server.start();
        server.join();


        Server server = new Server(8080);

        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/ua.od.rest/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "ua.od.rest");

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new ListServlet),);

        ContextHandler context = new ContextHandler();
        context.setContextPath("/login");
        context.setResourceBase(".");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(context);

        //1.Creating the resource handler
        ResourceHandler resourceHandler= new ResourceHandler();

        //2.Setting Resource Base
        resourceHandler.setResourceBase("webapp");

        //3.Enabling Directory Listing
        resourceHandler.setDirectoriesListed(true);

        //4.Setting Context Source
        ContextHandler contextHandler= new ContextHandler("/login.html");

        //5.Attaching Handlers
        contextHandler.setHandler(resourceHandler);
        server.setHandler(contextHandler);



      server.setHandler(new AppConfig().getHandlersConfig());
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       } finally {

            server.destroy();
        }



        ResourceHandler rh0 = new ResourceHandler();

        ContextHandler context0 = new ContextHandler();
        context0.setContextPath("/");

        context0.setBaseResource(Resource.newResource("webapp"));
        context0.setHandler(rh0);
        server.setHandler(context0);*/

        // Create a basic Jetty server object that will listen on port 8080.  Note that if you set this to port 0
        // then a randomly available port will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server(8080);

        // Create the ResourceHandler. It is the object that will actually handle the request for a given file. It is
        // a Jetty Handler object so it is suitable for chaining with other handlers as you will see in other examples.
      //  ResourceHandler resource_handler = new ResourceHandler();

        // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
        // In this example it is the current directory but it can be configured to anything that the jvm has access to.
       // resource_handler.setDirectoriesListed(true);
       // resource_handler.setWelcomeFiles(new String[]{"login.html"});
        //resource_handler.setResourceBase("./src/main/resources/webapp");
        server.setHandler(new AppConfig().getHandlersConfig());
        // Add the ResourceHandler to the server.
       // HandlerList handlers = new HandlerList();
       // handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
       // server.setHandler(handlers);

        // Start things up! By using the server.join() the server thread will join with the current thread.
        // See "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()" for more details.
        server.start();
        server.join();

    }




}