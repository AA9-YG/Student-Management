package com.binaryAA.StudentManagement.service;

import com.binaryAA.StudentManagement.entity.User;
import com.binaryAA.StudentManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);

        org.springframework.security.core.userdetails.User
                .UserBuilder userBuilder = null;

        if (user.isPresent()) {
            User currentUser = user.get();
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(currentUser.getPassword());
            userBuilder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException(username);
        }

        return userBuilder.build();
    }
}
