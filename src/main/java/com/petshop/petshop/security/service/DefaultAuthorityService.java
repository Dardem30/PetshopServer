package com.petshop.petshop.security.service;

import com.petshop.petshop.model.security.model.Authority;
import com.petshop.petshop.security.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class that implements the Authority's work and databases.
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultAuthorityService implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority create(final Authority authority) {

        log.info("Authority created.");

        return authorityRepository.save(authority);
    }

    @Override
    public Authority update(final Authority authority) {

        log.info("Authority updated.");

        final Authority saved = authorityRepository.findOne(authority.getId());

        authority.setAuthority(authority.getAuthority() == null
                ? saved.getAuthority() : authority.getAuthority());
        authority.setUserId(saved.getUserId());

        return authorityRepository.save(authority);
    }
}
