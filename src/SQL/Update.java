package SQL;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;
import javax.swing.*;

public class Update {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void updateEmp(String number, String username, String password, String name, String denger, String position, String department, String financialAuthority, String time, String birth) {
        String sql = "UPDATE emp SET Username = ?,Password = ?,Name = ?,Gender = ?,PositionID = ?,DepartmentID = ?,FinancialAuthority = ?,HireYear = ?,Birthdate = ? where EmpID = ?";

        int positionID = Select.selectPositionIDByName(position);
        int departmentID = Select.selectDepartmentIDByName(department);
        int updateNumber = jdbcTemplate.update(sql, username, password, name, denger, positionID, departmentID, financialAuthority, time, birth, number);
        if (updateNumber > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }
}
