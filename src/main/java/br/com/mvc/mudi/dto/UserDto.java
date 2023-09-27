package br.com.mvc.mudi.dto;

import java.util.List;
import java.time.LocalDate;

import lombok.Builder;

@Builder
public record UserDto (
    Integer id,
    String username,
    List<AuthorityDto> authorities,
    Boolean accountNonExpired,
    Boolean accountNonLocked,
    Boolean credentialsNonExpired,
    Boolean enabled,
    String firstName,
    String lastName,
    String emailAddress,
    LocalDate birthdate) {}