package event;

import SQL.Delete;
import managerGUI.UpdateAndDeleteEmpGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteEmpEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String empID = UpdateAndDeleteEmpGUI.getNumberText();
//        JFrame frame = new JFrame("修改确认弹窗示例");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 400);

        if (empID.equals("") || empID.equals("工号不可修改，仅做查询")) {
            numberEmpty();
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "你确定要删除吗？", "删除确认", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                // 用户点击了“是”，执行修改操作
                if (Delete.deleteEmp(empID)) {
                    JOptionPane.showMessageDialog(null, "删除成功", null, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败，未找到指定工号", null, JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
