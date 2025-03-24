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
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User getUser(String username) {

    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
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
