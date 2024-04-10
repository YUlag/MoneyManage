package accountingGUI;

import SQL.Select;
import atom.Salary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class accountingGUI extends JFrame {
    private static final int colCount = 14; // 表格列数
    private static final String[] columnNames = new String[]{"工资号", "工号", "年份", "月份", "基本工资", "绩效工资", "奖金", "失业保险", "住房公积金", "个人所得税", "其他扣除", "总工资", "总扣除", "净工资"}; // 表格头部
    private static JPanel inputPanel; // 用于放置文本的面板
    private static JScrollPane scrollPane;
    private static JTextField salaryIDText; // 工资号框
    private static JTextField empIDText; // 工号框
    private static JTextField nameText; // 姓名框
    private static JTextField yearText; // 年份框
    private static JTextField monthText; // 月份框
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton updateAndDeleteButton;
    private JButton selectButton;
    private JButton refreshButton;
    private JPanel buttonPanel; // 用于放置按钮的面板
    private JLabel salaryIDLabel; // 工资号标签
    private JLabel empIDLabel; // 工号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel yearLabel; // 年份标签
    private JLabel monthLabel; // 月份标签

    public accountingGUI() {
        createComponents();
        setLayout();

        addComponents();
        addInput();
        addEvents();
    }

    public static String getEmpIDText() {
        return empIDText.getText();
    }

    public static String getSalaryIDText() {
        return salaryIDText.getText();
    }

    public static String getNameText() {
        return nameText.getText();
    }

    public static String getYearText() {
        return yearText.getText();
    }

    public static String getMonthText() {
        return monthText.getText();
    }

    private void createComponents() {
        // 创建表格模型并初始化数据
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        List<Salary> salaries = Select.selectAllSalary();
        getSalaryInSalaries(salaries);

        // 创建按钮
        addButton = new JButton("  添 加  ");
        updateAndDeleteButton = new JButton("更新&删除");
        selectButton = new JButton("  查 询  ");
        refreshButton = new JButton("  刷 新  ");
        buttonPanel = new JPanel(); // 创建一个面板用于放置按钮

        salaryIDLabel = new JLabel("工资号:");
        empIDLabel = new JLabel("工号:");
        nameLabel = new JLabel("姓名:");
        yearLabel = new JLabel("年份:");
        monthLabel = new JLabel("月份:");

        salaryIDText = new JTextField(15);
        empIDText = new JTextField(15);
        nameText = new JTextField(15);
        yearText = new JTextField(15);
        monthText = new JTextField(15);
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
        salaryIDLabel.setBounds(130, 10, 100, 25);
        empIDLabel.setBounds(420, 10, 100, 25);
        nameLabel.setBounds(710, 10, 100, 25);
        yearLabel.setBounds(130, 50, 100, 25);
        monthLabel.setBounds(420, 50, 100, 25);

//        usernameText.setBounds(125, 10, 200, 25);
//        usernameText.addFocusListener(new JTextFieldHintListener(usernameText, "账号默认与工号相同"));
//        passwordText.setBounds(125, 70, 200, 25);
//        passwordText.addFocusListener(new JTextFieldHintListener(passwordText, "密码默认123456"));
//        numberText.addFocusListener(new JTextFieldHintListener(numberText, "不输入按最后一位工号递增"));
        salaryIDText.setBounds(200, 10, 200, 25);
        empIDText.setBounds(490, 10, 200, 25);
        nameText.setBounds(780, 10, 200, 25);
        yearText.setBounds(200, 50, 200, 25);
        monthText.setBounds(490, 50, 200, 25);
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
        inputPanel.add(empIDLabel);
        inputPanel.add(empIDText);

        inputPanel.add(salaryIDLabel);
        inputPanel.add(salaryIDText);

        inputPanel.add(nameLabel);
        inputPanel.add(nameText);

        inputPanel.add(yearLabel);
        inputPanel.add(yearText);

        inputPanel.add(monthLabel);
        inputPanel.add(monthText);
    }

    private void addEvents() {
        // 为按钮添加事件监听器
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                AddEmpGUI AddEmpGUI = new AddEmpGUI();
//                AddEmpGUI.setTitle("新增员工界面");
//                AddEmpGUI.setSize(1000, 700); // 调整窗口大小以适应组件
//                AddEmpGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                AddEmpGUI.setLocationRelativeTo(null);
//
//                AddEmpGUI.setVisible(true);
//            }
//        });
        updateAndDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateAndDeleteSalaryGUI updateAndDeleteSalaryGUI = new UpdateAndDeleteSalaryGUI();
                updateAndDeleteSalaryGUI.setTitle("员工工资更新界面");
                updateAndDeleteSalaryGUI.setSize(1000, 700); // 调整窗口大小以适应组件
                updateAndDeleteSalaryGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateAndDeleteSalaryGUI.setLocationRelativeTo(null);

                updateAndDeleteSalaryGUI.setVisible(true);
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Salary> salaries = Select.selectAllSalary();
                getSalaryInSalaries(salaries);
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String salaryID = salaryIDText.getText();
                String empID = empIDText.getText();
                String name = nameText.getText();
                String year = yearText.getText();
                String month = monthText.getText();


                List<Salary> salaries = Select.selectSalary(salaryID, empID, name, year, month);

                getSalaryInSalaries(salaries);
            }
        });
    }

    public void getSalaryInSalaries(List<Salary> salaries) {
        clearTable();

        for (Salary salary : salaries) {
            Object[] rowData = new Object[]{
                    salary.getSalaryID(),
                    salary.getEmpID(),
                    salary.getYear(),
                    salary.getMonth(),
                    salary.getBaseSalary(),
                    salary.getBenefits(),
                    salary.getBonus(),
                    salary.getUnemploymentInsurance(),
                    salary.getHousingFund(),
                    salary.getIncomeTax(),
                    salary.getOtherDeductions(),
                    salary.getTotalEarnings(),
                    salary.getTotalDeductions(),
                    salary.getNetSalary()
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
