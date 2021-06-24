package Domain_Logic_Layer;

import javax.swing.JTable;
import Data_Source_Logic_Layer.AccountMapper;
import java.lang.String;

public class AccountLogic {

    public static void getAccount(int x, JTable table)
    {
        AccountMapper.getAccountByClientId(x, table);
    }

    public static void UpdateAmount(int x, double y)
    {
        AccountMapper.updateAmountById(x, y);
    }

    public static boolean verifyAccountId(int x, int y)
    {
        return AccountMapper.verifyAccountId(x, y);
    }

    public static boolean verifyAccountIdForAllClients(int x)
    {
        return AccountMapper.verifyAccountIdForAllClients(x);
    }

    public static void deleteAccount (int x)
    {
        AccountMapper.deleteAccountByAccountId(x);
    }

    public static int insertAccount (int clientId, String type, Double amount, String date, int accountId)
    {
        return AccountMapper.insertAccount(clientId, type, amount, date, accountId);
    }

    public static void getAccount(JTable table)
    {
        AccountMapper.getAccount(table);
    }

    public static String getTypeByIdAccount(int accountId)
    {
        return AccountMapper.getTypeByAccountId(accountId);
    }

    public static void updateAccountByAccountId (int clientId, String type, Double amount, String date, int accountId)
    {
        AccountMapper.updateAccountByAccountId(clientId, type, amount, date, accountId);
    }
}
