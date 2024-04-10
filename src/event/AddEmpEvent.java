package event;

import SQL.Insert;
import managerGUI.AddEmpGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String empID = AddEmpGUI.getNumberText();
        String username = AddEmpGUI.getUserNameText();
        String password = AddEmpGUI.getPasswordText();
        String name = AddEmpGUI.getNameText();
        String gender = AddEmpGUI.getGenderText();
        String position = AddEmpGUI.getPositionText();
        String department = AddEmpGUI.getDepartmentText();
        String financialAuthority = AddEmpGUI.getFinancialAuthorityText();
        String time = AddEmpGUI.getTimeText();
        String birth = AddEmpGUI.getBirthText();

        if (empID.equals("") || username.equals("") || password.equals("") || name.equals("") || gender.equals("") || department.equals("") || position.equals("") || time.equals("") || birth.equals("") || financialAuthority.equals("")) {
            informationEmpty();
        } else {
            Insert.addEmp(empID, username, password, name, gender, position, department, financialAuthority, time, birth);
        }
    }

    private void informationEmpty() {
        JOptionPane.showMessageDialog(null, "信息不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }


}
