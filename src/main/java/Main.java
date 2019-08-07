import java.util.Map;

import dao.CreateConn;
import dao.ScoreDao;
import dao.StudentDao;
import pojo.Course;
import pojo.Score;
import pojo.Student;

public class Main {

  public static void main(String[] args) {
  //  dao.StudentDao studentDao = new dao.StudentDao();
    //studentDao.insert("xiaoming");
    // studentDao.select(1);

    // studentDao.update(1,"xiao");
//    StudentDao.insert("jack");
//    Student student=new Student();
//    student.setName("lily");
//    StudentDao.update(student);
    //StudentDao.delete(3);
   // Map<Student,Map<Course, Score>>map=ScoreDao.select(1,2019);
   Map<Student,Integer>map1= ScoreDao.getTop10();
   // System.out.println(map);
   // CreateConn.close();
  //  studentDao.delete(1);
    //studentDao.close();
  }
}
