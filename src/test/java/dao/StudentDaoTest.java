package dao;


import enums.Status;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.Student;

public class StudentDaoTest {

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


  }

  @AfterClass
  public static void close() {

    CreateConn.close();
  }

  @Test
  public void select() {

    Assert.assertEquals(StudentDao.select(1).getName(), "jim");
    Assert.assertEquals(StudentDao.select(2).getStatus(), "正常");
    Assert.assertNull(StudentDao.select(0));
  }


  @Test
  public void update() {

    int result = StudentDao.update(1, 10);
    int result1 = StudentDao.update(2, 1);
    int result2 = StudentDao.update(10, 1);
    Assert.assertEquals(StudentDao.select(2).getStatus(), Status.get(1));
    Assert.assertEquals(StudentDao.select(1).getStatus(), null);
    Assert.assertSame(1, result);
    Assert.assertSame(1, result1);
    Assert.assertSame(0, result2);

  }

  @Test
  public void delete() {
    StudentDao.delete(3);
    Assert.assertNull(StudentDao.select(3));
  }

}
