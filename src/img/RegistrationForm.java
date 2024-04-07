package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {

    private JTextField accountField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JComboBox<String> genderBox;
    private JComboBox<String> departmentBox;
    private JComboBox<String> positionBox;
    private JTextField entryDateField;
    private JButton createButton;
    private JButton cancelButton;

    public RegistrationForm() {
        super("注册/登录界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new FlowLayout());

        // 创建并添加组件  
        accountField = new JTextField(15);
        passwordField = new JPasswordField(15);
        nameField = new JTextField(15);
        String[] genders = {"男", "女"};
        genderBox = new JComboBox<>(genders);
        String[] departments = {"部门1", "部门2", "部门3"};
        departmentBox = new JComboBox<>(departments);
        String[] positions = {"岗位1", "岗位2", "岗位3"};
        positionBox = new JComboBox<>(positions);
        entryDateField = new JTextField(10);

        createButton = new JButton("创建");
        cancelButton = new JButton("取消");

        // 添加组件到界面  
        add(new JLabel("账号:"));
        add(accountField);
        add(new JLabel("密码:"));
        add(passwordField);
        add(new JLabel("姓名:"));
        add(nameField);
        add(new JLabel("性别:"));
        add(genderBox);
        add(new JLabel("部门:"));
        add(departmentBox);
        add(new JLabel("岗位:"));
        add(positionBox);
        add(new JLabel("入职时间:"));
        add(entryDateField);
        add(createButton);
        add(cancelButton);

        // 添加按钮事件监听器  
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理创建按钮点击事件  
                System.out.println("创建按钮被点击");
                // 这里可以添加表单验证和提交逻辑  
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 处理取消按钮点击事件  
                System.out.println("取消按钮被点击");
                dispose(); // 关闭窗口  
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationForm();
            }
        });
    }
}