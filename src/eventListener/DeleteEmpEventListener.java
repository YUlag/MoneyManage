package eventListener;

import event.DeleteEmpEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmpEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteEmpEvent().actionPerformed(e);
    }
}
