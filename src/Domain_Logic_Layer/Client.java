package Domain_Logic_Layer;

public class Client {

    private int loginId;
    private String name;
    private String address;
    private String birthday;
    private int clientId;


    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public int getLoginId()
    {
        return loginId;
    }

    public void setLogId(int loginId)
    {
        this.loginId = loginId;
    }
}
