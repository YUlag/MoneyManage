package SQL;

import atom.User;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class Update {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void UpdateEmp(String number,String name,String denger,String dept,String time) {
        String query = "SELECT * FROM user WHERE Username = ? AND Password = ? LIMIT 1";

    }
}
