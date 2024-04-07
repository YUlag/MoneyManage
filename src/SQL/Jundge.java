package SQL;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;
import atom.Emp;

import java.util.List;

public class Jundge {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    static RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);

    public static String loginJundge(String username, String password) throws Exception {


        String query = "SELECT * FROM emp WHERE Username = ? AND Password = ? LIMIT 1";


            // 查询单个对象
            List<Emp> emp = jdbcTemplate.query(query, rowMapper, username, password);

            if (!emp.isEmpty()) {
                return "OK";
            }

        return "Error";
    }
}

