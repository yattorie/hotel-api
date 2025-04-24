package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Transactional(readOnly = true)
    User getById(Long id);

    @Transactional(readOnly = true)
    User getByUsername(String username);

    @Transactional(readOnly = true)
    User getByEmail(String email);

//    @Transactional
//    User create(User user);
//
//    @Transactional
//    User update(Long id, User user);

    @Transactional(readOnly = true)
    List<User> getAll();

    @Transactional
    User create(User user);

    @Transactional
    User update(Long id, User user);

    @Transactional
    void delete(Long id);
}
