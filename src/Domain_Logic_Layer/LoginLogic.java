package Domain_Logic_Layer;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Data_Source_Logic_Layer.DataBaseConnection;
import Data_Source_Logic_Layer.LoginMapper;

public class LoginLogic {

    public static boolean verifyLoginAdmin(String username, String password)
    {
        return LoginMapper.getLoginAdmin(username, password);
    }

    public static boolean verifyLoginClient(String username, String password)
    {
        return LoginMapper.getLoginClient(username, password);
    }

    public static int getRole(boolean admin, boolean client)
    {
        if(admin)
        {
            return 1;
        }
        if (client)
        {
            return 0;
        }
        return -1;
    }

    public static Login getId(String username, String password)
    {
        return LoginMapper.getId(username, password);
    }

    public static Login getLoginByUsername(String username)
    {
        System.out.println("S3: "+username);
        return LoginMapper.getLogByUsername(username);
    }

    public static boolean verifyLoginIdForAllLogins(int x)
    {
        return LoginMapper.verifyLoginIdForAllLogins(x);
    }

    public static void deleteClientByLoginId(int x)
    {
        LoginMapper.deleteClientByLoginId(x);
    }

    public static void insertLogin(String x, String y, int z, int a)
    {
        LoginMapper.insertLogin(x, y, z, a);
    }
}
