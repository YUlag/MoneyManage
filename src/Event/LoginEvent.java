package Event;

import GUI.ManageGUI;
import SQL.Jundge;
import com.yulag.Leader;
import com.yulag.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static SQL.Jundge.LoginJundge;

public class LoginEvent implements ActionListener {
	private static final String USER_TABLE_QUERY = "SELECT Username,Password FROM user"; // 查询用户表的SQL语句

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = Login.getUsernameText();
		String password = Login.getPasswordText();

		try {
			// 检查输入是否为空
			if (isEmptyInput(username, password)) {
				showEmptyInputError();
				return;
			}

			// 检查是否找到匹配的用户记录
			String role = LoginJundge(username, password);

			if (!role.equals("Error")) {
//				System.out.println(role);
				// 登录成功，执行后续操作
				Leader.disappear();
				new LoginSuccessHandler().handleSuccess();
			} else {
				// 登录失败，显示错误消息
				showLoginFailureMessage();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

	// 查询数据库以验证用户凭据
//	private ResultSet queryDatabaseForUser(String username, String password) throws SQLException {
//		return ManageDatabaseReading.sql.executeQuery(USER_TABLE_QUERY);
//	}


	// 检查用户是否匹配
//	private boolean checkUserCredentials(ResultSet rs, String username, String password) {
//		try {
//			while (rs.next()) {
//				String dbUsername = rs.getString("username");
//				String dbPassword = rs.getString("password");
//
//				if (username.equals(dbUsername) && password.equals(dbPassword)) {
//					return true;
//				}
//			}
//			return false;
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException();
//		}
//	}

	// 检查输入是否为空
	private boolean isEmptyInput(String username, String password) {
		return username.isEmpty() || password.isEmpty();
	}

	// 显示空输入错误消息
	private void showEmptyInputError() {
		JOptionPane.showMessageDialog(null, "账号和密码都不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
	}

	// 显示登录失败消息
	private void showLoginFailureMessage() {
		JOptionPane.showMessageDialog(null, "账号或密码错误", "登录失败", JOptionPane.WARNING_MESSAGE);
	}

	// 登录成功处理器
	private class LoginSuccessHandler {
		public void handleSuccess() {
			ManageGUI crudInterface = new ManageGUI();
			crudInterface.setTitle("管理员增删改查界面");
			crudInterface.setSize(1000, 500); // 调整窗口大小以适应组件
			crudInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			crudInterface.setLocationRelativeTo(null);

			crudInterface.setVisible(true);
        }
	}
}
