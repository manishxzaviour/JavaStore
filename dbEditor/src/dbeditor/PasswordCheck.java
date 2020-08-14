package dbeditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PasswordCheck {
    static String  Result="Username and Password do not match";
    Connection connection=null;
    Statement statement=null;
    static boolean Ok=false;
    PasswordCheck(char[] Password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","superuser");
            statement=connection.createStatement();
            if(UsernameCheck.Ok){
            ResultSet rs=statement.executeQuery("select Password from logindata where id =" + dbEditor_Frame1.id);
            int PassWord=0;
            if(rs.next())
                PassWord=rs.getInt("Password");
            if(Password.length==0)
               Result="Password field is empty!";
            else if(Password.toString().contains(" "))
               Result="Password cannot contain whitespaces";
            else if(Password.length<5)
               Result="Password too short";
            else if(!Password.toString().contains("@")&&!Password.toString().contains("#")&&!Password.toString().contains("$")&&!Password.toString().contains("%")&&!Password.toString().contains("&")&&!Password.toString().contains("*"))
               Result="Password must contain one of '@'/'#'/'$'/'%'/'&'/'*'";
            else if (PassWord==new String(Password).hashCode())
            {
                dbEditor_Frame1.Permit=true;
                Ok=true;
                statement.executeUpdate("Update logindata set last_login = now() where id = "+dbEditor_Frame1.id);
                System.out.println(" ok");
            }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    PasswordCheck()
    {
    }
    public static void main(String[] args) {
        new PasswordCheck();
}
}
