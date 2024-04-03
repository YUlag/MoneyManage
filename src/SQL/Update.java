package SQL;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.swing.*;

public class Update {
    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void updateEmp(String number, String name, String denger, String dept, String time) {
        String sql = "UPDATE employee SET Name = ?,Gender = ?,Position = ?,HireYear = ? where EmployeeID = ?";

        if (number.equals("") || name.equals("") || denger.equals("") || dept.equals("") || time.equals("")){
            JOptionPane.showMessageDialog(null, "信息不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
        }else {
            int updateNumber = jdbcTemplate.update(sql, name, denger, dept, time, number);
            if(updateNumber > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        }
    }
}
