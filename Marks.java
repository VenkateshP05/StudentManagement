import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Marks implements Table{
    DataBase database;
    private int id;
    private int maths;
    private int physics;
    private int chemistry;
    public Marks(DataBase database){
        this.database = database;
    }

    public Marks(DataBase database,
                 int id,
                 int maths,
                 int physics,
                 int chemistry){
        this.database = database;
        this.id = id;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }
    public ResultSet read() throws Exception{
        String query = "select* from marks";
        PreparedStatement st = database.connection().prepareStatement(query);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs;
    }

    public int insert() throws Exception{
        String query = "insert into marks values(?,?,?,?)";
        PreparedStatement st = database.connection().prepareStatement(query);
        st.setInt(1,id);
        st.setInt(2,maths);
        st.setInt(3,physics);
        st.setInt(4,chemistry);

        return st.executeUpdate();
    }

    public void display(ResultSet rs) throws Exception{
        do{
            System.out.println(row(rs));
        }while(rs.next());
    }
    public String row(ResultSet rs) throws Exception{
        return String.format("%d\t%d\t%d\t%d\t",
                rs.getInt("rollnumber"),
                rs.getInt("maths"),
                rs.getInt("physics"),
                rs.getInt("chemistry"));
    }



}
