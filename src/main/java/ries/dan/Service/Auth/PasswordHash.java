package ries.dan.Service.Auth;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
@Component
public class PasswordHash {

    public String hashPassword(String salt, String password){
        String passwordToHash = salt + password;
        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        return sha256hex;
    }

}
