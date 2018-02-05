package com.petshop.petshop.security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;

/**
 * Intermediate class of Authority and controller work.
 */
@Data
@JsonTypeName(value = "authority")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorityDto implements Serializable {

    private static final long serialVersionUID = -472846764698867871L;

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String authority;

    @JsonProperty
    private Integer userId;
}
