package ries.dan.Service.Email;

import org.springframework.beans.factory.annotation.Autowired;
import ries.dan.Dao.UserDao;
import ries.dan.Model.User.User;
import ries.dan.Model.User.UserDTO;

public class EmailServiceImpl implements EmailServiceIF {

    @Autowired
    UserDao userDao;

    @Override
    public Boolean checkEmailAddressExists(UserDTO userDTO) {
        User user = userDao.getUserByEmail(userDTO.getEmail());
        if(user != null){
            return true;
        } else {
            return false;
        }
    }

}
