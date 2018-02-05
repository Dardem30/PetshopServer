package com.petshop.petshop.security.service.detail;

import com.petshop.petshop.model.security.model.User;
import com.petshop.petshop.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class that implements the UserDetailsService.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final Optional<User> user = Optional.ofNullable(userService.getUserByUsername(username));

        if (user.isPresent()) {

            return user.get();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
