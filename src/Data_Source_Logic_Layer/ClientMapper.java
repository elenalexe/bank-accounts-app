package Data_Source_Logic_Layer;
import Domain_Logic_Layer.Client;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientMapper {

    public static Client getClientByClientId(int clientId)
    {
        Client client = new Client();
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String sql = "SELECT clientId, loginId, name, address, birthday FROM client WHERE clientId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, clientId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                client.setLogId(resultSet.getInt("loginId"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setBirthday(resultSet.getString("birthday"));
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, ClientMapper, getId" + e);
        }
        return client;
    }

    public static int getClientIdByLoginId(int loginId)
    {
        int r = -1;
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String sql = "SELECT clientId FROM client WHERE loginId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, loginId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                r = resultSet.getInt("clientId");
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
        }
        return r;
    }

    public static void updateClientByClientId(int id, String name, String address, String birthday)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "UPDATE client SET name=?, address=?, birthday=? WHERE clientId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, birthday);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin" + e);
        }
    }

    public static boolean verifyClientIdForAllClients(int clientId)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT clientId FROM client";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int result = resultSet.getInt("clientId");
                if (clientId == result)
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

    public static void insertClient(int clientId, int loginId, String name, String address, String birthday)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;

            String statement = "INSERT INTO client(clientId, loginId, name, address, birthday) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, loginId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, birthday);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, insert" + e);
        }
    }

    public static void getClient(JTable table)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT * FROM client";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tabel2 = (DefaultTableModel) table.getModel();
            while (resultSet.next())
            {
                int clientId = resultSet.getInt("clientId");
                int loginId = resultSet.getInt("loginId");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String birthday = resultSet.getString("birthday");
                tabel2.addRow(new Object[] {clientId, loginId, name, address, birthday});
            }
            resultSet.close();
        }
        catch (SQLException e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getId" + e);
        }
    }

    public static boolean verifyClientIdByLoginId(int loginId, int client)
    {
        try
        {
            DataBaseConnection db = DataBaseConnection.getConnection();
            Connection connection = db.conn;
            String sql = "SELECT clientId FROM client WHERE loginId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, loginId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int result = resultSet.getInt("clientId");
                if(client == result)
                {
                    return true;
                }
            }
            resultSet.close();
        }
        catch (Exception e)
        {
            System.out.println("Eroare in DataSource, LoginMapper, getLoginAdmin"
            + e);
        }
        return false;
    }
}
