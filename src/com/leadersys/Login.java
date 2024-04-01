package com.leadersys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame {
	private static final int WINDOW_WIDTH = 500; // 顶层框架的宽度
	private static final int WINDOW_HEIGHT = 320; // 顶层框架的高度
	private JPanel contentPanel; // 内容面板
	private JButton loginButton; // 登录按钮
	private JLabel titleLabel; // 标题标签
	private JLabel usernameLabel; // 用户名标签
	private JLabel passwordLabel; // 密码标签
	private static JTextField usernameInput; // 用户名输入框
	private static JPasswordField passwordInput; // 密码输入框

	public Login() {
		initializeUI();
		setupDatabaseConnection();
		setupWindowProperties();
		add(contentPanel);
	}

	// 初始化UI组件
	private void initializeUI() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		loginButton = new JButton("登录");
		titleLabel = new JLabel("员工信息管理系统");
		usernameLabel = new JLabel("用户名:");
		passwordLabel = new JLabel("密码:");
		usernameInput = new JTextField(15);
		passwordInput = new JPasswordField(15);

		setupComponentProperties();
		addComponentsToContentPanel();
	}

	// 设置组件属性，如字体和颜色
	private void setupComponentProperties() {
		// 设置标题标签的字体和颜色
		titleLabel.setFont(new Font("宋体", Font.BOLD, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(140, 30, 300, 54);

		// 设置用户名和密码标签的字体和颜色
		usernameLabel.setForeground(Color.CYAN);
		usernameLabel.setFont(new Font("华文行楷", Font.BOLD, 16));
		usernameLabel.setBounds(129, 90, 62, 25);

		passwordLabel.setForeground(Color.CYAN);
		passwordLabel.setFont(new Font("华文行楷", Font.BOLD, 16));
		passwordLabel.setBounds(129, 123, 62, 25);

		// 设置用户名输入框的字体
		usernameInput.setFont(new Font("宋体", Font.PLAIN, 16));
		usernameInput.setBounds(191, 92, 180, 23);

		// 设置密码输入框的字体
		passwordInput.setFont(new Font("宋体", Font.BOLD, 16));
		passwordInput.setBounds(191, 125, 180, 23);

		// 设置登录按钮的字体和背景颜色
		loginButton.setBackground(new Color(8, 189, 252));
		loginButton.setBounds(129, 170, 242, 33);
		loginButton.setFont(new Font("宋体", Font.BOLD, 16));
	}

	// 将组件添加到内容面板
	private void addComponentsToContentPanel() {
		contentPanel.add(titleLabel);
		contentPanel.add(usernameLabel);
		contentPanel.add(usernameInput);
		contentPanel.add(passwordLabel);
		contentPanel.add(passwordInput);
		contentPanel.add(loginButton);
	}

	// 设置窗口属性，如位置和大小
	private void setupWindowProperties() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null); // 窗口居中显示
		setResizable(false); // 禁止改变窗口大小
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 设置窗口关闭操作
		setVisible(true); // 显示窗口
	}

	// 设置数据库连接和事件监听器
	private void setupDatabaseConnection() {
		ManageDatabaseReading mysql = new ManageDatabaseReading(); // 创建数据库管理对象
		LoginEventListener loginListener = new LoginEventListener(); // 创建登录事件监听器
		loginButton.addActionListener(loginListener); // 为登录按钮添加事件监听器
		// 注册功能未实现，所以以下代码被注释掉
		// RegistrationEventListener registrationListener = new RegistrationEventListener();
		// reg.addMouseListener(registrationListener);
	}

	// 获取用户名输入框的文本
	public static String getUsernameText() {
		return usernameInput.getText();
	}

	// 获取密码输入框的文本
	public static String getPasswordText() {
		return new String(passwordInput.getPassword());
	}
}

// 登录事件监听器内部类
class LoginEventListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginEvent().actionPerformed(e);
	}
}

// 注册事件监听器内部类（未实现）
class RegistrationEventListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		// 注册事件处理逻辑
	}

	// 其他MouseListener方法的默认实现（如果需要）
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}