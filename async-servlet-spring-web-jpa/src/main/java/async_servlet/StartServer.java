package async_servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class StartServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new QueuedThreadPool(5));
        ServerConnector serverConnector = new ServerConnector(server);
        serverConnector.setPort(9999);
        server.setConnectors(new Connector[]{serverConnector});

        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/web");//localhost"999/web -> BL Application

        ServletHolder servletHolder = new ServletHolder();
        servletHolder.setServlet(new UserServlet());
        servletHolder.setAsyncSupported(true);
        servletContextHandler.addServlet(servletHolder, "/users");
        
        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
