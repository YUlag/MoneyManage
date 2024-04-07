package Event;

import GUI.UpdateAndDeleteEmpGUI;
import SQL.Select;
import atom.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEmpByIdEvent implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = UpdateAndDeleteEmpGUI.getNumberText();

        if(number.equals("")){
            numberEmpty();
        }else {
            try{
                Emp emp = Select.selectEmpById(Integer.parseInt(number));

                UpdateAndDeleteEmpGUI.setUsernameText(emp.getUsername());
                UpdateAndDeleteEmpGUI.setPasswordText(emp.getPassword());
                UpdateAndDeleteEmpGUI.setNameText(emp.getName());
                UpdateAndDeleteEmpGUI.setGenderText(emp.getGender());
                UpdateAndDeleteEmpGUI.setPositionText(emp.getPosition());
                UpdateAndDeleteEmpGUI.setDepartmentText(emp.getDepartment());
                UpdateAndDeleteEmpGUI.setFinancialAuthorityText(emp.getFinancialAuthority());
                UpdateAndDeleteEmpGUI.setTimeText(emp.getHireYear());
                UpdateAndDeleteEmpGUI.setBirthText(emp.getBirthdate());
            }catch (NumberFormatException t1){
                numberFormatError();
                UpdateAndDeleteEmpGUI.setEmpIDText("");
            }catch (IndexOutOfBoundsException t2){
                numberOutError();
                UpdateAndDeleteEmpGUI.setEmpIDText("");
            }
        }

    }
    private void numberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
    private void numberOutError() {
        JOptionPane.showMessageDialog(null, "未找到指定工号,请重新输入", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
    private void numberFormatError() {
        JOptionPane.showMessageDialog(null, "输入格式有误，请重新输入", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
