package com.petshop.petshop.security.controller;

import com.petshop.petshop.model.security.model.User;
import com.petshop.petshop.security.dto.UserDto;
import com.petshop.petshop.security.service.UserService;
import org.dozer.DozerBeanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SignUpController {

    private final UserService defaultUserService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Method for create User.
     *
     * @param dto UserDto dto.
     * @return UserDto response from created User.
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody final UserDto dto) {

        final User userToSave = dozerBeanMapper.map(dto, User.class);

        final User userToResponse = defaultUserService.create(userToSave);

        final UserDto response = dozerBeanMapper.map(userToResponse, UserDto.class);

        return ResponseEntity.ok().body(response);
    }
}
