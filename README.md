# Custom Encryption Annotation Project

This project demonstrates how to implement a custom `@EncryptDecrypt` annotation  in Spring. The annotation can be used to automatically encrypt data before it's processed or stored in a database and when you fetch it will be decode and retured.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [How It Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

## Features

- Custom `@EncryptDecrypt` annotation for encrypting sensitive data.
- AES encryption of string data.
- Spring Boot integration for seamless application development.

## Prerequisites

- **Java 17+**
- **Spring Boot 2.5+**
- Maven or Gradle


## Installation

### 1. Clone the repository

git clone https://github.com/yourusername/custom-encryption-annotation.git
cd custom-encryption-annotation

### 2. Build the project
If you're using Maven, you can build the project by running:

## For yml: 
 mvn clean install

## For Gradle:
 gradle build

### 3. Run the project
once the project is built, you can run the Spring Boot application:

 mvn spring-boot:run

## Or with Gradle:
 gradle bootRun

Usage
Applying the @Encrypt Annotation
You can use the @EncryptDecrypt annotation on fields or methods that require encryption and decryption.

For example:

java
Copy code
import com.example.security.Encrypt;

 public class User {

    @Encrypt
    private String sensitiveData;

    // getters and setters
}

When data is passed to the annotated field or method, will automatically encrypt the data before proceeding.

Example of Encryption
You can call methods where encryption is required like this:

java
Copy code
public void saveUser(User user) {
    // The sensitiveData field will be encrypted automatically
    userRepository.save(user);
}

How It Works
The @Encrypt annotation is used to mark fields or methods that need to be encrypted.
An aspect class, EncryptionAspect, intercepts methods or fields annotated with @Encrypt and applies AES encryption via the EncryptionService.
Key Components
Custom Annotation: @EncryptDecrypt is a custom annotation for marking fields/methods.
EncryptionService: Handles encryption logic using AES.
EncryptionAspect: Intercepts annotated fields/methods and triggers encryption.
Encryption Algorithm
This project uses the AES (Advanced Encryption Standard) algorithm to encrypt string data. The encryption key is managed within the EncryptionService and can be customized to fit your security needs.

Here’s a simplified version of the encryption logic:

java
Copy code
private static final String ALGORITHM = "AES";

private SecretKey generateKey() {
    return new SecretKeySpec("MySuperSecretKey".getBytes(), ALGORITHM);
}
Contributing
If you would like to contribute to this project, feel free to submit a pull request. Any improvements to the encryption logic or additional features are welcome.

License
This project is licensed under the MIT License - see the LICENSE file for details.


### Instructions for use:
- Save this file as `README.md` in the root directory of your project.


