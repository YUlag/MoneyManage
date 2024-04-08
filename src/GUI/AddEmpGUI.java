package GUI;

import utils.CalendarPanel;
import Event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class AddEmpGUI extends JFrame {
    private JButton cancelButton;
    private JButton addButton;
    private static JPanel panel; // 用于放置的面板
    private JLabel usernameLabel; // 账号标签
    private JLabel passwordLabel; // 密码标签
    private JLabel numberLabel; // 工号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel genderLabel; // 性别标签
    private JLabel positionLabel; // 部门标签
    private JLabel timeLabel; // 入职年份标签
    private JLabel departmentLabel; // 部门框标签
    private JLabel financialAuthorityLabel; // 权限标签
    private JLabel birthLabel; // 生日标签

    private static JTextField usernameText; // 账号框
    private static JTextField passwordText; // 密码框

    private static JTextField numberText; // 工号框
    private static JTextField nameText; // 姓名框
    private static JTextField timeText; // 入职年份
    private static JTextField birthText; // 生日
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 时期格式
    private static JRadioButton gender1 = new JRadioButton("男");
    private static JRadioButton gender2 = new JRadioButton("女");
    private static JRadioButton fin1 = new JRadioButton("是");
    private static JRadioButton fin2 = new JRadioButton("否");
    private static ButtonGroup genderGroup = new ButtonGroup(); // 性别选项组
    private static ButtonGroup finGroup = new ButtonGroup(); // 权限组
    private static JComboBox<String> positionBox; // 岗位多选框
    private static JComboBox<String> departmentBox; // 部门多选框
    String[] positions = SQL.Select.getAllPositionName(); // 所有岗位
    String[] departments = SQL.Select.getAllDepartmentName(); // 所有部门

    public AddEmpGUI() {
        createComponents();
        setLayout();
        addComponents();
        addInput();
        addEvents();
    }

    private void createComponents() {
        // 创建按钮
        addButton = new JButton("添加");
        cancelButton = new JButton("取消");

        // 增删改文本框
        usernameLabel = new JLabel(("账号:"));
        passwordLabel = new JLabel("密码:");
        numberLabel = new JLabel("工号:");
        nameLabel = new JLabel("姓名:");
        genderLabel = new JLabel("性别:");
        positionLabel = new JLabel("岗位");
        departmentLabel = new JLabel("部门:");
        financialAuthorityLabel = new JLabel("财务权限");
        timeLabel = new JLabel("入职年份:");
        birthLabel = new JLabel("出生日期");

        usernameText = new JTextField(15);
        passwordText = new JTextField(15);
        numberText = new JTextField(15);
        nameText = new JTextField(15);

        positionBox = new JComboBox<>(positions);
        departmentBox = new JComboBox<>(departments);

        timeText = new JTextField(15);
        birthText = new JTextField(15);
        panel = new JPanel();
    }

    private void setLayout() {
        // 使用 BorderLayout
        setLayout(new BorderLayout());

        panel.setLayout(null);
        numberLabel.setBounds(50, 25, 100, 25);
        numberText.setBounds(125, 25, 200, 25);

        usernameLabel.setBounds(50, 90, 100, 25);
        usernameText.setBounds(125, 90, 200, 25);

        nameLabel.setBounds(50, 150, 100, 25);
        nameText.setBounds(125, 150, 200, 25);

        departmentLabel.setBounds(50, 210, 100, 25);
        departmentBox.setBounds(125, 210, 200, 25);

        timeLabel.setBounds(50, 270, 100, 25);
        timeText.setBounds(125, 270, 200, 25);

        passwordLabel.setBounds(350, 90, 100, 25);
        passwordText.setBounds(425, 90, 200, 25);

        genderLabel.setBounds(350, 150, 100, 25);
//        genderText.setBounds(425, 150, 200, 25);
        gender1.setBounds(425, 150, 50, 25);
        gender2.setBounds(520, 150, 50, 25);

        positionLabel.setBounds(350, 210, 100, 25);
        positionBox.setBounds(425, 210, 200, 25);

        birthLabel.setBounds(350, 270, 100, 25);
        birthText.setBounds(425, 270, 200, 25);

        financialAuthorityLabel.setBounds(350, 25, 100, 25);
//        financialAuthorityText.setBounds(725, 90, 200, 25);
        fin1.setBounds(425, 25, 50, 25);
        fin2.setBounds(520, 25, 50, 25);

//        selectButton.setBounds(350, 25, 100, 25);
        addButton.setBounds(160, 350, 100, 25);
        cancelButton.setBounds(475, 350, 100, 25);

        CalendarPanel p1 = new CalendarPanel(birthText, "yyyy-MM-dd");
        CalendarPanel p2 = new CalendarPanel(timeText, "yyyy-MM-dd");

        p1.initCalendarPanel();
        p2.initCalendarPanel();

        add(p1);
        add(p2);
        add(panel, BorderLayout.CENTER);
    }

    private void addComponents() {
        // 添加按钮到按钮面板
        panel.add(cancelButton);
        panel.add(addButton);
    }

    private void addInput() {
        panel.add(usernameLabel);
        panel.add(usernameText);

        panel.add(passwordLabel);
        panel.add(passwordText);

        panel.add(numberLabel);
        panel.add(numberText);

        panel.add(nameLabel);
        panel.add(nameText);

        panel.add(genderLabel);
        genderGroup.add(gender1);
        genderGroup.add(gender2);
        panel.add(gender1);
        panel.add(gender2);

        panel.add(positionLabel);
        panel.add(positionBox);

        panel.add(departmentLabel);
        panel.add(departmentBox);

        panel.add(financialAuthorityLabel);
        finGroup.add(fin1);
        finGroup.add(fin2);
        panel.add(fin1);
        panel.add(fin2);

        panel.add(timeLabel);
        panel.add(timeText);

        panel.add(birthLabel);
        panel.add(birthText);
    }

    private void addEvents() {
        addButton.addActionListener(new AddEmpEventListener());

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static String getNumberText() {
        return numberText.getText();
    }

    public static String getUserNameText() {
        return usernameText.getText();
    }

    public static String getPasswordText() {
        return passwordText.getText();
    }

    public static String getNameText() {
        return nameText.getText();
    }

    public static String getGenderText() {
        Enumeration<AbstractButton> buttons = genderGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public static String getPositionText() {
        return (String) positionBox.getSelectedItem();
    }

    public static String getDepartmentText() {
        return (String) departmentBox.getSelectedItem();
    }

    public static String getFinancialAuthorityText() {
        Enumeration<AbstractButton> buttons = finGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                if ("是".equals(button.getText()))
                    return "1";
                else return "0";
            }
        }
        return null;
    }

    public static String getTimeText() {
        return timeText.getText();
    }

    public static String getBirthText() {
        return birthText.getText();
    }

}

class AddEmpEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new AddEmpEvent().actionPerformed(e);
    }
}

