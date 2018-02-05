package com.petshop.petshop.security.controller;

import com.petshop.petshop.model.security.model.Authority;
import com.petshop.petshop.security.dto.AuthorityDto;
import com.petshop.petshop.security.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for Authority.
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorityController {

    private final AuthorityService authorityService;

    private final DozerBeanMapper dozerBeanMapper;

    /**
     * Method for update Authority.
     *
     * @param authorityDto AuthorityDto authorityDto.
     * @return AuthorityDto response from updated Authority.
     */
    @RequestMapping(value = "/authorities", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody final AuthorityDto authorityDto) {

        final Authority authorityToUpdate = dozerBeanMapper.map(authorityDto, Authority.class);

        final Authority authorityToResponse = authorityService.update(authorityToUpdate);

        final AuthorityDto response = dozerBeanMapper.map(authorityToResponse, AuthorityDto.class);

        return ResponseEntity.ok().body(response);
    }
}
