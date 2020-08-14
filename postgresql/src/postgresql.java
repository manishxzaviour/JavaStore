
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class postgresql {
    public static void main(String[] args)
    {
            Connection connection =null;
            Statement statement =null;
            int a=0;
            char b='A';
            try{
                 Class.forName("org.postgresql.Driver");
                 connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","superuser");
                 if(connection!=null)
                    System.out.println("connection ok");

                 else
                     System.out.println("failed");
                 statement=connection.createStatement();
                statement.executeUpdate("drop table if exists test;create table test(id serial, primary key(id),letter varchar(1));");
                for(int i=0;i<11;i++){
                    a++;
                    statement.executeUpdate(" insert into test values("+a+",'"+b+"');");
                    b=(char)(b+1);
                }
            }

            catch (Exception e)
            {
                System.out.println(e);
            }
    }
}
