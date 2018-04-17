package no.tbo.jettyTest.res;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msgJson")
public class MsgJson {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Track> getTrackJson() {
    List<Track> ts = new ArrayList<Track>();
    
    Track t = new Track();
    t.setSinger("Ole Brumm");
    t.setTitle("Det snør, det snør");
    t.setId(1);
    
    ts.add(t);
    
    t.setSinger("Tigergutt");
    t.setTitle("En, to, tre");
    t.setId(2);
    
    ts.add(t);
    
    return ts;
  }

}
