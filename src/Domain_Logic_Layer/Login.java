package Domain_Logic_Layer;

public class Login {

    private int loginId;
    private String username;
    private String password;
    private int role;

    public int getLoginId()
    {
        return loginId;
    }

    public void setLoginId(int loginId)
    {
        this.loginId = loginId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getRole()
    {
        return role;
    }

    public void setRole(int role)
    {
        this.role = role;
    }
}
