package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import enums.Status;
import pojo.Student;

public class StudentDao extends CreateConn {

  // PreparedStatement preparedStatement;

  public static Student select(int id) {

    String selectSql = "select id,name,status from student where id=" + id;

    try {
      resultSet = statement.executeQuery(selectSql);
      if (resultSet.next()) {
        Student student = new Student();
        student.setName(resultSet.getString("name"));
        student.setStatus(Status.getType(resultSet.getString("status")));
        student.setId(id);
        return student;
      }
    } catch (SQLException e) {
      System.out.println("student:SQLException:select");
    }
    return null;
  }

  public static void insert(Student student) {
    String insertSql = String.format("insert into student(id,name,status) values('%d','%s','%s') ",
        student.getId(), student.getName(), student.getStatus());
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

  public static int update(int id, int status) {
    String updateSql = String.format("update student set status='%s' where id = %d", Status.get(status), id);
    try {
      return statement.executeUpdate(updateSql);
    } catch (SQLException e) {
      System.out.println("student:SQLException:update");
    }
    return -1;
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