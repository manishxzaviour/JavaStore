package dbeditor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatePassword {
    static String  Result="";
    Connection connection=null;
    Statement statement=null;
    UpdatePassword(){};
    UpdatePassword(char[] Password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","superuser");
            statement=connection.createStatement();
            if(UsernameCheck.Ok){

                if(Password.length==0)
                    Result="Password field is empty!";
                else if(Password.toString().contains(" "))
                    Result="Password cannot contain whitespaces";
                else if(Password.length<5)
                    Result="Password too short";
                else if(!Password.toString().contains("@")&&!Password.toString().contains("#")&&!Password.toString().contains("$")&&!Password.toString().contains("%")&&!Password.toString().contains("&")&&!Password.toString().contains("*"))
                    Result="Password must contain one of '@'/'#'/'$'/'%'/'&'/'*'";
                else
                {
                    statement.executeUpdate("Update logindata set password = "+new String(Password).hashCode()+" where id = "+dbEditor_Frame1.id);
                    System.out.println(" ok");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        };
    }

        public static void main(String[] args) {
        new UpdatePassword();
    }
}
