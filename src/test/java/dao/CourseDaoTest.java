package dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Course;


public class CourseDaoTest {

  @BeforeClass
  public static void insert() {
    Course course1 = new Course();
    course1.setId(1);
    course1.setName("math");
    Course course2 = new Course();
    course2.setId(2);
    course2.setName("english");

    CourseDao.insert(course1);
    CourseDao.insert(course2);

  }

  @AfterClass
  public static void close() {
    CreateConn.close();
  }

  @Test
  public void select() {
    Assert.assertEquals(CourseDao.select(1).getName(), "math");
    Assert.assertNull(CourseDao.select(0));
  }

  @Test
  public void update() {

    Assert.assertSame(CourseDao.update(1, "chinese"), 1);
    Assert.assertSame(CourseDao.update(0, "chinese"), 0);
  }

  @Test
  public void delete() {
    CourseDao.delete(2);
    Assert.assertNull(CourseDao.select(2));
  }
}
