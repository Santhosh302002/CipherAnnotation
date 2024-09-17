package EncryptDecrypt.Masking.Config;

import EncryptDecrypt.Masking.Annotations.EncryptDecrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.util.Base64;



public class EncryptDecryptUtils {

    private static final String base64Key = "xt2op6rwgYD1oD01Xzrctw==";
    static byte[] decodedKey = Base64.getDecoder().decode(base64Key);
    static SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    public static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedValue = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue);
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedValue);
        return new String(cipher.doFinal(decodedValue));
    }

    public static void encryptFields(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(EncryptDecrypt.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(obj);
                    if (value != null) {
                        field.set(obj, encrypt(value));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting fields", e);
        }
    }

    public static void decryptFields(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(EncryptDecrypt.class)) {
                    field.setAccessible(true);
                    String encryptedValue = (String) field.get(obj);
                    if (encryptedValue != null) {
                        field.set(obj, decrypt(encryptedValue));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting fields", e);
        }
    }
}
