package img;

import utils.CalendarPanel;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//测试类
public class DateChooser extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //private static Point startp = null;
    //private Point endp = null;

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setLayout(null);
        JTextField txt1 = new JTextField();
        JTextField txt2 = new JTextField();
        txt1.setBounds(20, 50, 300, 30);
        txt2.setBounds(20, 80, 300, 30);

        // 定义日历控件面板类
        CalendarPanel p1 = new CalendarPanel(txt1, "yyyy-MM-dd");
        CalendarPanel p2 = new CalendarPanel(txt2, "yyyy-MM-dd");
        p1.initCalendarPanel();
        p2.initCalendarPanel();

//        JLabel l = new JLabel("日历面板");
//        p.add(l);
        f.getContentPane().add(p1);
        f.getContentPane().add(p2);
        f.getContentPane().add(txt1);
        f.getContentPane().add(txt2);

        f.setSize(500, 400);
        f.setBackground(Color.WHITE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
