package ries.dan.Service.Auth;

import ries.dan.Model.User.Auth.UserAuth;

import java.util.ArrayList;

public interface UserAuthServiceIF {

    Integer createNewUser(String username, String password);

    Integer loginUser(String username, String password);

    ArrayList<UserAuth> getAllUsers();
}
