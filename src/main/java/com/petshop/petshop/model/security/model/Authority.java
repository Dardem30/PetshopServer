package com.petshop.petshop.model.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Entity that describes the authority.
 */
@Entity
@Data
@Table(name = "authorities")
@SuppressWarnings("PMD.AvoidFieldNameMatchingTypeName")
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -4031273181701977660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer id;

    @Column(name = "authority")
    private String authority;

    @Column(name = "user_id")
    private Integer userId;
}
