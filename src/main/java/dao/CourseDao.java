package dao;

import java.sql.SQLException;

import pojo.Course;

public class CourseDao extends CreateConn {


  public static String select(int id) {

    String selectSql = "select name from course where id=" + id;

    try {
      resultSet = statement.executeQuery(selectSql);
      if (resultSet.next()) {
        String name = resultSet.getString("name");
        System.out.println("course:select success");
        return name;
      }
    } catch (SQLException e) {
      System.out.println("Course:SQLException:select");
    }

    return null;
  }

  public static void insert(String name) {
    String insertSql = String.format("insert into course(name) values('%s') ", name);

    try {
      statement.execute(insertSql);
      System.out.println("course:insert success");

    } catch (SQLException e) {
      System.out.println("Course:SQLException:insert");
    }
  }

  public static void update(Course course) {
    String updateSql = String.format("update course set name=%s where id = %d", course.getName(), course.getId());
    try {
      statement.execute(updateSql);
      System.out.println("course:update success");
    } catch (SQLException e) {
      System.out.println("Course:SQLException:update");
    }
  }

  public static void delete(int id) {
    String deleteSql = String.format("delete from course where id = %d", id);
    try {
      statement.execute(deleteSql);
      System.out.println("course:delete success");
    } catch (SQLException e) {
      System.out.println("Course:SQLException:delete");
    }
  }
}
