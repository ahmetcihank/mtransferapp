package com.sft;


import com.sft.Helper.DBFunctions;
import com.sft.restendpoints.Controller;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by SOFTWARE02 on 12.01.2019.
 */
public class Main {
    public static void main(String[] args) throws Exception{

        DBFunctions.createH2();
        Server server = new Server(7071);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitParameter("jersey.config.server.provider.classnames",
                Controller.class.getCanonicalName());

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }

    }
}
