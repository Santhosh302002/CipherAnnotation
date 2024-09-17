package EncryptDecrypt.example.Entity;

import EncryptDecrypt.Masking.Annotations.EncryptDecrypt;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "userData", schema = "public")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EncryptDecrypt
    private String name;

    @EncryptDecrypt
    private String email;

}