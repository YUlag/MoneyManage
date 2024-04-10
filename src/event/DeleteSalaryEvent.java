package event;

import SQL.Delete;
import accountingGUI.UpdateAndDeleteSalaryGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSalaryEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String SalaryID = UpdateAndDeleteSalaryGUI.getSalaryIDText();

        if (SalaryID.equals("")) {
            numberEmpty();
        } else {
            int choice = JOptionPane.showConfirmDialog(null, "你确定要删除吗？", "删除确认", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                // 用户点击了“是”，执行修改操作
                if (Delete.deleteSalary(SalaryID)) {
                    JOptionPane.showMessageDialog(null, "删除成功", null, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败，未找到指定工号", null, JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工资号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
