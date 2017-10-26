package ries.dan.Model.User.Auth;


import ries.dan.Service.Auth.PasswordHash;
import org.springframework.stereotype.Component;


import java.security.SecureRandom;
import java.util.Base64;

@Component
public class UserAuthFactory {

    public UserAuth createNewUser(String username, String password){
        UserAuth userAuth = new UserAuth();
        PasswordHash passwordHash = new PasswordHash();
        userAuth.setUsername(username);
        userAuth.setGeneratedSalt(createSalt());
        userAuth.setHashedPassword(passwordHash.hashPassword(userAuth.getGeneratedSalt(), password));
        return userAuth;
    }

    private String createSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[32];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

}
