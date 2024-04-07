package Event;

import GUI.ManageGUI;
import GUI.UpdateEmpGUI;
import SQL.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String number = UpdateEmpGUI.getNumberText();
        String username = UpdateEmpGUI.getUserNameText();
        String password = UpdateEmpGUI.getPasswordText();
        String name = UpdateEmpGUI.getNameText();
        String gender = UpdateEmpGUI.getGenderText();

        String position = UpdateEmpGUI.getPositionText();
        String department = UpdateEmpGUI.getDepartmentText();

        String financialAuthority = UpdateEmpGUI.getFinancialAuthorityText();
        String time = UpdateEmpGUI.getTimeText();
        String birth = UpdateEmpGUI.getBirthText();

        if(number.equals("")){
            numberEmpty();
        }else if (username.equals("") || password.equals("") || name.equals("") || gender.equals("") || department.equals("") || position.equals("") || time.equals("") || birth.equals("") || financialAuthority.equals("")){
            informationEmpty();
        }else {
            Update.updateEmp(number,username,password,name,gender,position,department,financialAuthority,time,birth);
        }
    }

    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }

    private void informationEmpty(){
        JOptionPane.showMessageDialog(null, "信息不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
