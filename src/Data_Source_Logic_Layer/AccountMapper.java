package Data_Source_Logic_Layer;

import Domain_Logic_Layer.Account;
import Domain_Logic_Layer.Login;
import Data_Source_Logic_Layer.DataBaseConnection;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AccountMapper {

    public static void updateAmountById(int id, double amount)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "UPDATE account set amount =? WHERE accountId =?";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setDouble(1, amount);
            prepSt.setInt(2, id);
            prepSt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
        }
    }

    public static double getAmountByAccountId(int accountId)
    {
        double amount = -1;
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT amount FROM account WHERE accountId=?";
            PreparedStatement prepSt = connection.prepareCall(sql);
            prepSt.setInt(1, accountId);

            ResultSet resultSet = prepSt.executeQuery();
            while (resultSet.next())
            {
                amount = resultSet.getDouble("amount");
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginId(login)" + e);
        }
        return amount;
    }

    public static boolean verifyAccountId(int clientId, int accountId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT accountId FROM account WHERE clientId=?";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setInt(1, clientId);
            ResultSet resultSet = prepSt.executeQuery();
            while (resultSet.next())
            {
                int result = resultSet.getInt("accountId");
                if(accountId == result)
                {
                    return true;
                }
            }
            resultSet.close();
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
        }
        return false;
    }

    public static void deleteAccountByAccountId(int accountId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String sql = "DELETE FROM account WHERE accountId=?";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setInt(1, accountId);
            prepSt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
        }
    }

    public static boolean verifyAccountIdForAllClients(int accountId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT accountId FROM account";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            ResultSet resultSet = prepSt.executeQuery();
            while (resultSet.next())
            {
                int result = resultSet.getInt("accountId");
                if(accountId == result)
                {
                    return true;
                }
            }
            resultSet.close();
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
        }
        return false;
    }

    public static int insertAccount(int clientId, String type, double amount, String date, int accountId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String statement = "INSERT INTO account(clientId, type, amount, date, accountId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prepSt = connection.prepareStatement(statement);

            prepSt.setInt(1, clientId);
            prepSt.setString(2, type);
            prepSt.setDouble(3, amount);
            prepSt.setString(4, date);
            prepSt.setInt(5, accountId);

            prepSt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, insert" + e);
            return 0;
        }
        return 1;
    }

    public static void getAccountByClientId(int clientId, JTable table)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT * FROM account WHERE clientId=?";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, clientId);
            ResultSet resultSet = prepSt.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next())
            {
                int accountId = resultSet.getInt("accountId");
                String type = resultSet.getString("type");
                Double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                tableModel.addRow(new Object[] {accountId, type, amount, date});
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
        }
    }

    public static void getAccount(JTable table)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT * FROM account";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            ResultSet resultSet = prepSt.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next())
            {
                int clientId = resultSet.getInt("clientId");
                String type = resultSet.getString("type");
                Double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                int accountId = resultSet.getInt("accountId");
                tableModel.addRow(new Object[] { clientId, type, amount, date, accountId});
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
        }
    }

    public static String getTypeByAccountId(int accountId)
    { String type = "";
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT type FROM account WHERE accountId=?";
            PreparedStatement prepSt = connection.prepareStatement(sql);
            prepSt.setInt(1, accountId);

            ResultSet resultSet = prepSt.executeQuery();
            if(resultSet.next())
            {
                type = resultSet.getString("type");
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginId(login" + e);
        }
        return type;
    }

    public static void updateAccountByAccountId(int clientId, String type, Double amount, String date, int accountId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "UPDATE account SET clientId=?, type=?, amount=?, date=?, WHERE accountId=?";
            PreparedStatement prepSt = connection.prepareStatement(sql);

            prepSt.setInt(1, clientId);
            prepSt.setString(2, type);
            prepSt.setDouble(3, amount);
            prepSt.setString(4, date);
            prepSt.setInt(5, accountId);
            prepSt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
        }
    }

}
