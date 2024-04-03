package GUI;

import Event.UpdateEmpEvent;
import SQL.Select;
import atom.Emp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

public class ManageGUI extends JFrame {
    private static int colCount; // 表格列数
    private static String[] columnNames; // 表格头部

    private DefaultTableModel tableModel;
    private JTable table;
//    private JTextField textFieldName;
//    private JTextField textFieldGender;
//    private JTextField textFieldDepartment;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton selectButton;
    private JButton switchButton;
    private JPanel buttonPanel; // 用于放置按钮的面板
    private static JPanel inputPanel; // 用于放置文本的面板
    private JPanel gapPanel; // 用于创建间隔的面板
    private static JScrollPane scrollPane;
    private JLabel usernameLabel; // 账号标签
    private JLabel passwordLabel; // 密码标签
    private JLabel numberLabel; // 工号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel genderLabel; // 性别标签
    private JLabel deptLabel; // 部门标签
    private JLabel timeLabel; // 入职年份标签
    private static JTextField usernameText; // 账号框
    private static JTextField passwordText; // 密码框

    private static JTextField numberText; // 工号框
    private static JTextField nameText; // 姓名框
    private static JTextField genderText; // 性别框
    private static JTextField deptText; // 部门框
    private static JTextField timeText; // 入职年份

    private boolean flag = true;

    public ManageGUI() {
        createComponents();
        setLayout();

        addComponents();
        addInput();
        addEvents();
    }

    private void createComponents() {
        List<Emp> allEmp = getAllEmp();
        // 创建表格模型并初始化数据
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        for (Emp emp : allEmp) {
            Object[] rowData = new Object[] {
                    emp.getEmployeeID(),
                    emp.getName(),
                    emp.getGender(),
                    emp.getPosition(),
                    emp.getHireYear(),
                    emp.getFinancialAuthority()
            };
            // 将一行数据添加到表格模型中
            tableModel.addRow(rowData);
        }

        // 创建文本框
//        textFieldName = new JTextField(10);
//        textFieldGender = new JTextField(5);
//        textFieldDepartment = new JTextField(15);

        // 创建按钮
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        updateButton = new JButton("更新");
        selectButton = new JButton("查询");
        switchButton = new JButton("切换");
        buttonPanel = new JPanel(); // 创建一个面板用于放置按钮

        // 增删改文本框
        usernameLabel = new JLabel(("账号:"));
        passwordLabel = new JLabel("密码:");
        numberLabel = new JLabel("工号:");
        nameLabel = new JLabel("姓名:");
        genderLabel = new JLabel("性别:");
        deptLabel = new JLabel("部门:");
        timeLabel = new JLabel("入职年份:");

        usernameText = new JTextField(15);
        passwordText = new JTextField(15);
        numberText = new JTextField(15);
        nameText = new JTextField(15);
        genderText = new JTextField(15);
        deptText = new JTextField(15);
        timeText = new JTextField(15);
        inputPanel = new JPanel();
    }

    private void setLayout() {
        // 使用 BorderLayout
        setLayout(new BorderLayout());

        // 添加间隔面板到顶部，创建头部间隔
        gapPanel = new JPanel();
        gapPanel.setPreferredSize(new Dimension(0, 30));
        add(gapPanel, BorderLayout.NORTH);

        // 使用 BorderLayout 来放置表格和按钮面板
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        add(scrollPane);

        // 设置按钮面板的布局为 BoxLayout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); // 设置间距
        add(buttonPanel, BorderLayout.WEST);


        inputPanel.setLayout(null);
        usernameLabel.setBounds(50, 10, 100, 25);
        passwordLabel.setBounds(50, 70, 100, 25);
        numberLabel.setBounds(350, 10, 100, 25);
        nameLabel.setBounds(350, 70, 100, 25);
        genderLabel.setBounds(350, 130, 100, 25);
        deptLabel.setBounds(350, 190, 100, 25);
        timeLabel.setBounds(350, 250, 100, 25);

        usernameText.setBounds(125, 10, 200, 25);
        usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "账号默认与工号相同"));
        passwordText.setBounds(125, 70, 200, 25);
        passwordText.addFocusListener(new JTextFieldHintListener(passwordText, "密码默认123456"));
        numberText.setBounds(425, 10, 200, 25);
        numberText.addFocusListener(new JTextFieldHintListener(numberText, "不输入按最后一位工号递增"));
        nameText.setBounds(425, 70, 200, 25);
        genderText.setBounds(425, 130, 200, 25);
        deptText.setBounds(425, 190, 200, 25);
        timeText.setBounds(425, 250, 200, 25);
        timeText.addFocusListener(new JTextFieldHintListener(timeText, "不输入默认当前年份"));
    }

    private void addComponents() {
        // 添加按钮到按钮面板
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(updateButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(selectButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(switchButton);
    }

    private void addInput() {
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameText);

        inputPanel.add(passwordLabel);
        inputPanel.add(passwordText);

        inputPanel.add(numberLabel);
        inputPanel.add(numberText);

        inputPanel.add(nameLabel);
        inputPanel.add(nameText);

        inputPanel.add(genderLabel);
        inputPanel.add(genderText);

        inputPanel.add(deptLabel);
        inputPanel.add(deptText);

        inputPanel.add(timeLabel);
        inputPanel.add(timeText);
    }

    public static String getNumberText() {
        return numberText.getText();
    }

    public static String getNameText() {
        return nameText.getText();
    }

    public static String getGenderText() {
        return genderText.getText();
    }

    public static String getDeptText() {
        return deptText.getText();
    }

    public static String getTimeText() {
        return timeText.getText();
    }


    private void addEvents() {
        // 为按钮添加事件监听器
//        switchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (flag) {
//                    remove(scrollPane);
//                    add(inputPanel, BorderLayout.CENTER);
//                    revalidate();
//                    repaint();
//                    flag = false;
//                } else {
//                    remove(inputPanel);
//                    add(scrollPane);
//                    revalidate();
//                    repaint();
//                    flag = true;
//                }
//            }
//        });
        // 更新监听
        UpdateEventListener updateEventListener  = new UpdateEventListener();
        updateButton.addActionListener(updateEventListener);
    }

    public List<Emp> getAllEmp() {
        List<Emp> emps = Select.selectAllEmp();
        int i = 0;
        // 获取Emp类的成员数量
        Class<?> clazz = null;
        try {
            clazz = Class.forName("atom.Emp");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Field[] fields = clazz.getDeclaredFields();

        // 实时设置表格大小
        colCount = fields.length;
        columnNames = new String[colCount];

        for (Field field : fields) {
            columnNames[i++] = field.getName();
        }
        return emps;
    }

    //测试用例
//    public static void main(String[] args) {
//        // 创建窗口实例并显示
//        test0 crudInterface = new test0();
//        crudInterface.setTitle("管理员增删改查界面");
//        crudInterface.setSize(1000, 500); // 调整窗口大小以适应组件
//        crudInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        crudInterface.setLocationRelativeTo(null);
//
//        crudInterface.setVisible(true);
//    }
}

class UpdateEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new UpdateEmpEvent().actionPerformed(e);
    }
}