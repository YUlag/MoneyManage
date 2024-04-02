package SQL;

import Event.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.util.List;

public class Jundge {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    static RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    public static String LoginJundge(String username, String password) throws Exception {


        String query = "SELECT * FROM user WHERE Username = ? AND Password = ? LIMIT 1";


            // 查询单个对象
            List<User> users = jdbcTemplate.query(query, rowMapper, username, password);

            if (!users.isEmpty()) {
                return users.get(0).getRole();
            }

        return "Error";
    }
}

