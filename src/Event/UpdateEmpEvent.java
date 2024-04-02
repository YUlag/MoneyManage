package Event;

import GUI.ManageGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String number = ManageGUI.getNumberText();
        String name = ManageGUI.getNameText();
        String gender = ManageGUI.getGenderText();
        String dept = ManageGUI.getDeptText();
        String time = ManageGUI.getTimeText();

        if(number.equals("")){
            NumberEmpty();
        }else{

        }
    }

    private void NumberEmpty() {
        JOptionPane.showMessageDialog(null, "根据工号更新,不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
    }
}
