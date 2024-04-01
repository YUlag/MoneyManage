package com.leadersys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login extends JFrame {
	private static final int WINDOW_WIDTH = 500; // �����ܵĿ��
	private static final int WINDOW_HEIGHT = 320; // �����ܵĸ߶�
	private JPanel contentPanel; // �������
	private JButton loginButton; // ��¼��ť
	private JLabel titleLabel; // �����ǩ
	private JLabel usernameLabel; // �û�����ǩ
	private JLabel passwordLabel; // �����ǩ
	private static JTextField usernameInput; // �û��������
	private static JPasswordField passwordInput; // ���������

	public Login() {
		initializeUI();
		setupDatabaseConnection();
		setupWindowProperties();
		add(contentPanel);
	}

	// ��ʼ��UI���
	private void initializeUI() {
		contentPanel = new JPanel();
		contentPanel.setLayout(null);
		loginButton = new JButton("��¼");
		titleLabel = new JLabel("Ա����Ϣ����ϵͳ");
		usernameLabel = new JLabel("�û���:");
		passwordLabel = new JLabel("����:");
		usernameInput = new JTextField(15);
		passwordInput = new JPasswordField(15);

		setupComponentProperties();
		addComponentsToContentPanel();
	}

	// ����������ԣ����������ɫ
	private void setupComponentProperties() {
		// ���ñ����ǩ���������ɫ
		titleLabel.setFont(new Font("����", Font.BOLD, 26));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(140, 30, 300, 54);

		// �����û����������ǩ���������ɫ
		usernameLabel.setForeground(Color.CYAN);
		usernameLabel.setFont(new Font("�����п�", Font.BOLD, 16));
		usernameLabel.setBounds(129, 90, 62, 25);

		passwordLabel.setForeground(Color.CYAN);
		passwordLabel.setFont(new Font("�����п�", Font.BOLD, 16));
		passwordLabel.setBounds(129, 123, 62, 25);

		// �����û�������������
		usernameInput.setFont(new Font("����", Font.PLAIN, 16));
		usernameInput.setBounds(191, 92, 180, 23);

		// ������������������
		passwordInput.setFont(new Font("����", Font.BOLD, 16));
		passwordInput.setBounds(191, 125, 180, 23);

		// ���õ�¼��ť������ͱ�����ɫ
		loginButton.setBackground(new Color(8, 189, 252));
		loginButton.setBounds(129, 170, 242, 33);
		loginButton.setFont(new Font("����", Font.BOLD, 16));
	}

	// �������ӵ��������
	private void addComponentsToContentPanel() {
		contentPanel.add(titleLabel);
		contentPanel.add(usernameLabel);
		contentPanel.add(usernameInput);
		contentPanel.add(passwordLabel);
		contentPanel.add(passwordInput);
		contentPanel.add(loginButton);
	}

	// ���ô������ԣ���λ�úʹ�С
	private void setupWindowProperties() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null); // ���ھ�����ʾ
		setResizable(false); // ��ֹ�ı䴰�ڴ�С
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ���ô��ڹرղ���
		setVisible(true); // ��ʾ����
	}

	// �������ݿ����Ӻ��¼�������
	private void setupDatabaseConnection() {
		ManageDatabaseReading mysql = new ManageDatabaseReading(); // �������ݿ�������
		LoginEventListener loginListener = new LoginEventListener(); // ������¼�¼�������
		loginButton.addActionListener(loginListener); // Ϊ��¼��ť����¼�������
		// ע�Ṧ��δʵ�֣��������´��뱻ע�͵�
		// RegistrationEventListener registrationListener = new RegistrationEventListener();
		// reg.addMouseListener(registrationListener);
	}

	// ��ȡ�û����������ı�
	public static String getUsernameText() {
		return usernameInput.getText();
	}

	// ��ȡ�����������ı�
	public static String getPasswordText() {
		return new String(passwordInput.getPassword());
	}
}

// ��¼�¼��������ڲ���
class LoginEventListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginEvent().actionPerformed(e);
	}
}

// ע���¼��������ڲ��ࣨδʵ�֣�
class RegistrationEventListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		// ע���¼������߼�
	}

	// ����MouseListener������Ĭ��ʵ�֣������Ҫ��
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}