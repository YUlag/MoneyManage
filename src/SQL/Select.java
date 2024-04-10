package SQL;

import atom.Emp;
import atom.Salary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

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
        List<Emp> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        return query;
    }

    public static Emp selectEmpById(int ID) {
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
        List<Emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class), ID);
        Emp emp = emps.get(0);
        return emp;
    }

    public static int selectDepartmentIDByName(String departmentName) {
        String sql = "select DepartmentID from departments where DepartmentName = ?";
        Integer departmentID = jdbcTemplate.queryForObject(sql, Integer.class, departmentName);
        return departmentID;
    }

    public static int selectPositionIDByName(String positionName) {
        String sql = "select PositionID from positions where PositionName = ?";
        Integer positionID = jdbcTemplate.queryForObject(sql, Integer.class, positionName);
        return positionID;
    }

    public static String[] getAllDepartmentName() {
        String sql = "select DepartmentName from departments";
        List<String> departmentNames = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("DepartmentName");
            }
        });
        return departmentNames.toArray(new String[0]);
    }

    public static String[] getAllPositionName() {
        String sql = "select PositionName from positions";
        List<String> positionNames = jdbcTemplate.query(sql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("PositionName");
            }
        });
        return positionNames.toArray(new String[0]);
    }

    public static List<Emp> selectEmp(String number, String name, String gender, String department, String position) {
        StringBuilder sql = new StringBuilder("select\n" +
                "e.EmpID,\n" +
                "e.Username,\n" +
                "e.Password,\n" +
                "e.Name,\n" +
                "e.Gender,\n" +
                "FLOOR(DATEDIFF(CURDATE(), e.Birthdate) / 365) AS age,\n" +
                "p.PositionName AS position,\n" +
                "d.DepartmentName AS department,\n" +
                "e.HireYear,\n" +
                "e.FinancialAuthority\n" +
                "from emp e\n" +
                "JOIN moneymanage.departments d on d.DepartmentID = e.DepartmentID\n" +
                "JOIN moneymanage.positions p on p.PositionID = e.PositionID\n" +
                "WHERE 1=1");
        // 初始化参数列表，用于存储查询条件中的参数值
        List<Object> params = new ArrayList<>();
        if (number.isEmpty() && name.isEmpty() && gender.isEmpty() && department.isEmpty() && position.isEmpty()) {
            sql.append("\nORDER BY EmpID ASC;");
            List<Emp> emps = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Emp.class));
            return emps;
        }
        // 检查员工编号是否非空，并构建模糊查询条件
        if (number != null && !number.isEmpty()) {
            sql.append(" AND EmpID LIKE ? ");
            params.add(number);
        }

        // 检查员工姓名是否非空，并构建模糊查询条件
        if (name != null && !name.isEmpty()) {
            sql.append(" AND name LIKE ? ");
            params.add("%" + name + "%");
        }

        // 检查性别是否非空，并构建查询条件（精确匹配）
        if (gender != null && !gender.isEmpty()) {
            sql.append(" AND gender = ? ");
            params.add(gender);
        }

        // 检查部门是否非空，并构建模糊查询条件
        if (department != null && !department.isEmpty()) {
            int departmentID = selectDepartmentIDByName(department);
            sql.append(" AND e.DepartmentID LIKE ? ");
            params.add(departmentID);
        }

        // 检查职位是否非空，并构建模糊查询条件
        if (position != null && !position.isEmpty()) {
            int positionID = selectPositionIDByName(position);
            sql.append(" AND e.PositionID LIKE ? ");
            params.add(positionID);
        }
        sql.append("\nORDER BY EmpID ASC;");
        // 执行查询，并将结果映射为Emp对象列表
        List<Emp> emps = jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(Emp.class));
        return emps;
    }

    /**
     * 下面是财务的相关查询
     */
    public static List<Salary> selectAllSalary() {
        String sql = "SELECT * FROM salaries\n" +
                "ORDER BY Year DESC,Month DESC";
        List<Salary> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Salary.class));
        return query;
    }

    public static List<Salary> selectSalary(String salaryID, String empID, String name, String year, String month) {
        StringBuilder sql = new StringBuilder("SELECT * FROM salaries\n" + "WHERE 1=1");

        // 初始化参数列表，用于存储查询条件中的参数值
        List<Object> params = new ArrayList<>();
        if (salaryID.isEmpty() && empID.isEmpty() && name.isEmpty() && year.isEmpty() && month.isEmpty()) {
            sql.append("\nORDER BY Year DESC,Month DESC");
            List<Salary> salaries = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Salary.class));
            return salaries;
        }

        if (salaryID != null && !salaryID.isEmpty()) {
            sql.append(" AND salaryID = ? ");
            params.add(salaryID);
        }

        if (name != null && !name.isEmpty()) {
            sql.append(" AND name LIKE ? ");
            params.add("%" + name + "%");
        }

        if (empID != null && !empID.isEmpty()) {
            sql.append(" AND empID = ? ");
            params.add(empID);
        }

        if (year != null && !year.isEmpty()) {
            sql.append(" AND year = ? ");
            params.add(year);
        }

        if (month != null && !month.isEmpty()) {
            sql.append(" AND month = ? ");
            params.add(month);
        }
        sql.append("\nORDER BY Year DESC,Month DESC");

        List<Salary> salaries = jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(Salary.class));
        return salaries;
    }

    public static Salary selectSalaryById(int ID) {
        String sql = "Select * from salaries\n" +
                "where SalaryID = ? LIMIT 1";
        List<Salary> salaries = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Salary.class), ID);
        Salary salary = salaries.get(0);
        return salary;
    }
}

