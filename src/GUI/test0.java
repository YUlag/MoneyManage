package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test0 extends JFrame {
    private static final int ROW_COUNT = 5; // 表格行数
    private static final int COL_COUNT = 3; // 表格列数

    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField textFieldName;
    private JTextField textFieldGender;
    private JTextField textFieldDepartment;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton selectButton;
    private JButton switchButton;
    private JPanel buttonPanel; // 用于放置按钮的面板
    private static JPanel inputPanel; // 用于放置文本的面板
    private JPanel gapPanel; // 用于创建间隔的面板
    private static JScrollPane scrollPane;
    private JLabel numberLabel; // 工号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel genderLabel; // 性别标签
    private JLabel deptLabel; // 部门标签
    private JLabel timeLabel; // 入职年份标签

    private static JTextField numberText; // 工号框
    private static JTextField nameText; // 姓名框
    private static JTextField genderText; // 性别框
    private static JTextField deptText; // 部门框
    private static JTextField timeText; // 入职年份

    private boolean flag = true;

    public test0() {
        createComponents();
        setLayout();
        addComponents();
        addInput();
        addEvents();
    }

    private void createComponents() {
        // 创建表格模型并初始化数据
        Object[] columnNames = {"编号", "性别", "部门"};
        tableModel = new DefaultTableModel(columnNames, ROW_COUNT);
        table = new JTable(tableModel);

        // 创建文本框
        textFieldName = new JTextField(10);
        textFieldGender = new JTextField(5);
        textFieldDepartment = new JTextField(15);

        // 创建按钮
        addButton = new JButton("添加");
        deleteButton = new JButton("删除");
        updateButton = new JButton("更新");
        selectButton = new JButton("查询");
        switchButton = new JButton("切换");
        buttonPanel = new JPanel(); // 创建一个面板用于放置按钮

        // 增删改文本框
        numberLabel = new JLabel("工号:");
        nameLabel = new JLabel("姓名:");
        genderLabel = new JLabel("性别:");
        deptLabel = new JLabel("部门:");
        timeLabel = new JLabel("入职年份:");

        numberText = new JTextField(15);
        nameText  = new JTextField(15);
        genderText = new JTextField(15);
        deptText = new JTextField(15);
        timeText  = new JTextField(15);
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

        // 设置按钮面板的布局为 BoxLayout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); // 设置间距
        add(buttonPanel, BorderLayout.WEST);


        inputPanel.setLayout(null);
        numberLabel.setBounds(50, 10, 100, 25);
        nameLabel.setBounds(50, 70, 100, 25);
        genderLabel.setBounds(50, 130, 100, 25);
        deptLabel.setBounds(50, 190, 100, 25);
        timeLabel.setBounds(50, 250, 100, 25);

        numberText.setBounds(125, 10, 200, 25);
        nameText.setBounds(125, 70, 200, 25);
        genderText.setBounds(125, 130, 200, 25);
        deptText.setBounds(125, 190, 200, 25);
        timeText.setBounds(125, 250, 200, 25);

        add(scrollPane);
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

    private void addInput(){
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

    private void addEvents() {
        // 为按钮添加事件监听器
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 添加数据到表格
                String name = textFieldName.getText();
                String gender = textFieldGender.getText();
                String department = textFieldDepartment.getText();
                tableModel.addRow(new Object[]{name, gender, department});
            }
        });

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag){
                   remove(scrollPane);
                   add(inputPanel,BorderLayout.CENTER);
                    revalidate();
                    repaint();
                    flag = false;
                }else {
                    remove(inputPanel);
                    add(scrollPane);
                    revalidate();
                    repaint();
                    flag = true;
                }
            }
        });
        // 其他按钮的事件监听器可以按照类似的方式添加
        // 例如删除、更新和查询功能的实现
        // 这里省略了具体的事件处理代码，需要根据实际需求来编写
    }

    public static void main(String[] args) {
        // 创建窗口实例并显示
        test0 crudInterface = new test0();
        crudInterface.setTitle("管理员增删改查界面");
        crudInterface.setSize(1000, 500); // 调整窗口大小以适应组件
        crudInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crudInterface.setLocationRelativeTo(null);

        crudInterface.setVisible(true);
    }
}