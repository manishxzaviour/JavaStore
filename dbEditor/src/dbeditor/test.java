package dbeditor;/*package dbeditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
       /* try {
            Connection connection;
            Statement statement;
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "superuser");
            statement = connection.createStatement();
            statement.executeUpdate("update logindata set username="+new String("postgre").hashCode()+",password="+new String("postgre@sql").hashCode()+" where id =3;");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
*//*
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
class SwingDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click to Close!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(button);
        button.addActionListener(e -> {
            frame.dispose();
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 300));
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.pack();
        frame.setVisible(true);
    }
}*/
