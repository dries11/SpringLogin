package ries.dan.Controller;

import ries.dan.Model.User.UserDTO;
import ries.dan.Model.User.User;
import ries.dan.Service.Auth.UserAuthServiceImpl;
import ries.dan.Service.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserAuthServiceImpl userAuthService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO userDTO){
        Integer userId = userAuthService.createNewUser(userDTO.getUsername(), userDTO.getPassword());
        if(userId != null) {
            User user = userService.createNewUser(userId, userDTO);
            System.out.println(user);
            if(user != null){
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDTO userDTO){
        Integer userId = userAuthService.loginUser(userDTO.getUsername(), userDTO.getPassword());
        if(userId != null){
            User user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
