package accountingGUI;

import eventListener.DeleteSalaryEventListener;
import eventListener.SelectSalaryByIDEventListener;
import eventListener.UpdateSalaryEventListener;

import javax.swing.*;
import java.awt.*;

public class UpdateAndDeleteSalaryGUI extends JFrame {
    private static JPanel panel; // 用于放置的面板
    private static JTextField salaryIDText; // 工资号框
    private static JLabel nameText; // 姓名
    private static JTextField baseSalaryText; // 基础工资框
    private static JTextField benefitsText; // 绩效工资框
    private static JTextField bonusText; // 奖金框
    private static JTextField unemploymentInsuranceText; // 失业保险
    private static JTextField housingFundText; // 住房公积金
    private static JTextField incomeTaxText; //个人所得税
    private static JTextField otherDeductionsText; //其他扣除
    private static JTextField yearText; // 年份
    private static JTextField monthText; // 月份
    private JLabel salaryIDLabel; // 工资号标签
    private JLabel nameLabel; // 姓名标签
    private JLabel baseSalaryLabel; // 基本工资标签
    private JLabel benefitsLabel; // 绩效工资标签
    private JLabel bonusLabel; // 奖金标签
    private JLabel unemploymentInsuranceLabel; // 失业保险标签
    private JLabel housingFundLabel; // 住房公积金标签
    private JLabel incomeTaxLabel; // 个人所得税标签
    private JLabel otherDeductionsLabel; // 其他扣除项标签
    private JLabel yearLabel; // 年份标签
    private JLabel monthLabel; // 月份标签

    private JButton selectButton;
    private JButton deleteButton;
    private JButton updateButton;

    public UpdateAndDeleteSalaryGUI() {
        createComponents();
        setLayout();
        addComponents();
        addInput();
        addEvents();
    }

    public static String getSalaryIDText() {
        return salaryIDText.getText();
    }

    public static String getBaseSalaryText() {
        return baseSalaryText.getText();
    }

    public static void setBaseSalaryText(String baseSalary) {
        baseSalaryText.setText(baseSalary);
    }

    public static String getBenefitsText() {
        return benefitsText.getText();
    }

    public static void setBenefitsText(String benefits) {
        benefitsText.setText(benefits);
    }

    public static String getBonusText() {
        return bonusText.getText();
    }

    public static void setBonusText(String bonus) {
        bonusText.setText(bonus);
    }

    public static String getUnemploymentInsuranceText() {
        return unemploymentInsuranceText.getText();
    }

    public static void setUnemploymentInsuranceText(String unemploymentInsurance) {
        unemploymentInsuranceText.setText(unemploymentInsurance);
    }

    public static String getHousingFundText() {
        return housingFundText.getText();
    }

    public static void setHousingFundText(String housingFund) {
        housingFundText.setText(housingFund);
    }

    public static String getIncomeTaxText() {
        return incomeTaxText.getText();
    }

    public static void setIncomeTaxText(String incomeTax) {
        incomeTaxText.setText(incomeTax);
    }

    public static String getOtherDeductionsText() {
        return otherDeductionsText.getText();
    }

    public static void setOtherDeductionsText(String otherDeductions) {
        otherDeductionsText.setText(otherDeductions);
    }

    public static String getYearText() {
        return yearText.getText();
    }

    public static void setYearText(String year) {
        yearText.setText(year);
    }

    public static String getMonthText() {
        return monthText.getText();
    }

    public static void setMonthText(String month) {
        monthText.setText(month);
    }

    public static void setNameText(String name) {
        nameText.setText(name);
    }

    private void createComponents() {
        // 创建按钮
        selectButton = new JButton("查找");
        updateButton = new JButton("修改");
        deleteButton = new JButton("删除");

        // 增删改文本框
        salaryIDLabel = new JLabel(("工资号:"));
        nameLabel = new JLabel(("姓名:"));
        nameText = new JLabel();
        salaryIDText = new JTextField(15);
        baseSalaryLabel = new JLabel(("基本工资:"));
        baseSalaryText = new JTextField(15);
        benefitsLabel = new JLabel(("绩效工资:"));
        benefitsText = new JTextField(15);
        bonusLabel = new JLabel(("奖金:"));
        bonusText = new JTextField(15);
        unemploymentInsuranceLabel = new JLabel(("失业保险:"));
        unemploymentInsuranceText = new JTextField(15);
        housingFundLabel = new JLabel(("住房公积金:"));
        housingFundText = new JTextField(15);
        incomeTaxLabel = new JLabel(("个人所得税:"));
        incomeTaxText = new JTextField(15);
        otherDeductionsLabel = new JLabel(("其他扣除:"));
        otherDeductionsText = new JTextField(15);
        yearLabel = new JLabel(("年份:"));
        yearText = new JTextField(15);
        monthLabel = new JLabel(("月份:"));
        monthText = new JTextField(15);

        panel = new JPanel();
    }

    private void setLayout() {
        // 使用 BorderLayout
        setLayout(new BorderLayout());

        panel.setLayout(null);
        salaryIDLabel.setBounds(50, 25, 100, 25);
        salaryIDText.setBounds(125, 25, 200, 25);

        nameLabel.setBounds(350, 25, 100, 25);
        nameText.setBounds(425, 25, 200, 25);
        nameText.setOpaque(true);
        nameText.setBackground(Color.white);
        nameText.setBorder(BorderFactory.createLineBorder(new Color(122, 138, 153)));

        baseSalaryLabel.setBounds(50, 100, 100, 30);
        baseSalaryText.setBounds(125, 100, 200, 30);

        unemploymentInsuranceLabel.setBounds(50, 200, 100, 30);
        unemploymentInsuranceText.setBounds(125, 190, 200, 30);

        otherDeductionsLabel.setBounds(50, 300, 100, 30);
        otherDeductionsText.setBounds(125, 300, 200, 30);

//        timeLabel.setBounds(50, 270, 100, 30);
//        timeText.setBounds(125, 270, 200, 30);

        benefitsLabel.setBounds(350, 100, 100, 30);
        benefitsText.setBounds(425, 100, 200, 30);

        housingFundLabel.setBounds(350, 200, 100, 30);
        housingFundText.setBounds(425, 200, 200, 30);

        yearLabel.setBounds(350, 300, 100, 30);
        yearText.setBounds(425, 300, 200, 30);

//        birthLabel.setBounds(350, 270, 100, 30);
//        birthText.setBounds(425, 270, 200, 30);

        bonusLabel.setBounds(650, 100, 100, 30);
        bonusText.setBounds(725, 100, 200, 30);

        incomeTaxLabel.setBounds(650, 200, 100, 30);
        incomeTaxText.setBounds(725, 200, 200, 30);

        monthLabel.setBounds(650, 300, 100, 30);
        monthText.setBounds(725, 300, 200, 30);


        selectButton.setBounds(650, 25, 100, 30);
        updateButton.setBounds(283, 450, 100, 30);
        deleteButton.setBounds(616, 450, 100, 30);

        add(panel, BorderLayout.CENTER);
    }

    private void addComponents() {
        // 添加按钮到按钮面板
        panel.add(selectButton);
        panel.add(deleteButton);
        panel.add(updateButton);
    }

    private void addInput() {
        panel.add(salaryIDLabel);
        panel.add(salaryIDText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(baseSalaryLabel);
        panel.add(baseSalaryText);
        panel.add(benefitsLabel);
        panel.add(benefitsText);
        panel.add(bonusLabel);
        panel.add(bonusText);
        panel.add(unemploymentInsuranceLabel);
        panel.add(unemploymentInsuranceText);
        panel.add(housingFundLabel);
        panel.add(housingFundText);
        panel.add(incomeTaxLabel);
        panel.add(incomeTaxText);
        panel.add(otherDeductionsLabel);
        panel.add(otherDeductionsText);
        panel.add(yearLabel);
        panel.add(yearText);
        panel.add(monthLabel);
        panel.add(monthText);
    }

    private void addEvents() {
        selectButton.addActionListener(new SelectSalaryByIDEventListener());

        updateButton.addActionListener(new UpdateSalaryEventListener());

        deleteButton.addActionListener(new DeleteSalaryEventListener());
    }

}

