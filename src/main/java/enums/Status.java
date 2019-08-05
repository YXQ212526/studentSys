package enums;

public enum Status {

  NORAML(0,"正常"),
  VACATION(1,"放假"),
  SUSPENSION(2,"休学"),
  FIRE(3,"开除");
  private String status;
  private int type;
  Status(int type,String status) {
    this.status = status;
  }
  public static String get(int type)
  {
    for (Status status:Status.values()){
      if(status.type==type)
        return status.status;
    }
    return null;
  }
  public static int getType(String string){
    for (Status ele:Status.values()){
      if(ele.status.equals(string))
        return ele.type;
    }
    return -1;
  }
}
