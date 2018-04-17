package no.tbo.jettyTest.res;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import no.tbo.jettyTest.App;

@Path("status")
public class Message {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
    String version = "Noe gikk feil";
    String ut = null;
    Properties prop = new Properties();
    try {
      prop.load(this.getClass().getClassLoader().getResourceAsStream("jettyTest.properties"));
      version = prop.getProperty("project.version");
    } catch (IOException e) {
      //e.printStackTrace();
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
    }
    
    ut = "Versjon: " + version + "\n";
    
    DbHelper db = new DbHelper();
    Connection conn = db.getConn();
    
    if (conn != null) {
      ut+="Tilkobling til database: OK!\n";
    } else {
      ut+="Tilkobling til database: FEIL!\n";
    }
	  	  
	  return ut;
	}

}
