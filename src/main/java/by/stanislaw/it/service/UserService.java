package by.stanislaw.it.service;

import by.stanislaw.it.encoder.PasswordEncoder;
import by.stanislaw.it.entity.User;
import by.stanislaw.it.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private void save(User user) {
        userRepository.save(user);

    }

    public void save(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(PasswordEncoder.encodePassword(password));
        user.setRole(role);
        save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Optional<User> getUserById(String id){
        return userRepository.findById(id);
    }

    public void updateUserPathToImage(String path,String id){
        userRepository.updateUserPathToImageById(path,id);
    }



}
