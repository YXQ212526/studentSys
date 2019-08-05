package dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Student;

public class StudentDaoTest {

  @BeforeClass
  public void insert() {
    StudentDao.insert("jim");
    StudentDao.insert("alice");
    StudentDao.insert("bob");

  }

  @Test
  public void select() {
    Assert.assertEquals(StudentDao.select(1), "jim");
    Assert.assertNull(StudentDao.select(0));
  }


  @Test
  public void update() {

  }

  @Test
  public void delete() {

  }

}
