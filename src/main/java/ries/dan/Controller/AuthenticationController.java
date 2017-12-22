package ries.dan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ries.dan.Model.User.Auth.UserAuth;
import ries.dan.Model.User.UserDTO;
import ries.dan.Service.Auth.UserAuthServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserAuthServiceImpl userAuthService;

    @PostMapping("/createUser")
    public ResponseEntity<Integer> createNewUser(@RequestBody UserDTO userDTO){
        Integer userId = userAuthService.createNewUser(userDTO.getUsername(), userDTO.getPassword());
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO userDTO){
        Integer userId = userAuthService.loginUser(userDTO.getUsername(), userDTO.getPassword());
        if (userId != null){
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAuth>> getAllUsers(){
        ArrayList<UserAuth> users = userAuthService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}
