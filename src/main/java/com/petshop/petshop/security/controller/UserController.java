package com.petshop.petshop.security.controller;

import com.petshop.petshop.model.security.model.User;
import com.petshop.petshop.security.dto.UserDto;
import com.petshop.petshop.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest Controller for User.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Method for create new User.
     *
     * @param userDto UserDto userDto.
     * @return UserDto response from created User.
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final UserDto userDto) {

        final User userToSave = dozerBeanMapper.map(userDto, User.class);

        final User savedUser = userService.create(userToSave);

        final UserDto response = dozerBeanMapper.map(savedUser, UserDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Method for update User from database.
     *
     * @param userDto UserDto userDto.
     * @return UserDto response from updated User.
     */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody final UserDto userDto) {

        final User userToUpdate = dozerBeanMapper.map(userDto, User.class);

        final User userToResponse = userService.update(userToUpdate);

        final UserDto response = dozerBeanMapper.map(userToResponse, UserDto.class);

        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity fetchAll() {
        final List<UserDto> response = new ArrayList<>();
        userService.listUsers()
                .forEach(user -> response.add(dozerBeanMapper.map(user, UserDto.class)));

        return ResponseEntity.ok().body(response);
    }

    /**
     * Method for fetch user by Id.
     *
     * @param userId User userId.
     * @return UserDto response from displayed User.
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity fetch(@PathVariable final Integer userId) {

        final User userToResponse = userService.fetch(userId);

        final UserDto response = dozerBeanMapper.map(userToResponse, UserDto.class);

        return ResponseEntity.ok().body(response);
    }

    /**
     * Method for delete user by Id.
     *
     * @param userId User userId.
     * @return UserDto response from deleted User.
     */
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable final Integer userId) {

        final User userToResponse = userService.fetch(userId);

        userService.delete(userId);

        final UserDto response = dozerBeanMapper.map(userToResponse, UserDto.class);

        return ResponseEntity.ok().body(response);
    }
}
