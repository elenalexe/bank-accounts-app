package Data_Source_Logic_Layer;

import Domain_Logic_Layer.Login;
import java.sql.*;
import java.lang.String;

public class LoginMapper
{

    public static boolean getLoginAdmin(String username, String password)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String sql = "SELECT username, password, role FROM login WHERE(username=? and password=?)";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setString(1, username);
            prepSt.setString(2, password);

            ResultSet resultSet = prepSt.executeQuery();

            int r = 0;
            if(resultSet.next())
            {
                r = resultSet.getInt("role");
            }
            resultSet.close();
            if(r == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
            return false;
        }
    }

    public static boolean getLoginClient(String username, String password)
    {
        try {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String sql = "SELECT username, password, role FROM login WHERE (username=? and password=?)";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setString(1, username);
            prepSt.setString(2, password);

            ResultSet resultSet = prepSt.executeQuery();

            int r = -1;
            if (resultSet.next()) {
                r = resultSet.getInt("role");
            }
            resultSet.close();
            if (r == 0) {
                return true;
            } else {
                return false;
            }
        }
            catch(Exception e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getLoginClient" + e);
                return false;
            }
        }

        public static int getLoginId(Login login)
        {
            int loginId = 0;
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;
                String sql = "SELECT loginId FROM login WHERE username =? AND password =?";
                PreparedStatement prepSt = connection.prepareCall(sql);
                prepSt.setString(1, login.getUsername());
                prepSt.setString(2, login.getPassword());
                ResultSet resultSet = prepSt.executeQuery();
                while(resultSet.next())
                {
                    loginId = resultSet.getInt("Id");
                }
                resultSet.close();
            }
            catch (SQLException e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getLoginId(login)" + e);
            }
            return loginId;
        }

        public static int getLoginId(String username, String password)
        {
            int r = -1;
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;

                String sql = "SELECT loginId FROM login WHERE username=? AND password=?";
                PreparedStatement prepSt = connection.prepareStatement(sql);

                prepSt.setString(1,username);
                prepSt.setString(2,password);

                ResultSet resultSet = prepSt.executeQuery();

                if(resultSet.next())
                {
                    r = resultSet.getInt("loginId");
                }
            }
            catch (Exception e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getLoginId(username, password" + e);
            }
            return r;
        }

        public static Login getId(String username, String password)
        {
            Login log = new Login();
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;
                String sql = "SELECT * FROM login WHERE username=? AND password=?";
                PreparedStatement prepSt = connection.prepareStatement(sql);
                prepSt.setString(1, username);
                prepSt.setString(2, password);
                ResultSet resultSet = prepSt.executeQuery();
                while(resultSet.next())
                {
                    log.setLoginId(resultSet.getInt("loginId"));
                    log.setUsername(resultSet.getString("username"));
                    log.setPassword(resultSet.getString("password"));
                    log.setRole(resultSet.getInt("role"));
                }
                resultSet.close();
            }
            catch (SQLException e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
            }
            return log;
        }

        public static void insertLogin(String username,String password, int role, int loginId)
        {
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;

                String statement = "INSERT INTO login(username, password, role, loginId) VALUES (?, ?, ?, ?)";
                PreparedStatement prepSt = connection.prepareStatement(statement);
                prepSt.setString(1, username);
                prepSt.setString(2, password);
                prepSt.setInt(3, role);
                prepSt.setInt(4, loginId);

                prepSt.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, Insert" + e);
            }
        }

        public static Login getLogByUsername(String username)
        {
            Login log = new Login();
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;
                String sql = "SELECT loginId, password, role FROM login WHERE username=?";
                PreparedStatement prepSt = connection.prepareStatement(sql);

                prepSt.setString(1, username);

                ResultSet resultSet = prepSt.executeQuery();
                while(resultSet.next())
                {
                    log.setLoginId(resultSet.getInt("loginId"));
                    log.setPassword(resultSet.getString("password"));
                    log.setRole(resultSet.getInt("role"));
                }
                resultSet.close();
            }
            catch (SQLException e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
            }
            System.out.println("S1: " +log.getUsername());
            System.out.println("S2: " +log.getLoginId());

            return log;
        }

        public static void deleteClientByLoginId(int loginId)
        {
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;

                String sql = "DELETE FROM login WHERE loginId=?";
                PreparedStatement prepSt = connection.prepareStatement(sql);

                prepSt.setInt(1, loginId);
                prepSt.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Eroare in DataSoruce, LoginMapper, getId"
                +e);
            }
        }

        public static boolean verifyLoginIdForAllLogins(int loginId)
        {
            try
            {
                DataBaseConnection db = DataBaseConnection.getConnection();
                Connection connection = db.conn;
                String sql = "SELECT loginId FROM login";
                PreparedStatement prepSt = connection.prepareStatement(sql);

                ResultSet resultSet = prepSt.executeQuery();
                while (resultSet.next())
                {
                    int result = resultSet.getInt("loginId");
                    if (loginId == result)
                    {
                        return true;
                    }
                }
                resultSet.close();;
            }
            catch (Exception e)
            {
                System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin"
                +e);
            }
            return false;
        }
    }

