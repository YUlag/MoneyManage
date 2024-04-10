package eventListener;

import event.DeleteSalaryEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteSalaryEventListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteSalaryEvent().actionPerformed(e);
    }
}
