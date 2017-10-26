package ries.dan.Service.User;

import ries.dan.Model.User.UserDTO;
import ries.dan.Model.User.User;

public interface UserServiceIF {

    User getUserById(Integer id);

    User createNewUser(Integer id, UserDTO userDTO);

}
