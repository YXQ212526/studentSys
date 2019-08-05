package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import pojo.Score;

public class ScoreDao extends CreateConn {

  public static Map<Integer, Integer> select(int studentId, int year) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    String selectSql = "select course_id,goal from score where student_id=" + studentId + " and year=" + year;

    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        Integer course = resultSet.getInt("course_id");
        int goal = resultSet.getInt("goal");
        map.put(course, goal);

      }
      System.out.println("score:select success");
      return map;
    } catch (SQLException e) {
      System.out.println("score:SQLException:select");
    }

    return null;
  }

  public static Map<Integer, Integer> getTop10() {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    String selectSql = "select student.id,"
        + "sum(score.goal) as 总成绩 "
        + "from student inner join score on "
        + "student.id=score.student_id "
        + "group by student.id "
        + "order by 总成绩 limit 10 ";

    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        map.put(resultSet.getInt("id"), resultSet.getInt("总成绩"));
      }
      System.out.println("score:getTop10 success");
      return map;
    } catch (SQLException e) {
      System.out.println("score:SQLException:top10");
    }

    return null;
  }

  public static Map<Integer, Double> GPA() {

    Map<Integer, Double> map = new HashMap<Integer, Double>();
    String selectSql = "select student.id,avg(goal) from"
        + " student,score where student.id=score.student_id "
        + "group by student.id";

    try {
      resultSet = statement.executeQuery(selectSql);
      while (resultSet.next()) {
        map.put(resultSet.getInt("id"), resultSet.getDouble("avg(goal)") * 4 / 100);
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
