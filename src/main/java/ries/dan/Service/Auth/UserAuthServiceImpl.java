package ries.dan.Service.Auth;

import ries.dan.Dao.UserAuthDao;
import ries.dan.Model.User.Auth.UserAuth;
import ries.dan.Model.User.Auth.UserAuthFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthServiceImpl implements UserAuthServiceIF{


    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private UserAuthFactory userAuthFactory;

    @Autowired
    private PasswordHash passwordHash;

    @Override
    public Integer createNewUser(String username, String password) {
        UserAuth userAuth = userAuthFactory.createNewUser(username, password);
        UserAuth savedUserAuth = userAuthDao.save(userAuth);
        if(savedUserAuth.equals(userAuth)){
            return savedUserAuth.getId();
        } else {
            return null;
        }
    }

    @Override
    public Integer loginUser(String username, String password) {
        UserAuth userAuth = userAuthDao.getUserAuthByUsername(username);
        String hashedEnteredPassword = passwordHash.hashPassword(userAuth.getGeneratedSalt(), password);
        if(hashedEnteredPassword.equals(userAuth.getHashedPassword())){
            return userAuth.getId();
        } else
            return null;
    }

    @Override
    public ArrayList<UserAuth> getAllUsers() {
        ArrayList<UserAuth> userAuths = new ArrayList<>();
        userAuthDao.findAll().forEach(userAuths::add);
        return userAuths;
    }
}
