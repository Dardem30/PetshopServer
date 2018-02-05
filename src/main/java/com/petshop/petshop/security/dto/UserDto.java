package com.petshop.petshop.security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * * Intermediate class of User and controller work.
 */
@Data
@JsonTypeName(value = "user")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = 5381524464602378056L;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private List<AuthorityDto> authorities;
}
