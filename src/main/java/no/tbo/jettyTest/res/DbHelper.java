package no.tbo.jettyTest.res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import no.tbo.jettyTest.App;



public class DbHelper {

  public String getJdbcURL() {
    return jdbcURL;
  }

  public void setJdbcURL(String jdbcURL) {
    this.jdbcURL = jdbcURL;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public Connection getConn() {
    return conn;
  }

  private String jdbcURL = "jdbc:postgresql://10.0.0.219:5432/orateam";
  private String uid = "orateam";
  private String pwd = "maetaro";
  private Connection conn = null;
  
  public DbHelper() {
    super();
    try {
      conn = DriverManager.getConnection(jdbcURL, uid, pwd);
    } catch (Exception e) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
    }
  }
  
  public ResultSet test() {
    Statement stmnt = null;
    ResultSet res = null;
    String sql = "select * from server";    
    try {
      stmnt = conn.createStatement();
      res = stmnt.executeQuery(sql);
    } catch (Exception e) {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
    }
    return res;
  }
  
  
}
