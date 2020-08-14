package dbeditor;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dbEditor_Frame1 {
    JFrame frame;
    JPanel panel;
    JLabel salutation ;
    JLabel username ;
    JLabel password ;
    JTextField userName;
    JPasswordField Password;
    JButton Login;
    JButton newUSr;
    JLabel time;
    JLabel errorU;
    JLabel errorP;
    JButton forgotPassword;
    static boolean Permit=false;
    static int id=0;
    static final int Root_Pin=7823;
    dbEditor_Frame1()
    {

        frame=new JFrame();
        frame.setTitle("DataBase Client");
        ImageIcon frameimg = new ImageIcon("src/rsz_1download.jpg");
        frame.setIconImage(frameimg.getImage());
        panel= new JPanel();
        newUSr = new JButton("new user");
        salutation = new JLabel();
        username = new JLabel();
        password = new JLabel();
        Login= new JButton();
        userName = new JFormattedTextField();
        Password = new JPasswordField();
        time= new JLabel();
        errorU=new JLabel();
        errorP=new JLabel();
        forgotPassword=new JButton();

        frame.setSize(570,400);
        panel.setBackground(new Color(0, 255, 255));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,10));
        frame.add(panel,BorderLayout.CENTER);
        frame.setResizable(false);
        panel.setLayout(null);

        salutation.setText("Login to access the DataBase");
        salutation.setForeground(new Color(72, 112, 112));
        salutation.setBounds(140,30,400, 26);
        salutation.setFont(new Font("San-Serif",Font.PLAIN,24));
        panel.add(salutation);

        username.setText("Username :");
        username.setForeground(new Color(62, 85, 138));
        username.setBounds(100,100,70, 25);
        username.setFont(new Font("Serif",Font.PLAIN,15));
        panel.add(username);

        password.setText("Password :");
        password.setForeground(new Color(62, 85, 138));
        password.setBounds(100,150,70, 25);
        password.setFont(new Font("Serif",Font.PLAIN,15));
        panel.add(password);

        userName.setFont(new Font("San-Serif",Font.PLAIN,15));
        userName.setForeground(new Color(126, 0, 210));
        userName.setBounds(190,100,170, 23);
        userName.setBorder(new EmptyBorder(2, 2, 2, 2));
        panel.add(userName);

        Password.setBackground(new Color(243, 237, 255));
        Password.setBounds(190,150,170, 23);
        Password.setBorder(new EmptyBorder(2, 2, 2, 2));
        panel.add(Password);

        errorU.setForeground(Color.red);
        errorU.setFont(new Font("Serif",Font.PLAIN,12));
        errorU.setBounds(190,255,200,14);
        errorU.setText("");
        panel.add(errorU);

        errorP.setForeground(Color.red);
        errorP.setFont(new Font("Serif",Font.PLAIN,12));
        errorP.setBounds(190,265,300,15);
        errorP.setText("");
        panel.add(errorP);

        Login.setSize(80,23);
        Login.setText("Login");
        Login.setBounds(185,190,80,23);
        Login.setBorderPainted(false);
        Login.setFocusPainted(false);
        Login.setBackground(new Color(132, 230, 241));
        panel.add(Login);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!new UsernameCheck(userName.getText()).Ok)
                    errorU.setText(UsernameCheck.Result);
                else errorU.setText("");
                if(!new PasswordCheck(Password.getPassword()).Ok)
                    errorP.setText(PasswordCheck.Result);
                else{
                    errorP.setText("");
                    frame.dispose();
                }

            }
        });


        newUSr.setFont(new Font("Serif",Font.PLAIN, 15));
        newUSr.setSize(87,23);
        newUSr.setBounds(275,190,87,23);
        newUSr.setBorderPainted(false);
        newUSr.setFocusPainted(false);
        newUSr.setBackground(new Color(132, 230, 241));
        panel.add(newUSr);
        newUSr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!new UsernameCheck(userName.getText()).Result.equals("Username and Password do not match"))
                    errorU.setText(UsernameCheck.Result);
                else
                    errorU.setText("");
                if(!new PasswordCheck(Password.getPassword()).Result.equals("Username and Password do not match"))
                    errorP.setText(PasswordCheck.Result);
                else {
                    new newUser(userName.getText().hashCode(),new String(Password.getPassword()).hashCode());
                    errorP.setText("");
                    frame.dispose();
                }
            }
        });

        forgotPassword.setFont(new Font("Serif",Font.PLAIN, 15));
        forgotPassword.setSize(87,23);
        forgotPassword.setBounds(195,220,160,23);
        forgotPassword.setBorderPainted(false);
        forgotPassword.setText("forgot Password");
        forgotPassword.setContentAreaFilled(false);
        panel.add(forgotPassword);
        forgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!new UsernameCheck(userName.getText()).Result.equals("Username and Password do not match"))
                 errorU.setText(UsernameCheck.Result);
                else
                    errorU.setText("");
               if(Integer.parseInt(JOptionPane.showInputDialog(null,"enter Root Pin"))==dbEditor_Frame1.Root_Pin && !new UpdatePassword(JOptionPane.showInputDialog(null,"enter Password").toCharArray()).Result.equals(""))
                   errorP.setText(UpdatePassword.Result);
               else {
                   Password.requestFocus();
                   errorP.setText("");
               }
            }
        });


        time.setText(LocalDate.now().toString()+"           "+ LocalTime.now().toString());
        time.setBounds(160,280,250,23);
        time.setFont(new Font("Serif",Font.BOLD,15));
        panel.add(time);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }



    public static void main(String[] args) {
        new dbEditor_Frame1();
    }


}
