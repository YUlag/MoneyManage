package eventListener;

import event.SelectSalaryByIDEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSalaryByIDEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SelectSalaryByIDEvent().actionPerformed(e);
    }
}
