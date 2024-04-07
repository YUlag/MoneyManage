package Event;

import GUI.UpdateAndDeleteEmpGUI;
import SQL.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String empID = UpdateAndDeleteEmpGUI.getNumberText();
        String username = UpdateAndDeleteEmpGUI.getUserNameText();
        String password = UpdateAndDeleteEmpGUI.getPasswordText();
        String name = UpdateAndDeleteEmpGUI.getNameText();
        String gender = UpdateAndDeleteEmpGUI.getGenderText();

        String position = UpdateAndDeleteEmpGUI.getPositionText();
        String department = UpdateAndDeleteEmpGUI.getDepartmentText();

        String financialAuthority = UpdateAndDeleteEmpGUI.getFinancialAuthorityText();
        String time = UpdateAndDeleteEmpGUI.getTimeText();
        String birth = UpdateAndDeleteEmpGUI.getBirthText();

        if(empID.equals("")){
            numberEmpty();
        }else if (username.equals("") || password.equals("") || name.equals("") || gender.equals("") || department.equals("") || position.equals("") || time.equals("") || birth.equals("") || financialAuthority.equals("")){
            informationEmpty();
        }else {
            Update.updateEmp(empID,username,password,name,gender,position,department,financialAuthority,time,birth);
        }
    }

    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }

    private void informationEmpty(){
        JOptionPane.showMessageDialog(null, "信息不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
