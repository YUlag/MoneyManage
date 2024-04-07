package Event;

import GUI.UpdateEmpGUI;
import SQL.Select;
import atom.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEmpByIdEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = UpdateEmpGUI.getNumberText();

        if(number.equals("")){
            numberEmpty();
        }else {
            Emp emp = Select.selectEmpById(Integer.parseInt(number));

            UpdateEmpGUI.setUsernameText(emp.getUsername());
            UpdateEmpGUI.setPasswordText(emp.getPassword());
            UpdateEmpGUI.setNameText(emp.getName());
            UpdateEmpGUI.setGenderText(emp.getGender());
            UpdateEmpGUI.setPositionText(emp.getPosition());
            UpdateEmpGUI.setDepartmentText(emp.getDepartment());
            UpdateEmpGUI.setFinancialAuthorityText(emp.getFinancialAuthority());
            UpdateEmpGUI.setTimeText(emp.getHireYear());
            UpdateEmpGUI.setBirthText(emp.getBirthdate());
        }

    }
    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
