package com.petshop.petshop.security.service;

import com.petshop.petshop.model.security.model.Authority;
import com.petshop.petshop.model.security.model.AuthorityType;
import com.petshop.petshop.model.security.model.User;
import com.petshop.petshop.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Class that implements the User's work and databases.
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    private final AuthorityService authorityService;

    @Override
    public User create(final User user) {

        log.info("User created.");

        Authority authority = new Authority();
        authority.setAuthority(AuthorityType.PAT.toString());

        authority = authorityService.create(authority);

        user.setAuthorities(Collections.singletonList(authority));
        return userRepository.save(user);
    }

    @Override
    public User update(final User user) {

        log.info("User updated.");

        final User saved = userRepository.findOne(user.getId());

        user.setUsername(saved.getUsername());

        user.setAuthorities(saved.getAuthorities());

        user.setPassword(user.getPassword() == null ? saved.getPassword() : user.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(final Integer id) {

        log.info("User deleted.");

        userRepository.delete(id);
    }

    @Override
    public User getUserByUsername(final String username) {

        log.info("User received by username");

        User getUser = userRepository.findByUsername(username);

        return getUser;
    }

    @Override
    public User fetch(final Integer id) {

        log.info("User received by id");

        return userRepository.findOne(id);
    }

    @Override
    public List<User> listUsers() {

        log.info("All users displayed");

        return userRepository.findAll();
    }
}
