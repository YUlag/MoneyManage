package eventListener;

import event.UpdateEmpEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateEmpEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new UpdateEmpEvent().actionPerformed(e);
    }
}
