package no.tbo.jettyTest.res;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Track {
  String title;
  String singer;
  Integer id;
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getSinger() {
    return singer;
  }
  public void setSinger(String singer) {
    this.singer = singer;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

}
