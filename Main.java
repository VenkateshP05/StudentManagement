import java.sql.ResultSet;
import java.util.Scanner;

public class Main  {
    public static  void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        Table marks = new Marks(new DataBase(),
//                sc.nextInt(),
//                sc.nextInt(),
//                sc.nextInt(),
//                sc.nextInt()
//                );
        Student student  = new Student(new DataBase());
//        student.createTable();
        System.out.println("Enter student details : " +
                "id  name  email  phone number");
        student.setId(sc.nextInt());
        student.setName(sc.next());
        student.setEmail(sc.next());
        student.setPhoneNumber(sc.next());

        student.insert();
        ResultSet rs = student.read();
        student.display(rs);

//        marks.insert();
//        ResultSet rs = marks.read();
//        marks.display(rs);
    }
}