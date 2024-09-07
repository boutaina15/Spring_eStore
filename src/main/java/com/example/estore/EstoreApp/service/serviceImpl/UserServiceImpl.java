package com.example.estore.EstoreApp.service.serviceImpl;

import com.example.estore.EstoreApp.dao.UserRepository;
import com.example.estore.EstoreApp.entities.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " +userId+" does not exists");
        }
        userRepository.deleteById(userId);
        System.out.println("the user with id : "+userId+ " has been deleted succefully");

    }

    @Transactional
    public User updateUser(Long userId, User userreq) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user does not exists"));
        if (user != null){
            user.setCreated_at(userreq.getCreated_at());
            user.setAddress(userreq.getAddress());
            user.setEmail(userreq.getEmail());
            user.setPassword(userreq.getPassword());
            user.setFirstName(userreq.getFirstName());
            user.setLastName(userreq.getLastName());
            user.setPhoneNumber(userreq.getPhoneNumber());
            user.setUsername(userreq.getUsername());
            System.out.println("the user  has been updated succefully");

        }
        return userRepository.save(user);


    }
}
