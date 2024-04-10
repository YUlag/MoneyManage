package SQL;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class Insert {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void addEmp(String number, String username, String password, String name, String denger, String position, String department, String financialAuthority, String time, String birth) {
        String sql = "INSERT INTO emp (EmpID,Username,Password,Name,Gender,PositionID,DepartmentID,HireYear,Birthdate,FinancialAuthority) VALUES (?,?,?,?,?,?,?,?,?,?);";
        int positionID = Select.selectPositionIDByName(position);
        int departmentID = Select.selectDepartmentIDByName(department);
        int insertNumber = jdbcTemplate.update(sql, number, username, password, name, denger, positionID, departmentID, time, birth, financialAuthority);
        if (insertNumber > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
