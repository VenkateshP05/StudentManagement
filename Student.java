import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student implements Table{

    private DataBase database;

    private String name;
    private int id;
    private String email;

    private String phoneNumber;

    public Student(DataBase database){
        this.database = database;
    }

    public void createTable() throws Exception {
        String query = "CREATE TABLE student ( " +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(20) NOT NULL, " +
                "email VARCHAR(30) UNIQUE, " +
                "phoneNumber CHAR(10) NOT NULL, " +
                ")";
        PreparedStatement st = database.connection().prepareStatement(query);
        st.executeUpdate();
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email) throws InvalidEmailException{
        if(email.endsWith("@gmail.com"))
            this.email = email;
        else
            throw new InvalidEmailException("Invalid Email");
    }

    public void setPhoneNumber(String phoneNumber)
    throws InvalidPhoneNumberException{
        if(phoneNumber.length() == 10)
            this.phoneNumber = phoneNumber;
        else
            throw new InvalidPhoneNumberException("Invalid PhoneNumber");
    }


    @Override
    public int insert() throws Exception {
        String query = "insert into student values(?,?,?,?)";
        PreparedStatement st = database.connection().prepareStatement(query);
        st.setInt(1,id);
        st.setString(2,name);
        st.setString(3,email);
        st.setString(4,phoneNumber);

        return st.executeUpdate();
    }

    @Override
    public ResultSet read() throws Exception {
        String query = "select* from student";
        PreparedStatement st = database.connection().prepareStatement(query);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs;
    }

    @Override
    public void display(ResultSet rs) throws Exception {
        do{
            System.out.println(row(rs));
        }while(rs.next());
    }

    @Override
    public String row(ResultSet rs) throws Exception {
        return String.format("%d\t%s\t%s\t%s\t",
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phoneNumber"));
    }
}
