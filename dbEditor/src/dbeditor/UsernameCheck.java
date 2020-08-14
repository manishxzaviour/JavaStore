package dbeditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsernameCheck {
    static  boolean Ok=false;
    static String  Result="Username and Password do not match";
    UsernameCheck(String Username) {
            try{
                Class.forName("org.postgresql.Driver");
                Connection connection=null;
                Statement statement=null;
                connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","superuser");
                statement=connection.createStatement();
                ResultSet rs=statement.executeQuery("select Username,id from logindata where Username =" + Username.hashCode());
                int UserName=0;
                if(rs.next()) {
                    UserName = rs.getInt("Username");
                    dbEditor_Frame1.id=rs.getInt("id");
                }
                if(Username.isEmpty())
                 Result="Username field is empty!";
                else if(Username.contains(" "))
                  Result="Username cannot contain whitespaces";
                else if(Username.length()<5)
                   Result="Username too short";
                else if(Username.length()>11)
                   Result="Username too long";
                else if (UserName==Username.hashCode())
                {
                    dbEditor_Frame1.Permit=true;
                    Ok=true;
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
    }
    UsernameCheck()
    {
    }
    public static void main(String[] args) {
        new UsernameCheck();
    }
}
