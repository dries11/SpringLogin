package ries.dan.Service.User;

import ries.dan.Dao.UserDao;
import ries.dan.Model.User.UserDTO;
import ries.dan.Model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceIF{

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        User user = userDao.findOne(id);
        return user;
    }

    @Override
    public User createNewUser(Integer id, UserDTO userDTO) {
        User user = serializeDTOtoUserObj(id, userDTO);
        User savedUser = userDao.save(user);
        return savedUser;
    }

    private User serializeDTOtoUserObj(Integer id, UserDTO userDTO){
        User user = new User();
        user.setId(id);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setGamesPlayed(0);
        user.setUsername(userDTO.getUsername());
        return user;
    }
}
