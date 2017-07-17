package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AutorizationServlet;
import servlets.RegistrationServlet;

import javax.servlet.http.HttpServlet;

public class Launcher {
    public static void main(String[] args) throws Exception {

        System.out.println("Start of server.");

        HttpServlet authServlet = new AutorizationServlet();
        HttpServlet regServlet = new RegistrationServlet();

        Server server = new Server(8080);
        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(authServlet),"/authform");
        context.addServlet(new ServletHolder(regServlet), "/regform");

        server.start();
        server.join();


    }
}
