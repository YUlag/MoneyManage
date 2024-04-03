package SQL;

import atom.Emp;
import atom.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.util.List;

public class Select {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    static RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);

    public static List<Emp> selectAllEmp(){
        String sql = "select * from employee";
        List<Emp> query = jdbcTemplate.query(sql, rowMapper);
        return query;
    }
}
