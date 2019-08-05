package pojo;

import enums.Status;

public class Student {

  private int id;
  private String name;
  private String status = "正常";

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {

    return status;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(int type) {
    String status = Status.get(type);
    this.status = status;
  }

}
