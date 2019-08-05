package dao;

import java.sql.SQLException;

import enums.Status;
import pojo.Student;

public class StudentDao extends CreateConn {

  // PreparedStatement preparedStatement;

  public static String select(int id) {

    String selectSql = "select name from student where id=" + id;

    try {
      resultSet = statement.executeQuery(selectSql);
      if (resultSet.next()) {
        String name = resultSet.getString("name");
        System.out.println("student:select success");
        return name;
      }
    } catch (SQLException e) {
      System.out.println("student:SQLException:select");
    }
    return null;
  }

  public static void insert(String name) {
    String insertSql = String.format("insert into student(name) values('%s') ", name);
    // String insertSql = "insert into student(name) values(?) ";
    //  String insertSql = "insert into student(name) values('"+name+"')";
    //  String insertSql = "insert into student(name) values('hi')";

    try {
//      preparedStatement=connection.prepareStatement(insertSql);
//      preparedStatement.setString(1,name);
//      preparedStatement.execute();
      statement.execute(insertSql);
      System.out.println("student:insert success");

    } catch (SQLException e) {
      System.out.println("student:SQLException:insert");
    }
  }

  public static void update(int id, int status) {
    String updateSql = String.format("update student set status=%s where id = %d", Status.get(status), id);
    try {
      if (statement.executeUpdate(updateSql) == 0) {
        System.out.println("student:update nothing");
      } else {
        System.out.println("student:update success");
      }
    } catch (SQLException e) {
      System.out.println("student:SQLException:update");
    }
  }

  public static void delete(int id) {
    String deleteSql = String.format("delete from student where id = %d", id);
    try {
      statement.execute(deleteSql);
      System.out.println("student:delete success");

    } catch (SQLException e) {
      System.out.println("student:SQLException:delete");
    }
  }

}