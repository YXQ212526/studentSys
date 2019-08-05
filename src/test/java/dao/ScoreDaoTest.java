package dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Course;
import pojo.Score;
import pojo.Student;

public class ScoreDaoTest {

  @BeforeClass
  public static void insert() {

    Student student1 = new Student();
    student1.setId(1);
    student1.setName("jim");
    Student student2 = new Student();
    student2.setId(2);
    student2.setName("alice");
    Student student3 = new Student();
    student3.setId(3);
    student3.setName("bob");

    StudentDao.insert(student1);
    StudentDao.insert(student2);
    StudentDao.insert(student3);

    Score score1 = new Score();
    score1.setCourseId(1);
    score1.setGoal(80);
    score1.setStudentId(1);
    score1.setYear(2019);
    Score score2 = new Score();
    score2.setCourseId(2);
    score2.setGoal(70);
    score2.setStudentId(1);
    score2.setYear(2019);
    Score score3 = new Score();
    score3.setCourseId(3);
    score3.setGoal(20);
    score3.setStudentId(2);
    score3.setYear(2019);
    Score score4 = new Score();
    score4.setCourseId(2);
    score4.setGoal(50);
    score4.setStudentId(3);
    score4.setYear(2019);

    ScoreDao.insert(score1);
    ScoreDao.insert(score2);
    ScoreDao.insert(score3);
    ScoreDao.insert(score4);
  }

  @AfterClass
  public static void close() {
    CreateConn.close();
  }

  @Test
  public void select() {
    Assert.assertSame(ScoreDao.select(1, 2019).size(), 2);
    Assert.assertSame(ScoreDao.select(1, 2019).get(1), 80);
    Assert.assertSame(ScoreDao.select(1, 2019).get(2), 70);
    Assert.assertNull(ScoreDao.select(0, 2019).get(1));
  }

  @Test
  public void getTop10() {
    Assert.assertSame(ScoreDao.getTop10().size(), 3);
    Assert.assertTrue(ScoreDao.getTop10().get(1) == 150);
    Assert.assertTrue(ScoreDao.getTop10().get(2) == 20);
    Assert.assertTrue(ScoreDao.getTop10().get(3) == 50);

  }

  @Test
  public void GPA() {
    Assert.assertSame(ScoreDao.GPA().size(), 3);
    Assert.assertTrue(ScoreDao.GPA().get(1) == 3.0);
    Assert.assertTrue(ScoreDao.GPA().get(2) == 0.8);
    Assert.assertTrue(ScoreDao.GPA().get(3) == 2);

  }
}
