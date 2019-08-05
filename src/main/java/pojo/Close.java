package pojo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class  Close {

  public static void colse(ResultSet resultSet, Statement statement, Connection connection){

    try {
      if (resultSet != null) {
        resultSet.close();
      }
    } catch (SQLException e) {
      System.out.println("SQLException:resultSet close");
    }
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      System.out.println("SQLException:statement close");
    }
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      System.out.println("SQLException:connection close");
    }
  }

  }


