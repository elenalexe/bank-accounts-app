package Domain_Logic_Layer;

import java.util.UUID;

public class Account {

    private int clientId;
    private String type;
    private double amount;
    private String date;
    private int accountId;


    public int getClientId()
    {
        return clientId;
    }

    public void setClientId (int clientId)
    {
        this.clientId = clientId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }
}
