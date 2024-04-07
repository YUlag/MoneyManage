package SQL;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class Delete {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static boolean deleteEmp(String ID){
        String sql = "delete from emp where EmpID = ?";
        int update = jdbcTemplate.update(sql, ID);
        if (update > 0){
            return true;
        }else {
            return false;
        }
    }
}
