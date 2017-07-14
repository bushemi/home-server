package main;

import servlets.AuthServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Launcher {
    public static void main(String[] args) throws Exception {

        System.out.println("Start of server.");

        AuthServlet authServlet = new AuthServlet();

        Server server = new Server(8080);
        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(authServlet),"/authform");

        server.start();
        server.join();
    }
}
