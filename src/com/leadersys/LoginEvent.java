package com.leadersys;

import GUI.test0;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEvent implements ActionListener {
	private static final String USER_TABLE_QUERY = "SELECT * FROM user"; // ��ѯ�û����SQL���

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = Login.getUsernameText();
		String password = Login.getPasswordText();

		try {
			// ��������Ƿ�Ϊ��
			if (isEmptyInput(username, password)) {
				showEmptyInputError();
				return;
			}

			// ִ�����ݿ��ѯ
			ResultSet rs = queryDatabaseForUser(username, password);

			// ����Ƿ��ҵ�ƥ����û���¼
			boolean userExists = checkUserCredentials(rs, username, password);

			if (userExists) {
				// ��¼�ɹ���ִ�к�������
				Leader.disappear();
				new LoginSuccessHandler().handleSuccess();
			} else {
				// ��¼ʧ�ܣ���ʾ������Ϣ
				showLoginFailureMessage();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// ��ѯ���ݿ�����֤�û�ƾ��
	private ResultSet queryDatabaseForUser(String username, String password) throws SQLException {
		return ManageDatabaseReading.sql.executeQuery(USER_TABLE_QUERY);
	}

	// ����û��Ƿ�ƥ��
	private boolean checkUserCredentials(ResultSet rs, String username, String password) {
		try {
			while (rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");

				if (username.equals(dbUsername) && password.equals(dbPassword)) {
					return true;
				}
			}
			return false;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}

	// ��������Ƿ�Ϊ��
	private boolean isEmptyInput(String username, String password) {
		return username.isEmpty() || password.isEmpty();
	}

	// ��ʾ�����������Ϣ
	private void showEmptyInputError() {
		JOptionPane.showMessageDialog(null, "�˺ź����붼����Ϊ��", "�������", JOptionPane.WARNING_MESSAGE);
	}

	// ��ʾ��¼ʧ����Ϣ
	private void showLoginFailureMessage() {
		JOptionPane.showMessageDialog(null, "�˺Ż��������", "��¼ʧ��", JOptionPane.WARNING_MESSAGE);
	}

	// ��¼�ɹ�������
	private class LoginSuccessHandler {
		public void handleSuccess() {
			test0 crudInterface = new test0();
			crudInterface.setTitle("����Ա��ɾ�Ĳ����");
			crudInterface.setSize(1000, 500); // �������ڴ�С����Ӧ���
			crudInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			crudInterface.setLocationRelativeTo(null);

			crudInterface.setVisible(true);
        }
	}
}
