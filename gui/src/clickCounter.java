import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickCounter implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;
    int count =0;
    public clickCounter()
    {
        frame = new JFrame();
        panel=new JPanel();
        button=new JButton("click");
        button.addActionListener(this);
        label= new JLabel("count:0" );
        label.setForeground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.black);
        panel.add(button);
        panel.add(label);
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("buttonClickCounter");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new clickCounter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("count:"+count);
    }
}
