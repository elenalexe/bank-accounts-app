package Domain_Logic_Layer;



import javax.swing.JTable;
import Data_Source_Logic_Layer.ClientMapper;

public class ClientLogic {

    public static int getClientId(int id)
    {
        return ClientMapper.getClientIdByLoginId(id);
    }

    public static Client getClientByClientId(int id_client)
    {
        return ClientMapper.getClientByClientId(id_client);
    }

    public static boolean verifyClientIdForAllClients(int x)
    {
        return ClientMapper.verifyClientIdForAllClients(x);
    }

    public static void insertClient(int clientId, int loginId, String name, String address, String birthday)
    {
        ClientMapper.insertClient(clientId, loginId, name, address, birthday);
    }

    public static void updateClientByClientId(int id, String name, String address, String birthday)
    {
        ClientMapper.updateClientByClientId(id, name, address, birthday);
    }

    public static void getClient(JTable table)
    {
        ClientMapper.getClient(table);
    }

    public static boolean verifyClientIdByLoginId(int loginId, int client)
    {
        return ClientMapper.verifyClientIdByLoginId(loginId, client);
    }
}
