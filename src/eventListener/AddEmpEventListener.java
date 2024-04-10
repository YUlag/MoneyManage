package eventListener;

import event.AddEmpEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmpEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new AddEmpEvent().actionPerformed(e);
    }
}
