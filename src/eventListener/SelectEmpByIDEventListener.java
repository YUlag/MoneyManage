package eventListener;

import event.SelectEmpByIdEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEmpByIDEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new SelectEmpByIdEvent().actionPerformed(e);
    }
}
