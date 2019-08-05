import dao.CreateConn;
import dao.StudentDao;
import pojo.Student;

public class Main {

  public static void main(String[] args) {
  //  dao.StudentDao studentDao = new dao.StudentDao();
    //studentDao.insert("xiaoming");
    // studentDao.select(1);

    // studentDao.update(1,"xiao");
    StudentDao.insert("jack");
    Student student=new Student();
    student.setName("lily");
    StudentDao.update(student);
    StudentDao.delete(3);

    CreateConn.close();
  //  studentDao.delete(1);
    //studentDao.close();
  }
}
