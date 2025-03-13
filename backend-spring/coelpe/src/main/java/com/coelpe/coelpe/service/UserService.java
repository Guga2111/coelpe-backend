package com.coelpe.coelpe.service;

import com.coelpe.coelpe.entity.User;
import com.coelpe.coelpe.exception.UserNotFoundException;
import com.coelpe.coelpe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        User unwrapUser = unwrapUser(user, id);

        return userRepository.save(unwrapUser);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if(entity.isPresent()) return entity.get();
        else throw new UserNotFoundException(id);
    }
}
