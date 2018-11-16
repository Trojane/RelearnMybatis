import POJO.Role;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class testJDBC {

    public static void main(String[] args) throws SQLException {

       /* String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:localhost:1521:orcl";
        String username = "SCOTT";
        String password = "12345678";*/

        String driver = null;
        String url = null;
        String username = null;
        String password = null;
        Connection connection =  null;
        Statement statement = null;

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("jdbc.properties");

            Properties properties = new Properties();
            properties.load(resourceAsStream);

            driver = properties.getProperty("oracle.driver");
            url = properties.getProperty("oracle.url");
            username = properties.getProperty("oracle.username");
            password = properties.getProperty("oracle.password");



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }




        try {
            Class.forName(driver);
             connection = DriverManager.getConnection(url, username, password);
            /*statement = connection.prepareStatement("select id,name as roleName,age from ROLE where id = ?");
            System.out.println(statement);
            statement.setString(1,"1");*/
            statement = connection.createStatement();
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery("select id,name as roleName,age from ROLE where id = 4");
            /*ResultSet resultSet = statement.executeQuery();*/
            Role role = null;

            if(resultSet.next()){
                role = new Role();
                System.out.println("test");
                role.setId(resultSet.getString("id"));
                role.setRoleName(resultSet.getString("roleName"));
                role.setAge(resultSet.getInt("age"));
            }

            System.out.println("Role==> "+role);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            statement.close();
        }

    }

}
