package event;

import SQL.Select;
import atom.Emp;
import managerGUI.ManagerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectEmpEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String number = ManagerGUI.getNumberText();
        String name = ManagerGUI.getNameText();
        String gender = ManagerGUI.getGenderText();
        String department = ManagerGUI.getDeptText();
        String position = ManagerGUI.getPositionText();

        List<Emp> emps = Select.selectEmp(number, name, gender, department, position);
    }
}
