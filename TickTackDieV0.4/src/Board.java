import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends CpuMove {
    static JFrame frame = new JFrame("TicTackDIE");
    static JLayeredPane containerL = new JLayeredPane();
    JPanel panel = new JPanel();

    static ImageIcon x = new ImageIcon("src/Webp.net-resizeimageX (1).png");
    static ImageIcon o = new ImageIcon("src/Webp.net-resizeimageO.png");
    static ImageIcon w = new ImageIcon("src/Webp.net-resizeimageBox.png");
    static ImageIcon p = new ImageIcon();
    static ImageIcon c = new ImageIcon();

    JLabel points = new JLabel("YOU                CPU");
    static JLabel youPoints = new JLabel();
    static JLabel cpuPoints = new JLabel();
    JButton containerB = new JButton();

    static int pPoint = 0;
    static int cPoint = 0;

    static JButton a1 = new JButton();
    static JButton a2 = new JButton();
    static JButton a3 = new JButton();
    static JButton b1 = new JButton();
    static JButton b2 = new JButton();
    static JButton b3 = new JButton();
    static JButton c1 = new JButton();
    static JButton c2 = new JButton();
    static JButton c3 = new JButton();


    Board() {
        new Place();
        frame.setBounds(200, 200, 350, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("src/FAVPNG_red-skull-bone_kPu7iYJJ (1).png").getImage());
        //frame.setAlwaysOnTop(true);


        points.setBounds(97, 15, 200, 19);
        points.setFont(new Font("San-Serif", Font.BOLD, 17));
        containerL.add(points, Integer.valueOf(0));


        youPoints.setBounds(110, 42, 20, 17);
        youPoints.setFont(new Font("San-Serif", Font.BOLD, 15));
        youPoints.setText(String.valueOf(pPoint));
        containerL.add(youPoints, Integer.valueOf(3));


        cpuPoints.setBounds(219, 42, 20, 17);
        cpuPoints.setFont(new Font("San-Serif", Font.BOLD, 15));
        cpuPoints.setText(String.valueOf(cPoint));
        containerL.add(cpuPoints, Integer.valueOf(3));


        containerB.setIcon(new ImageIcon("src/TicTackToe (1).png"));
        containerB.setBounds(42, 60, 255, 255);
        containerB.setFocusPainted(false);
        containerB.setBorderPainted(false);
        containerB.setContentAreaFilled(false);
        containerL.add(containerB, Integer.valueOf(0));

        panel.setLayout(new GridLayout(3, 3, -15, -15));
        panel.setBounds(46, 67, 245, 240);
        panel.setOpaque(false);

        //////

        a1.setIcon(w);
        a1.setFocusPainted(false);
        a1.setBorderPainted(false);
        a1.setContentAreaFilled(false);
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[0][0] == ' ') {
                    new Place(1, Place.board[0][0], true);
                    cpuM();
                }
            }
        });
        panel.add(a1);


        a2.setIcon(w);
        a2.setFocusPainted(false);
        a2.setBorderPainted(false);
        a2.setContentAreaFilled(false);
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[0][1] == ' ') {
                    new Place(2, Place.board[0][1], true);
                    cpuM();
                }
            }
        });
        panel.add(a2);


        a3.setIcon(w);
        a3.setFocusPainted(false);
        a3.setBorderPainted(false);
        a3.setContentAreaFilled(false);
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[0][2] == ' ') {
                    new Place(3, Place.board[0][2], true);
                    cpuM();
                }
            }
        });
        panel.add(a3);


        b1.setIcon(w);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[1][0] == ' ') {
                    new Place(4, Place.board[1][0], true);
                    cpuM();
                }
            }
        });
        panel.add(b1);


        b2.setIcon(w);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[1][1] == ' ') {
                    new Place(5, Place.board[1][1], true);
                    cpuM();
                }
            }
        });
        panel.add(b2);


        b3.setIcon(w);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.setContentAreaFilled(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[1][2] == ' ') {
                    new Place(6, Place.board[1][2], true);
                    cpuM();
                }
            }
        });
        panel.add(b3);


        c1.setIcon(w);
        c1.setFocusPainted(false);
        c1.setBorderPainted(false);
        c1.setContentAreaFilled(false);
        c1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[2][0] == ' ') {
                    new Place(7, Place.board[2][0], true);
                    cpuM();
                }
            }
        });
        panel.add(c1);


        c2.setIcon(w);
        c2.setFocusPainted(false);
        c2.setBorderPainted(false);
        c2.setContentAreaFilled(false);
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[2][1] == ' ') {
                    new Place(8, Place.board[2][1], true);
                    cpuM();
                }
            }
        });
        panel.add(c2);


        c3.setIcon(w);
        c3.setFocusPainted(false);
        c3.setBorderPainted(false);
        c3.setContentAreaFilled(false);
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Place.board[2][2] == ' ') {
                    new Place(9, Place.board[2][2], true);
                    cpuM();
                }
            }
        });
        panel.add(c3);
        containerL.add(panel, Integer.valueOf(3));
        ////

        JButton clear = new JButton("clear");
        JPanel Clear = new JPanel();
        Clear.setLayout(null);
        Clear.setBounds(132, 320, 70, 17);
        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.setBounds(0, 0, 70, 17);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Place();
            }
        });
        Clear.add(clear);
        containerL.add(Clear, Integer.valueOf(2));
        frame.add(containerL);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Board();
    }
}