package no.tbo.jettyTest.res;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import no.tbo.jettyTest.dao.Server;

@Path("srvJSON")
public class ServerJSON {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Server> getServerJSON() {
    List<Server> srv = new ArrayList<Server>();
    DbHelper db = new DbHelper();
    ResultSet rs = db.test();
    Server s = null;

    try {
      while (rs.next()) {    
        s = new Server(rs.getInt("server_id"), rs.getString("servernavn"), rs.getInt("miljo_id"));
        srv.add(s);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return srv;
  }

}
