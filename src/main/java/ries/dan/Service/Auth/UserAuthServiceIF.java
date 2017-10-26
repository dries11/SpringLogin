package ries.dan.Service.Auth;

public interface UserAuthServiceIF {

    public Integer createNewUser(String username, String password);

    public Integer loginUser(String username, String password);

}
