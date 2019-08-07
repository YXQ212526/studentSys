package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import pojo.Course;
import pojo.Score;
import pojo.Student;

public class ScoreDao extends CreateConn {

  public static Map<Student, Map<Course, Score>> select(int studentId, int year) {

    Map<Student, Map<Course, Score>> map = new HashMap<Student, Map<Course, Score>>();
    // String selectSql = "select course_id,goal from score where student_id=" + studentId + " and year=" + year;
    String selectSql = String.format("select student.id as sid,student.name as sname,course.id as cid,course.name as cname, goal "
        + "from student,score,course where student.id=%d and year=%d "
        + "and student.id=score.student_id and course.id=score.course_id", studentId, year);
    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        Student student = new Student();
        student.setName(resultSet.getString("sname"));
        student.setId(resultSet.getInt("sid"));
        Course course = new Course();
        course.setId(resultSet.getInt("cid"));
        course.setName(resultSet.getString("cname"));
        Score score = new Score();
        score.setGoal(resultSet.getInt("goal"));
        Map<Course, Score> interMap = new HashMap<Course, Score>();
        interMap.put(course, score);
        map.put(student, interMap);
      }
      System.out.println("score:select success");
      return map;
    } catch (SQLException e) {
      System.out.println("score:SQLException:select");
    }

    return null;
  }

  public static Map<Student, Integer> getTop10() {

    Map<Student, Integer> map = new HashMap<Student, Integer>();
    String selectSql = "select student.id,student.name,"
        + "sum(score.goal) as 总成绩 "
        + "from student inner join score on "
        + "student.id=score.student_id "
        + "group by student.id "
        + "order by 总成绩 limit 10 ";

    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        Student student = new Student();
        student.setName(resultSet.getString("name"));
        student.setId(resultSet.getInt("id"));
        map.put(student, resultSet.getInt("总成绩"));
      }
      System.out.println("score:getTop10 success");
      return map;
    } catch (SQLException e) {
      System.out.println("score:SQLException:top10");
    }

    return null;
  }

  public static Map<Student, Double> GPA() {

    Map<Student, Double> map = new HashMap<Student, Double>();
    String selectSql = "select student.id,student.name,avg(goal) from"
        + " student,score where student.id=score.student_id "
        + "group by student.id";

    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        Student student=new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        map.put(student, resultSet.getDouble("avg(goal)") * 4 / 100);
      }
      System.out.println("score:GPA success");
      return map;
    } catch (SQLException e) {
      System.out.println("score:SQLException:GPA");
    }

    return null;
  }

  public static void insert(Score score) {
    String insertSql = String.format("insert into score(course_id,goal,student_id,year) values('%d','%d','%d','%d')",
        score.getCourseId(), score.getGoal(), score.getStudentId(), score.getYear());

    try {
      statement.execute(insertSql);
      System.out.println("score:insert success");
    } catch (SQLException e) {
      System.out.println("score:SQLException:insert");
    }
  }


}
