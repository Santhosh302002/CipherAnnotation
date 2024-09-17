package EncryptDecrypt.example.Repository;

import EncryptDecrypt.example.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
}

