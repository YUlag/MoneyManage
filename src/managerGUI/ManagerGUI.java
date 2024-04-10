package managerGUI;

import SQL.Select;
import atom.Emp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ManagerGUI extends JFrame {
    private static final int colCount = 10; // 表格列数
    private static final String[] columnNames = new String[]{"工号", "账号", "密码", "姓名", "性别", "年龄", "岗位", "部门", "入职时间", "财务权限"}; // 表格头部
    private static JPanel inputPanel; // 用于放置文本的面板
    private static JScrollPane scrollPane;
    private static JTextField numberText; // 工号框
    private static JTextField nameText; // 姓名框
    private static JComboBox<String> genderBox; // 性别多选框
    private static JComboBox<String> positionBox; // 岗位多选框
    private static JComboBox<String> departmentBox; // 部门多选框
    private static String[] positions; // 所有岗位
    private static String[] departments; // 所有部门
    private static final String[] genders = {"", "男", "女"};
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton updateAndDeleteButton;
    private JButton selectButton;
    private JButton refreshButton;
    private JPanel buttonPanel; // 用于放置按钮的面板
    private JPanel gapPanel; // 用于创建间隔的面板
    private JLabel numberLabel; // 工号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel genderLabel; // 性别标签
    private JLabel deptLabel; // 部门标签
    private JLabel positionLabel; // 岗位标签

    public ManagerGUI() {
        createComponents();
        setLayout();

        addComponents();
        addInput();
        addEvents();
    }

    public static String getNumberText() {
        return numberText.getText();
    }

    public static String getNameText() {
        return nameText.getText();
    }

    public static String getGenderText() {
        return (String) genderBox.getSelectedItem();
    }

    public static String getDeptText() {
        return (String) departmentBox.getSelectedItem();
    }

    public static String getPositionText() {
        return (String) positionBox.getSelectedItem();
    }

    private void createComponents() {
        // 创建表格模型并初始化数据
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        List<Emp> emps = Select.selectAllEmp();
        getEmpInEmps(emps);
        // 创建按钮
        addButton = new JButton("添加");
        updateAndDeleteButton = new JButton("更新&删除");
        selectButton = new JButton("查询");
        refreshButton = new JButton("刷新");
        buttonPanel = new JPanel(); // 创建一个面板用于放置按钮


        numberLabel = new JLabel("工号:");
        nameLabel = new JLabel("姓名:");
        genderLabel = new JLabel("性别:");
        deptLabel = new JLabel("部门:");
        positionLabel = new JLabel("岗位:");

        numberText = new JTextField(15);
        nameText = new JTextField(15);
        genderBox = new JComboBox<>(genders);

        ArrayList<String> list1 = new ArrayList<>(List.of(Select.getAllPositionName()));
        list1.add(0, "");
        positions = list1.toArray(new String[0]);

        ArrayList<String> list2 = new ArrayList<>(List.of(Select.getAllDepartmentName()));
        list2.add(0, "");
        departments = list2.toArray(new String[0]);

        departmentBox = new JComboBox<>(departments);
        positionBox = new JComboBox<>(positions);
    }

    private void setLayout() {
        // 使用 BorderLayout
        setLayout(new BorderLayout());

        // 搜索栏
        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(0, 100));
        add(inputPanel, BorderLayout.NORTH);

        // 使用 BorderLayout 来放置表格和按钮面板
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        add(scrollPane);

        // 设置按钮面板的布局为 BoxLayout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); // 设置间距
        add(buttonPanel, BorderLayout.WEST);


        inputPanel.setLayout(null);
        numberLabel.setBounds(130, 10, 100, 25);
        nameLabel.setBounds(420, 10, 100, 25);
        genderLabel.setBounds(710, 10, 100, 25);
        deptLabel.setBounds(130, 50, 100, 25);
        positionLabel.setBounds(420, 50, 100, 25);

//        usernameText.setBounds(125, 10, 200, 25);
//        usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "账号默认与工号相同"));
//        passwordText.setBounds(125, 70, 200, 25);
//        passwordText.addFocusListener(new JTextFieldHintListener(passwordText, "密码默认123456"));
//        numberText.addFocusListener(new JTextFieldHintListener(numberText, "不输入按最后一位工号递增"));
        numberText.setBounds(200, 10, 200, 25);
        nameText.setBounds(490, 10, 200, 25);
        genderBox.setBounds(780, 10, 200, 25);
        departmentBox.setBounds(200, 50, 200, 25);
        positionBox.setBounds(490, 50, 200, 25);
    }

    private void addComponents() {
        // 添加按钮到按钮面板
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(updateAndDeleteButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(selectButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // 添加按钮间隔
        buttonPanel.add(refreshButton);
    }

    private void addInput() {
        inputPanel.add(numberLabel);
        inputPanel.add(numberText);

        inputPanel.add(nameLabel);
        inputPanel.add(nameText);

        inputPanel.add(genderLabel);
        inputPanel.add(genderBox);

        inputPanel.add(deptLabel);
        inputPanel.add(departmentBox);

        inputPanel.add(positionLabel);
        inputPanel.add(positionBox);
    }

    private void addEvents() {
        // 为按钮添加事件监听器
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmpGUI AddEmpGUI = new AddEmpGUI();
                AddEmpGUI.setTitle("新增员工界面");
                AddEmpGUI.setSize(1000, 700); // 调整窗口大小以适应组件
                AddEmpGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                AddEmpGUI.setLocationRelativeTo(null);

                AddEmpGUI.setVisible(true);
            }
        });
        updateAndDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAndDeleteEmpGUI updateAndDeleteEmpGUI = new UpdateAndDeleteEmpGUI();
                updateAndDeleteEmpGUI.setTitle("员工更新界面");
                updateAndDeleteEmpGUI.setSize(1000, 700); // 调整窗口大小以适应组件
                updateAndDeleteEmpGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateAndDeleteEmpGUI.setLocationRelativeTo(null);

                updateAndDeleteEmpGUI.setVisible(true);
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Emp> emps = Select.selectAllEmp();
                getEmpInEmps(emps);
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = ManagerGUI.getNumberText();
                String name = ManagerGUI.getNameText();
                String gender = ManagerGUI.getGenderText();
                String department = ManagerGUI.getDeptText();
                String position = ManagerGUI.getPositionText();

                List<Emp> emps = Select.selectEmp(number, name, gender, department, position);

                getEmpInEmps(emps);
            }
        });
    }

    public void getEmpInEmps(List<Emp> emps) {
        clearTable();

        for (Emp emp : emps) {
            Object[] rowData = new Object[]{
                    emp.getEmpID(),
                    emp.getUsername(),
                    emp.getPassword(),
                    emp.getName(),
                    emp.getGender(),
                    emp.getAge(),
                    emp.getPosition(),
                    emp.getDepartment(),
                    simpleDateFormat.format(emp.getHireYear()),
                    emp.getFinancialAuthority()
            };
            // 将一行数据添加到表格模型中
            tableModel.addRow(rowData);
        }
        table.repaint();
    }

    public void clearTable() {
        // 清空表格模型中的所有行
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }
    }
}