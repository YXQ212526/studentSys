package dao;

import java.sql.SQLException;

import pojo.Course;

public class CourseDao extends CreateConn {


  public static Course select(int id) {

    String selectSql = "select name from course where id=" + id;

    try {
      resultSet = statement.executeQuery(selectSql);
      if (resultSet.next()) {
        Course course = new Course();
        course.setName(resultSet.getString("name"));
        course.setId(id);

        return course;
      }
    } catch (SQLException e) {
      System.out.println("Course:SQLException:select");
    }

    return null;
  }

  public static void insert(Course course) {
    String insertSql = String.format("insert into course(id,name) values('%d','%s') ", course.getId(), course.getName());

    try {
      statement.execute(insertSql);
      System.out.println("course:insert success");

    } catch (SQLException e) {
      System.out.println("Course:SQLException:insert");
    }
  }

  public static int update(int id, String name) {
    String updateSql = String.format("update course set name='%s' where id = %d", name, id);
    try {
      return statement.executeUpdate(updateSql);

    } catch (SQLException e) {
      System.out.println("Course:SQLException:update");
    }
    return -1;
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
