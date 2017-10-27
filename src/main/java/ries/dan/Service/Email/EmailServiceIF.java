package ries.dan.Service.Email;

import ries.dan.Model.User.UserDTO;

public interface EmailServiceIF {

    Boolean checkEmailAddressExists(UserDTO userDTO);

}
