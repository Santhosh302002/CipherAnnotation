package EncryptDecrypt.example.Service;

import EncryptDecrypt.example.Entity.UserEntity;
import EncryptDecrypt.example.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, UserEntity> userStore = new HashMap<>();
    private long currentId = 1;

    public UserEntity saveUser(UserEntity user) {
        user.setId(currentId++);
        userStore.put(user.getId(), user);
        return user;
    }

    public UserEntity getUserById(Long id) {
        return userStore.get(id);
    }
}