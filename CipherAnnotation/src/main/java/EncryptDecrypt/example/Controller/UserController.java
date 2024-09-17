package EncryptDecrypt.example.Controller;


import EncryptDecrypt.Masking.Config.EncryptDecryptUtils;
import EncryptDecrypt.example.Entity.UserEntity;
import EncryptDecrypt.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        EncryptDecryptUtils.encryptFields(user);
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id) {
        UserEntity user =userService.getUserById(id);
        EncryptDecryptUtils.decryptFields(user);
        return user;
    }
}