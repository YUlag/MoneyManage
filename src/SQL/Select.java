package SQL;

import atom.Emp;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.util.List;

public class Select {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    static RowMapper<Emp> EmpRowMapper = new BeanPropertyRowMapper<>(Emp.class);

    public static List<Emp> selectAllEmp() {
        String sql = "select" +
                "    e.EmpID,\n" +
                "    e.Username,\n" +
                "    e.Password,\n" +
                "    e.Name,\n" +
                "    e.Gender,\n" +
                "    FLOOR(DATEDIFF(CURDATE(), e.Birthdate) / 365) AS age,\n" +
                "    p.PositionName AS position,\n" +
                "    d.DepartmentName AS department,\n" +
                "    e.HireYear,\n" +
                "    e.FinancialAuthority\n" +
                "from emp e\n" +
                "JOIN moneymanage.departments d on d.DepartmentID = e.DepartmentID\n" +
                "JOIN moneymanage.positions p on p.PositionID = e.PositionID\n" +
                "ORDER BY e.EmpID ASC;";
        List<Emp> query = jdbcTemplate.query(sql, EmpRowMapper);
        return query;
    }

    public static Emp selectEmpById(int ID){
        String sql = "select\n" +
                "    e.EmpID,\n" +
                "    e.Username,\n" +
                "    e.Password,\n" +
                "    e.Name,\n" +
                "    e.Gender,\n" +
                "    p.PositionName AS position,\n" +
                "    d.DepartmentName AS department,\n" +
                "    e.HireYear,\n" +
                "    e.FinancialAuthority,\n" +
                "    e.Birthdate\n" +
                "from emp e\n" +
                "JOIN moneymanage.departments d on d.DepartmentID = e.DepartmentID\n" +
                "JOIN moneymanage.positions p on p.PositionID = e.PositionID\n" +
                "where EmpID = ? LIMIT 1";
        List<Emp> emps = jdbcTemplate.query(sql, EmpRowMapper,ID);
        Emp emp = emps.get(0);
        return emp;
    }

    public static int selectDepartmentIDByName(String departmentName){
        String sql = "select DepartmentID from departments where DepartmentName = ?";
        Integer departmentID = jdbcTemplate.queryForObject(sql, Integer.class, departmentName);
        return departmentID;
    }

    public static int selectPositionIDByName(String positionName){
        String sql = "select PositionID from positions where PositionName = ?";
        Integer positionID = jdbcTemplate.queryForObject(sql, Integer.class, positionName);
        return positionID;
    }
}
