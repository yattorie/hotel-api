package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.entity.user.User;
import com.orlovandrei.hotel.repository.UserRepository;
import com.orlovandrei.hotel.service.UserService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.USER_CONSTRUCTED.getMessage());
    }

    @Override
    public boolean existsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(ServiceMessages.USER_NOT_FOUND_USERNAME.getMessage() + username));
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.USER_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.USER_NOT_FOUND_USERNAME.getMessage() + username));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.USER_NOT_FOUND_EMAIL.getMessage() + email));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User create(User user) {
        if (existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException(ServiceMessages.USERNAME.getMessage() + user.getUsername() + ServiceMessages.IS_ALREADY_TAKEN.getMessage());
        }
        if (existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException(ServiceMessages.EMAIL.getMessage() + user.getEmail() + ServiceMessages.IS_ALREADY_TAKEN.getMessage());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.USER_NOT_FOUND.getMessage() + id));

        if (!existingUser.getUsername().equals(user.getUsername()) && existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException(ServiceMessages.USERNAME.getMessage() + user.getUsername() + ServiceMessages.IS_ALREADY_TAKEN.getMessage());
        }
        if (!existingUser.getEmail().equals(user.getEmail()) && existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException(ServiceMessages.EMAIL.getMessage() + user.getEmail() + ServiceMessages.IS_ALREADY_TAKEN.getMessage());
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.USER_NOT_FOUND.getMessage() +id);
        }
        userRepository.deleteById(id);
    }

}
