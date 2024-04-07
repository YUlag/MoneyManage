package img;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyConfirmationDialogExample {

    public static void main(String[] args) {
        // 创建主窗口
        JFrame frame = new JFrame("修改确认弹窗示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // 创建一个按钮，点击时弹出确认弹窗
        JButton modifyButton = new JButton("修改");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "你确定要修改吗？", "修改确认", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    // 用户点击了“是”，执行修改操作
                    System.out.println("用户确认修改");
                } else {
                    // 用户点击了“否”或取消了操作
                    System.out.println("用户取消修改");
                }
            }
        });
        frame.add(modifyButton);

        // 显示窗口
        frame.setVisible(true);
    }
}