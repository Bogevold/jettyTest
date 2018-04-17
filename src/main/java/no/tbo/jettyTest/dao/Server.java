package no.tbo.jettyTest.dao;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Server {
  public Server(Integer serverId, String serverNavn, Integer miljoId) {
    super();
    this.serverId = serverId;
    this.serverNavn = serverNavn;
    this.miljoId = miljoId;
  }
  public Server() {
    super();
  }
  
  Integer serverId;
  String serverNavn;
  Integer miljoId;
  public Integer getServerId() {
    return serverId;
  }
  public void setServerId(Integer serverId) {
    this.serverId = serverId;
  }
  public String getServerNavn() {
    return serverNavn;
  }
  public void setServerNavn(String serverNavn) {
    this.serverNavn = serverNavn;
  }
  public Integer getMiljoId() {
    return miljoId;
  }
  public void setMiljoId(Integer miljoId) {
    this.miljoId = miljoId;
  }
  
}
