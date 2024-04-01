package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test0 extends JFrame {
    private static final int ROW_COUNT = 5; // �������
    private static final int COL_COUNT = 3; // �������

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
    private JPanel buttonPanel; // ���ڷ��ð�ť�����
    private static JPanel inputPanel; // ���ڷ����ı������
    private JPanel gapPanel; // ���ڴ�����������
    private static JScrollPane scrollPane;
    private JLabel numberLabel; // ���ű�ǩ
    private JLabel nameLabel; // ������ǩ
    private JLabel genderLabel; // �Ա��ǩ
    private JLabel deptLabel; // ���ű�ǩ
    private JLabel timeLabel; // ��ְ��ݱ�ǩ

    private static JTextField numberText; // ���ſ�
    private static JTextField nameText; // ������
    private static JTextField genderText; // �Ա��
    private static JTextField deptText; // ���ſ�
    private static JTextField timeText; // ��ְ���

    private boolean flag = true;

    public test0() {
        createComponents();
        setLayout();
        addComponents();
        addInput();
        addEvents();
    }

    private void createComponents() {
        // �������ģ�Ͳ���ʼ������
        Object[] columnNames = {"���", "�Ա�", "����"};
        tableModel = new DefaultTableModel(columnNames, ROW_COUNT);
        table = new JTable(tableModel);

        // �����ı���
        textFieldName = new JTextField(10);
        textFieldGender = new JTextField(5);
        textFieldDepartment = new JTextField(15);

        // ������ť
        addButton = new JButton("���");
        deleteButton = new JButton("ɾ��");
        updateButton = new JButton("����");
        selectButton = new JButton("��ѯ");
        switchButton = new JButton("�л�");
        buttonPanel = new JPanel(); // ����һ��������ڷ��ð�ť

        // ��ɾ���ı���
        numberLabel = new JLabel("����:");
        nameLabel = new JLabel("����:");
        genderLabel = new JLabel("�Ա�:");
        deptLabel = new JLabel("����:");
        timeLabel = new JLabel("��ְ���:");

        numberText = new JTextField(15);
        nameText  = new JTextField(15);
        genderText = new JTextField(15);
        deptText = new JTextField(15);
        timeText  = new JTextField(15);
        inputPanel = new JPanel();
    }

    private void setLayout() {
        // ʹ�� BorderLayout
        setLayout(new BorderLayout());

        // ��Ӽ����嵽����������ͷ�����
        gapPanel = new JPanel();
        gapPanel.setPreferredSize(new Dimension(0, 30));
        add(gapPanel, BorderLayout.NORTH);

        // ʹ�� BorderLayout �����ñ��Ͱ�ť���
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        // ���ð�ť���Ĳ���Ϊ BoxLayout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20)); // ���ü��
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
        // ��Ӱ�ť����ť���
        buttonPanel.add(addButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // ��Ӱ�ť���
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // ��Ӱ�ť���
        buttonPanel.add(updateButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // ��Ӱ�ť���
        buttonPanel.add(selectButton);
        buttonPanel.add(Box.createVerticalStrut(30)); // ��Ӱ�ť���
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
        // Ϊ��ť����¼�������
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ������ݵ����
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
        // ������ť���¼����������԰������Ƶķ�ʽ���
        // ����ɾ�������ºͲ�ѯ���ܵ�ʵ��
        // ����ʡ���˾�����¼�������룬��Ҫ����ʵ����������д
    }

    public static void main(String[] args) {
        // ��������ʵ������ʾ
        test0 crudInterface = new test0();
        crudInterface.setTitle("����Ա��ɾ�Ĳ����");
        crudInterface.setSize(1000, 500); // �������ڴ�С����Ӧ���
        crudInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crudInterface.setLocationRelativeTo(null);

        crudInterface.setVisible(true);
    }
}