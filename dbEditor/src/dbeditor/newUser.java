package dbeditor;

import javax.swing.*;
import java.lang.invoke.TypeDescriptor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class newUser {
    newUser(int Username,int Password){
        Connection connection = null;
        Statement statement=null;
        if(Integer.parseInt(JOptionPane.showInputDialog(null,"enter Root Pin"))==dbEditor_Frame1.Root_Pin)
        {
            try{
                     Class.forName("org.postgresql.Driver");
                    connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","superuser");
                    statement = connection.createStatement();
                    statement.executeQuery("insert into logindata(id,username,password) values(default,"+Username+","+Password+")");
                    JOptionPane.showMessageDialog(null,"new user added");
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
    newUser(){

    }
    public static void main(String[] args) {
            new newUser();
    }
}
