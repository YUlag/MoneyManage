package Event;

import GUI.ManageGUI;
import SQL.Select;
import atom.Emp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String number = ManageGUI.getNumberText();
        String name = ManageGUI.getNameText();
        String gender = ManageGUI.getGenderText();
        String department = ManageGUI.getDeptText();
        String position = ManageGUI.getPositionText();

        List<Emp> emps = Select.selectEmp(number, name, gender, department, position);
    }
}
