package no.tbo.jettyTest;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import no.tbo.jettyTest.res.MsgJson;

/**
 * Hello world!
 *
 */
public class App {
  private static final Logger lgr = Logger.getLogger( App.class.getName() );
  private static FileHandler fh = null;
  
  public static void main(String[] args) throws Exception {
    Server srv = new Server(8080);
    
    // Log init
    fh = new FileHandler("logger.log", false);
    fh.setFormatter(new SimpleFormatter());
    lgr.addHandler(fh);
    lgr.setLevel(Level.CONFIG);
    

    /* Ny starter her */
    // JsonResource
    MsgJson jsonRes = new MsgJson();
    ResourceConfig rc = new ResourceConfig();
    rc.register(jsonRes);
    ServletContainer sc = new ServletContainer(rc);
    ServletHolder sh = new ServletHolder(sc);
    ServletContextHandler jsonResourceHandler = new ServletContextHandler();
    jsonResourceHandler.addServlet(sh, "/*");
    
    // StaticResource
    String baseStr = "webapp";    
    String webDir = App.class.getClassLoader().getResource(baseStr).toExternalForm();
    lgr.info("WebDir = " + webDir);
    ResourceHandler rhS = new ResourceHandler();
    rhS.setDirectoriesListed(true);
    rhS.setRedirectWelcome(true);
    rhS.setWelcomeFiles(new String[]{ "index.html" });
    rhS.setResourceBase(webDir);
    
    HandlerList handlers = new HandlerList();    
    handlers.setHandlers(new Handler[] {rhS, jsonResourceHandler, new DefaultHandler()});
    
    srv.setHandler(handlers);
    
    try {
      srv.start();
      srv.join();
    } catch (Exception e) {
      //Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
      lgr.log(Level.SEVERE, null, e);
    } finally {
      srv.destroy();
    }
  }
}
