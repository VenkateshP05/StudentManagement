import java.sql.ResultSet;

public interface Table {
    int insert() throws Exception;

    ResultSet read() throws Exception;

    void display(ResultSet rs) throws Exception;

    String row(ResultSet rs) throws Exception;



}
