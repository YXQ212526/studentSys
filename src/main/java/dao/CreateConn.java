package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Close;

public class CreateConn {

  protected static Connection connection;
  protected static Statement statement;
  protected static ResultSet resultSet;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("pojo.Course:ClassNotFoundException");
    }
    try {
      connection = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/studentSys?useSSL=false&serverTimezone=UTC", "root", "Yxq12345!");
    } catch (SQLException e) {
      System.out.println("pojo.Course:SQLException:connect");
    }
    try {
      statement = connection.createStatement();
    } catch (SQLException e) {
      System.out.println("pojo.Course:SQLException:state");
    }
  }
  public static void close() {
    Close.colse(resultSet,statement,connection);
  }

}
